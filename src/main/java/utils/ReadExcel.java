package utils;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData(String fileName) throws IOException {
		
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx"); 
		
		XSSFSheet ws = wb.getSheetAt(0);
		
		int rowsCount = ws.getLastRowNum();
		
		
		int cellCount = ws.getRow(0).getLastCellNum();
	
		
		String[][] data = new String[rowsCount][cellCount];
		
		
		
		  for (int i = 1; i <= rowsCount; i++) {
		  
			for (int j = 0; j < cellCount; j++) {
		  
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
		  
				data[i - 1][j] = cellValue;
		 		  
		  
		  }
		  
		  
		  
	}
		  
		
		wb.close();
		
		
		return data;

	}

}
