package testDataHandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class fetchExcelData {
	//Identify TestData column by scanning the entire 1st row
	//once column is identified then scan entire testData column to identify Employee testData row
	//after you grab Employee testData row = pull all the data of that row and feed into test

	public ArrayList<String> GetTestData(String testCaseName) throws IOException {


		ArrayList<String> TestDataList = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("F:\\Selenium\\chrome\\TestDatas.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetCount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("SampleData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				//Identify TestData column by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cell = firstRow.cellIterator();
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestData")) {
						column = k;
					}
					k++;
				}
				// System.out.println(column);
				// once column is identified, scan the entire TestData column to find Employee

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						//after you grab Employee testData row = pull all the data of that row and feed into test
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							TestDataList.add(c.getStringCellValue());

						}

					}

				}
			}

		}
		return TestDataList;
	}

	public static void main(String[] args) throws IOException {

		fetchExcelData excelData=new fetchExcelData();
		ArrayList<String> data= excelData.GetTestData("Employee");
		System.out.println(data.get(1) +" "+ data.get(2));
	}
}
