package readexcel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class KeywordLibrary {
	static String result ;
	static WebDriver driver;
	
	public static void callMethods(String MethodName,String param1, String param2, String param3  ) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method = KeywordLibrary.class.getMethod(MethodName, String.class,String.class,String.class);
		method.invoke(MethodName, param1,  param2,  param3);
	}

	
	public static void EnterText(String param1, String param2, String param3 ){
		try{
		driver.findElement(By.name(param2)).sendKeys(param3);
		result = "pass";
		}
		
		catch(Exception e){
			result = "fail";
			System.out.println("error while using ");
		}
		
	}
	

public static void Clickbuton(String param1, String param2, String param3){
	
	try{
switch(param1)	{
case "name": 
	      driver.findElement(By.name(param2)).click();
	      break; }
result = "pass";
}catch(Exception e){
	result = "fail";
	System.out.println("error in click button");
}
}
public static void OpenBrowser(String param1, String param2, String param3) throws InterruptedException{
	try{
	if(param1.equals("chrome"))
	{System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mangesh\\Downloads\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();		
	driver.get(param2);
	Thread.sleep(5000);
	result = "pass";
	}}
	catch(Exception e){
		result = "fail";
		System.out.println("open browser failure");
	}
}

public static void DropDown(String param1, String param2, String param3){
	
	Select select = new Select(driver.findElement(By.name(param2)));
	select.selectByVisibleText(param3);
}
public static void RadioButton(String param1, String param2, String param3){
	List<WebElement> radios = driver.findElements(By.name(param2));
			//driver.findElements(By.xpath("//input[@name='tripType']"));
			
	for(int i=0;i<radios.size();i++){
		if(radios.get(i).getAttribute("value").equals(param3)){
			radios.get(i).click();
		}}}	
	public static void Continue(String param1, String param2, String param3){
		driver.findElement(By.name(param2)).click();
	}
	
}
