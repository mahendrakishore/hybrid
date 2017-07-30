package readexcel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Execution {
	
	

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		// TODO Auto-generated method stub
		ReadExcelMap readmap = new ReadExcelMap();
		Map<Integer,String> readIndex = readmap.readIndex("Index");
		for(int j=0;j<readIndex.size();j++){
			String sheetName = readIndex.get(j);
			HashMap<Integer,ArrayList<String>> readmapval=readmap.readExcel(sheetName);		
			//HashMap<Integer,ArrayList<String>> readmapval=readmap.readExcel("Sheet1");		
		for(int i = 0; i<readmapval.size();i++){
			ArrayList<String>  templist = readmapval.get(i);
			KeywordLibrary.callMethods(templist.get(0),templist.get(1),templist.get(2),templist.get(3));
			readmap.writeExcel(KeywordLibrary.result, "Sheet1", i);
		}
		/*KeywordLibrary.callMethods("OpenBrowser", "chrome", "http://newtours.demoaut.com/", "null");
		KeywordLibrary.callMethods("EnterText", "name", "userName", "batman1");
		KeywordLibrary.callMethods("EnterText", "name", "password", "batman1");
		KeywordLibrary.callMethods("Clickbuton", "name", "login", "null");*/
	}
		
		
	}
	
	

}
