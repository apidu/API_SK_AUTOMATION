package Excelintegration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchedDataFromExcel {

	public static void main(String[] args) {
		try {
			// Specify the path to your Excel file
			File f = new File("C:\\Users\\tavis\\Desktop\\data1.xlsx");

			// Create an input stream to read the file
			FileInputStream fis = new FileInputStream(f);

			// Create an XSSFWorkbook object using the file input stream
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// Access the first sheet of the workbook (sheet index 0)
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Create an object of DataFormatter to format the cell values
			DataFormatter formatter = new DataFormatter();

			// Fetch the value from the first cell (0, 0) in the first row (row 0)
			Object value = formatter.formatCellValue(sheet.getRow(0).getCell(0));

			// Convert the value to a string and print it
			String val = value.toString();
			System.out.println(val);

			// Close the workbook and file input stream
			workbook.close();
			fis.close();

		} catch (IOException e) {
			// Handle any IOException that occurs
			e.printStackTrace();
		}
	}

}
