package com.purple.whst;

import com.blue.utils.StringUtil;
import com.purple.common.XlsxUtil;
import com.purple.constants.KeyText;
import com.purple.pojo.Shop;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * analysis module for WHST file
 * Created by applec on 15/11/26.
 */
public class WHSTAnalyzer {


	public void analyzeWHST() throws IOException {
		InputStream is = new FileInputStream("/Users/applec/Desktop/WHS-T.xlsx");

		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

		// loop sheet
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null || xssfSheet.getSheetName().startsWith("_")) {
				continue;
			}
			String sheetName = xssfSheet.getSheetName();

			System.out.println("Start analysis - Sheet "+(numSheet + 1)+" name = [" + sheetName + "]");

			// analysis each sheet
			if (StringUtil.nullCheckedStartWith(sheetName, "HD")) {
				analyzeSheetHD(xssfSheet);
			} else if (StringUtil.nullCheckedStartWith(sheetName, "SNK")) {
				analyzeSheetSNK(xssfSheet);
			} else if (StringUtil.nullCheckedStartWith(sheetName, "WCF")) {
				analyzeSheetWCF(xssfSheet);
			}

		}
		is.close();
	}

	private void analyzeSheetHD(XSSFSheet xssfSheet){

	}

	private void analyzeSheetSNK(XSSFSheet xssfSheet){

	}

	// TODO try to extract a bean to handle organized data
	public static List<String> wcfTypeList1 = new ArrayList<String>();// data field title 1
	public static List<String> wcfTypeList2 = new ArrayList<String>();// data field title 2
	public static Map<Shop, List<Double>> wcfTypeVolumesMap = new HashMap<Shop, List<Double>>();
	public static Map<Shop, List<Double>> wcfTypeValuesMap = new HashMap<Shop, List<Double>>();
	private static int eachWcfRowCodeIndex = 0;
	private static int eachWcfRowNameIndex = 0;
	private static int eachWcfRowNum1StartIndex = 0;
	private static int eachWcfRowNum1EndIndex = 0;
	private static int eachWcfRowNum2StartIndex = 0;
	private static int eachWcfRowNum2EndIndex = 0;
	private static int wcfRowIndex = 0;

	private void analyzeSheetWCF(XSSFSheet xssfSheet){
		if(xssfSheet == null){
			return;
		}

		collectWCFSheetFormatInfo(xssfSheet);

		buildWCFSheetData(xssfSheet);

		/*/ TODO remove these code as it just test for create new xslx
		XSSFWorkbook newWorkbook = new XSSFWorkbook();
		XSSFSheet newXssfSheet = newWorkbook.createSheet("aaa");
		XSSFRow firstrow = newXssfSheet.createRow(0); // start with 0

		firstrow.createCell(0).setCellValue(new XSSFRichTextString("fdsff"));
		firstrow.createCell(1).setCellValue(new XSSFRichTextString("fdsff"));
		firstrow.createCell(2).setCellValue(new XSSFRichTextString("fdsff"));

		OutputStream out = null;
		try {
			out = new FileOutputStream("/Users/applec/Desktop/aaaa.xlsx");
			newWorkbook.write(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/

		System.out.println("###");
	}

	private void buildWCFSheetData(XSSFSheet xssfSheet) {
		for(int rowNum = wcfRowIndex;
		    rowNum <= XlsxUtil.lastOneIndexForLoop(wcfRowIndex, xssfSheet.getLastRowNum());
		    rowNum ++){
			XSSFRow xssfRow = xssfSheet.getRow(rowNum);
			if (xssfRow == null) {
				continue;
			}

			// fetch code & name
			String wcfRowCode = XlsxUtil.getXSSFCellValue(xssfRow.getCell(eachWcfRowCodeIndex));
			// if no code found then treat it as last line, so end analysis of this sheet
			if(StringUtil.isNullOrEmtpy(wcfRowCode)){
				break;
			}

			String wcfRowName = XlsxUtil.getXSSFCellValue(xssfRow.getCell(eachWcfRowNameIndex));
			Shop shop = new Shop();
			shop.setCode(wcfRowCode);
			shop.setName(wcfRowName);

			// fetch data 1 & 2
			List<Double> wcfTypeVolumesList = new ArrayList<Double>();
			List<Double> wcfTypeValuesList = new ArrayList<Double>();

			for(int cellNum = eachWcfRowNum1StartIndex;
			    cellNum <= XlsxUtil.lastOneIndexForLoop(eachWcfRowNum1StartIndex, eachWcfRowNum1EndIndex);
			    cellNum ++) {
				XSSFCell xssfCell = xssfRow.getCell(cellNum);
				if(xssfCell == null){
					continue;
				}
				String cellValue = XlsxUtil.getXSSFCellValue(xssfCell);
				try{
					wcfTypeVolumesList.add(Double.parseDouble(cellValue));
				}catch (Exception e){
					// not number, should be an empty box
					wcfTypeVolumesList.add(0D);
				}
			}

			for(int cellNum = eachWcfRowNum2StartIndex;
			    cellNum <= XlsxUtil.lastOneIndexForLoop(eachWcfRowNum2StartIndex, eachWcfRowNum2EndIndex);
			    cellNum ++) {
				XSSFCell xssfCell = xssfRow.getCell(cellNum);
				if(xssfCell == null){
					continue;
				}
				String cellValue = XlsxUtil.getXSSFCellValue(xssfCell);
				try{
					wcfTypeValuesList.add(Double.parseDouble(cellValue));
				}catch (Exception e){
					// not number, should be an empty box
					wcfTypeValuesList.add(0D);
				}
			}

			wcfTypeVolumesMap.put(shop, wcfTypeVolumesList);
			wcfTypeValuesMap.put(shop, wcfTypeValuesList);

		}
	}

	@SuppressWarnings("ConstantConditions")
	private void collectWCFSheetFormatInfo(XSSFSheet xssfSheet) {
		boolean startCollectTitle1 = false;
		boolean startCollectTitle2 = false;
		l1: for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
			XSSFRow xssfRow = xssfSheet.getRow(rowNum);
			if (xssfRow == null) {
				continue;
			}
			for(int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum ++) {
				XSSFCell xssfCell = xssfRow.getCell(cellNum);
				String cellValue = XlsxUtil.getXSSFCellValue(xssfCell);

				if(startCollectTitle1
						&& !StringUtil.nullCheckedContains(cellValue, KeyText.CORNER_WHST_WCF_TITLE_STR2)){
					wcfTypeList1.add(cellValue);
				}else if (startCollectTitle2
						&& !StringUtil.nullCheckedContains(cellValue, KeyText.CORNER_WHST_WCF_TITLE_STR2)){
					wcfTypeList2.add(cellValue);
				}


				if(StringUtil.nullCheckedContains(cellValue, KeyText.CORNER_WHST_WCF_TITLE_STR2)
						&& startCollectTitle2){
//					startCollectTitle1 = false;
//					startCollectTitle2 = false;
					eachWcfRowNum2EndIndex = cellNum - 1;
					break l1;
				}
				if(StringUtil.nullCheckedContains(cellValue, KeyText.CORNER_WHST_WCF_TITLE_STR)){
					startCollectTitle1 = true;
					startCollectTitle2 = false;
					eachWcfRowCodeIndex = cellNum - 1;
					eachWcfRowNameIndex = cellNum;
					eachWcfRowNum1StartIndex = cellNum + 1;
					wcfRowIndex = rowNum + 2;
				}
				if(StringUtil.nullCheckedContains(cellValue, KeyText.CORNER_WHST_WCF_TITLE_STR2)
						&& !startCollectTitle2){
					startCollectTitle1 = false;
					startCollectTitle2 = true;
					eachWcfRowNum2StartIndex = cellNum + 1;
					eachWcfRowNum1EndIndex = cellNum - 1;
				}
			}

		}
	}

}
