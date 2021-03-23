package io.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	
	public static Object[][] getExcelValues(String filename)
	{
		XSSFRow row;
		XSSFCell cell;
		Object[][] val = null ;
		
		try {
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\TestData"+filename+".xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet =  workbook.getSheetAt(0);
			
			int rownum= sheet.getLastRowNum();
			
			
			for(int i=1; i<rownum; i++)
			{
				row =  sheet.getRow(i);
				if(row!=null)
				{
				int cells = sheet.getRow(0).getLastCellNum();
				val = new String[rownum][cells];
				for(int j=0; j<cells; j++)
				{
					cell = row.getCell(j);
					if(cell!=null)
					{
						switch(cell.getCellType())
						{
						case XSSFCell.CELL_TYPE_NUMERIC:
							
							val[i][j] = cell.getNumericCellValue();
							break;
						case XSSFCell.CELL_TYPE_STRING:
							val[i][j] = cell.getStringCellValue();
							break;
						}
					}
				}
				}
			}
			
		
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
		
	}

}
