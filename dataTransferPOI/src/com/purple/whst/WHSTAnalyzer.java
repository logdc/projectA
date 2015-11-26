package com.purple.whst;

import com.blue.utils.StringUtil;
import com.purple.common.XlsxUtil;
import com.purple.constants.KeyText;
import com.purple.pojo.Shop;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

	public static List<String> wcfTypeList1 = new ArrayList<String>();
	public static List<String> wcfTypeList2 = new ArrayList<String>();
	public static Map<Shop, List<Double>> wcfTypeVolumesMap = new HashMap<Shop, List<Double>>();
	public static Map<Shop, List<Double>> wcfTypeValuesMap = new HashMap<Shop, List<Double>>();
	private static int eachWcfRowIdIndex = 0;
	private static int eachWcfRowNameIndex = 0;
	private static int eachWcfRowNum1Index = 0;
	private static int eachWcfRowNum2Index = 0;
	private static int wcfrowIndex = 0;

	private void analyzeSheetWCF(XSSFSheet xssfSheet){
		if(xssfSheet == null){
			return;
		}

		collectWCFSheetFormatInfo(xssfSheet);

		for(int rowNum = wcfrowIndex; rowNum <= xssfSheet.getLastRowNum(); rowNum ++){
			XSSFRow xssfRow = xssfSheet.getRow(rowNum);
			if (xssfRow == null) {
				continue;
			}
			String rowId = XlsxUtil.getXSSFCellValue(xssfRow.getCell(eachWcfRowIdIndex));
			if(StringUtil.isNullOrEmtpy(rowId)){
				break;
			}


			for(int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum ++) {
				XSSFCell xssfCell = xssfRow.getCell(cellNum);
				String cellValue = XlsxUtil.getXSSFCellValue(xssfCell);
			}

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
					break l1;
				}
				if(StringUtil.nullCheckedContains(cellValue, KeyText.CORNER_WHST_WCF_TITLE_STR)){
					startCollectTitle1 = true;
					startCollectTitle2 = false;
					eachWcfRowIdIndex = cellNum - 1;
					eachWcfRowNameIndex = cellNum;
					eachWcfRowNum1Index = cellNum + 1;
					wcfrowIndex = rowNum + 2;
				}
				if(StringUtil.nullCheckedContains(cellValue, KeyText.CORNER_WHST_WCF_TITLE_STR2)
						&& !startCollectTitle2){
					startCollectTitle1 = false;
					startCollectTitle2 = true;
					eachWcfRowNum2Index = cellNum + 1;
				}
			}

		}
	}

}
