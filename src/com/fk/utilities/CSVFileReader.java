package com.fk.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class CSVFileReader {
	public String filePath = "";
	private CSVReader csv;
	private File file;
	private FileReader fr;
	private BufferedReader br;
	private String s;

	public CSVFileReader(String filePath) {
		this.filePath = filePath;
		this.file = new File(filePath);
	}

	private void setUpConnection() throws IOException {
		fr = new FileReader(file);
		br = new BufferedReader(fr);
	}

	private int[] noOfLinesinFile() throws IOException {
		setUpConnection();
		int[] data = new int[2];
		// data[0] represents no of lines
		// data[1] represents no of CSV values
		while ((s = br.readLine()) != null) {
			data[0]++;
			String[] csvvalues = s.split(",");
		//	System.out.println(Arrays.deepToString(csvvalues));
			data[1] = csvvalues.length;
		}
		return data;
	}

	public Object[][] getDataFromCSV() throws IOException {
		Object[][] data = new Object[noOfLinesinFile()[0]][noOfLinesinFile()[1]];
		csv = new CSVReader(new FileReader(filePath));
		Object[] csvCell;
		int i = 0;
		while ((csvCell = csv.readNext()) != null) {
			for (; i < data.length;) {
				for (int j = 0; j < csvCell.length; j++) {
					data[i][j] = csvCell[j];
				}
				i++;
				break;
			}
		}
		return data;
	}
}