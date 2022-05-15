package calculator.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	
	// This function reads test data from excel file
	@DataProvider(name="testdata")
	public String[][] getData(Method m) throws IOException{
		
		String excelSheetName = m.getName();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/calculator/TestData/Values.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		int totalRows = sheetName.getLastRowNum();
		Row rowCells = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		DataFormatter format = new DataFormatter();
		
		String testData[][] = new String[totalRows][totalCols];
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
			}
		}
		return testData;
	}
	
}
