package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utili {
	public static String getdatafromExcelsheet(String sheet, int row, int cell) throws IOException
	{
		String path="src/test/resources/ExcelSheet/NPtestda.xlsx";
		FileInputStream file = new FileInputStream(path);
		Cell cellnum=WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell);
		String data;
		try
		{
			data=cellnum.getStringCellValue();
		}
		catch(Exception e)
		{
			int a=(int) cellnum.getNumericCellValue();
			String str=Integer.toString(a);
			data= str;	
		}
		return data;
		
	}
	
	public static void  capturescreenshots(WebDriver driver,  String testId) throws IOException
	{
		TakesScreenshot ss= (TakesScreenshot)driver;
		SimpleDateFormat mydate=new SimpleDateFormat("dd MM yyyy HH mm ss");
		Date d= new Date();
		String f=mydate.format(d);
		File src=ss.getScreenshotAs(OutputType.FILE);
		File des= new File("test-output//Screenshots//jay"+f+".png");
		FileHandler.copy(src,des);
		
	}
	
}
