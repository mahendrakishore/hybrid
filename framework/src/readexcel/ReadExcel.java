package readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class ReadExcel {
	
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\Mangesh\\Desktop\\data.xls");
		FileInputStream fis = new FileInputStream(file);//to lock the file while using
		HSSFWorkbook  wb = new HSSFWorkbook(fis);
		Sheet sheets = wb.getSheet("Sheet1");
		int rowlast = sheets.getLastRowNum();
		Row rows;
		Cell cells;
		
		for(int i=0;i<=rowlast;i++){	
			ArrayList<String> list = new ArrayList<String>();
			 rows = sheets.getRow(i);
			//System.out.println(rowlast);
			int rowcel = rows.getLastCellNum();
			for(int j=0;j<rowcel;j++){
				 cells = rows.getCell(j);	
				 list.add(cells.getStringCellValue());
				//System.out.println(cells.getStringCellValue());
			}		
			System.out.println(list);
			list.clear();
		}
			
		
		
	}

}
