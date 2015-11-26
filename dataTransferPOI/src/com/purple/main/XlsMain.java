package com.purple.main;

import com.blue.log.TimeCount;
import com.purple.constants.KeyText;
import com.purple.whst.WHSTAnalyzer;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This is the main class for execution
 * Created by applec on 15/11/25.
 */
public class XlsMain {
	public static void main(String[] args) throws IOException, InterruptedException {
		TimeCount.initTimeCountStub();

		new WHSTAnalyzer().analyzeWHST();

		TimeCount.putTimeCountStubAndGetMsg(0);
	}





}
