package com.purple.common;

import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 * util class for handling xlsx data
 * Created by applec on 15/11/26.
 */
public class XlsxUtil {

	private XlsxUtil(){

	}

	/**
	 * get xlsx file cell value
	 * support for boolean/numeric/ to string
	 * @param xssfCell
	 * @return
	 */
	public static String getXSSFCellValue(XSSFCell xssfCell) {
		if(xssfCell == null){
			return null;
		}
		if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(xssfCell.getBooleanCellValue());
		} else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			return String.valueOf(xssfCell.getNumericCellValue());
		} else {
			// 返回字符串类型的值
			return String.valueOf(xssfCell.getStringCellValue());
		}
	}

	/**
	 * make sure loop won't dead
	 * @param first
	 * @param last
	 * @return
	 */
	public static int lastOneIndexForLoop(int first, int last){
//		int max = Integer.MAX_VALUE;
		if(first < 0)   first = 0;
		if(last < 0)    last = 0;
		if(first > last)    return 0;

		return last;
	}
}
