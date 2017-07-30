package readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;




public class ReadExcelMap {
	
	public HashMap<Integer,String> readIndex(String sheet) throws IOException{
		File file = new File("C:\\Users\\Mangesh\\Desktop\\data.xls");
		FileInputStream fis = new FileInputStream(file);//to lock the file while using
		HSSFWorkbook  wb = new HSSFWorkbook(fis);
		Sheet sheets = wb.getSheet(sheet);
		Row rows= null;
		Cell cells;
		HashMap<Integer,String> map= new HashMap<Integer,String>();
		for(int i=0;i<=sheets.getLastRowNum();i++){	
			int rowcel = rows.getLastCellNum();
			 cells = rows.getCell(0);
			map.put(i,cells.getStringCellValue() );
		}
		
		return (map);
	}

	
	
	public HashMap<Integer,ArrayList<String>> readExcel(String sheet) throws IOException   {
		File file = new File("C:\\Users\\Mangesh\\Desktop\\data.xls");
		FileInputStream fis = new FileInputStream(file);//to lock the file while using
		HSSFWorkbook  wb = new HSSFWorkbook(fis);
		Sheet sheets = wb.getSheet(sheet);
		Row rows;
		Cell cells;
		HashMap<Integer,ArrayList<String>> map= new HashMap<Integer,ArrayList<String>>();
		for(int i=0;i<=sheets.getLastRowNum();i++){	
			ArrayList<String> list = new ArrayList<String>();
			 rows = sheets.getRow(i);
			//System.out.println(rowlast);
			int rowcel = rows.getLastCellNum();
			for(int j=0;j<rowcel;j++){
				 cells = rows.getCell(j);	
				 list.add(cells.getStringCellValue());
				 
				//System.out.println(cells.getStringCellValue());
			}	
			map.put(i, list);
			//System.out.println(list);
			//list.clear();
		}
			
		//System.out.println(map);
		return (map);
		
	}

	public void writeExcel(String result,String sheetName,int rowNum) throws IOException{
		File file = new File("C:\\Users\\Mangesh\\Desktop\\data.xls");
		FileInputStream fis = new FileInputStream(file);
	  HSSFWorkbook wb = new HSSFWorkbook(fis);
	  
	  
	  Sheet sheets = wb.getSheet(sheetName);
	  Row rows  = sheets.getRow(rowNum);
	  Cell cells = rows.createCell(4);
	  cells.setCellValue(result);
	  
	  FileOutputStream fos = new FileOutputStream(file);
	  wb.write(fos);
	}
}
