package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {

	public static Workbook book;
	public static Sheet sheet;

	public static Object[][] readdata(String sheetName) {
	    FileInputStream file = null;
	    try {
	        file = new FileInputStream("/Users/suseeharini/eclipse-workspace/HRmanagement/src/test/java/testdata/details.xlsx");
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }

	    try {
	        book = WorkbookFactory.create(file);
	    } catch (IOException a) {
	        a.printStackTrace();
	    }

	    sheet = book.getSheet(sheetName);
	    
	    
	    int rowCount = sheet.getLastRowNum() + 1;
	    int colCount = sheet.getRow(0).getLastCellNum();

	    List<Object[]> dataList = new ArrayList<>();
	    

	    for (int i = 0; i < rowCount; i++) {
	        Row row = sheet.getRow(i);
	        if (row != null) {
	            Object[] rowData = new Object[colCount]; // Create an array for the current row
	            boolean hasData = false;
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                if (cell != null && !cell.toString().isEmpty()) { // Check if cell has value
	                    rowData[j] = cell.toString(); // Store cell value in the array
	                    hasData = true;
	                }
	            }
	            if (hasData) {
	                dataList.add(rowData); // Add row data to the list only if it has data
	            }
	        }
	    }

	    // Convert list to 2D array
	    Object[][] data = new Object[dataList.size()][];
	    for (int i = 0; i < dataList.size(); i++) {
	        data[i] = dataList.get(i);
	    }
	    

		/*
		 * int rowCount = sheet.getLastRowNum() + 1; int colCount =
		 * sheet.getRow(0).getLastCellNum();
		 */

		/*
		 * Object[][] data = new Object[rowCount][colCount];
		 * 
		 * for (int i = 0; i < rowCount; i++) { Row row = sheet.getRow(i); if (row !=
		 * null) { for (int j = 0; j < colCount; j++) { Cell cell = row.getCell(j); if
		 * (cell != null) { data[i][j] = cell.toString(); } else { data[i][j] = ""; } }
		 * } }
		 */
	    return data;
	}

	/*
	 * public static Object[][] readdata(String Sheetname) { FileInputStream file =
	 * null; try { file = new FileInputStream(
	 * "/Users/suseeharini/eclipse-workspace/HRmanagement/src/test/java/testdata/details.xlsx"
	 * ); }
	 * 
	 * catch (FileNotFoundException e) { e.printStackTrace();
	 * 
	 * }
	 * 
	 * try { book = WorkbookFactory.create(file); } catch (IOException a) {
	 * a.printStackTrace(); }
	 * 
	 * sheet = book.getSheet(Sheetname);
	 * 
	 * Object[][] data = new
	 * Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 * 
	 * for (int i = 0; i <= sheet.getLastRowNum(); i++) {
	 * 
	 * for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) { if
	 * (sheet.getRow(i).getCell(k) != null) { data[i][k] =
	 * sheet.getRow(i).getCell(k).toString(); } else { data[i][k] = ""; // Or any
	 * default value you want to assign for null cells } } }
	 * 
	 * for (int i=0; i<sheet.getLastRowNum(); i++) {
	 * 
	 * for (int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
	 * 
	 * if (sheet.getRow(i + 1).getCell(k) != null) { data[i][k] = sheet.getRow(i +
	 * 1).getCell(k).toString(); } else { data[i][k] = ""; // Or any default value
	 * you want to assign for null cells }
	 * 
	 * 
	 * data[i][k]= sheet.getRow(i+1).getCell(k).toString();
	 * 
	 * } }
	 */
	

}
