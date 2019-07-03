package com.fk.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcel {
	String path = "";
	public XSSFWorkbook book, workbook;
	FileInputStream fis = null;
	public XSSFSheet sheet, outputsheet = null;
	public XSSFRow row, outputrow = null;
	public FileOutputStream fos;

	/*
	 * Parameterized constructor which takes excel file path as a String
	 */
	public GetDataFromExcel(String path, int index) throws IOException {
		this.path = path;
		this.fis = new FileInputStream(path);
		this.book = new XSSFWorkbook(fis);
		this.sheet = book.getSheetAt(index);
	}

	public int getRowsCount() {
		int rows = sheet.getLastRowNum() + 1;
		return rows;
	}

	public int getColumnCount() {
		row = sheet.getRow(0);
		int columns = row.getLastCellNum();
		return columns;
	}

	public Object[][] getData() {
		Object[][] obj = new Object[getRowsCount()][getColumnCount()];
		for (int i = 0; i < getRowsCount(); i++) {
			row = sheet.getRow(i);
			int columns = row.getLastCellNum();
			for (int j = 0; j < columns; j++) {
				obj[i][j] = row.getCell(j);
			}
		}
		return obj;
	}

	public void createSheet(String filePath, String sheetName) throws FileNotFoundException {
		fos = new FileOutputStream(filePath);
		workbook = new XSSFWorkbook();
		outputsheet = workbook.createSheet(sheetName);
	}

	public void writeData(int rows, int columns) throws IOException {
		for (int i = 0; i < rows; i++) {
			outputrow = sheet.createRow(i);
			for (int j = 0; j < columns; j++) {
				outputrow.createCell(j).setCellValue("Shashank");
			}
		}
		workbook.write(fos);
		fos.close();
	}
}