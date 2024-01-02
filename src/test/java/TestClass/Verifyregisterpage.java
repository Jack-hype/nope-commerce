package TestClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.BrowserInitialise;
import Pomclasses.NopCommerceDemostore;
import Utility.Utili;

public class Verifyregisterpage extends BrowserInitialise {
	
private WebDriver driver;
private NopCommerceDemostore register;
private SoftAssert asrt;
private int row ;
private String testId;

@Parameters("multibrowser")

@BeforeTest
public void launchmultiplebrowsers(String browser)
{
	if(browser.equals("chrome"))
	{
		driver=ChromeBrowserLuanch();
	}
	if(browser.equals("edgebrowser"))
	{
		driver=EdgeBrowserLuanch();
	}
}

@BeforeClass
public void storebojectofpomclasses()
{
	 register=new NopCommerceDemostore(driver);
	 asrt=new SoftAssert();
}

@BeforeMethod
public void openapplication()
{
	driver.get("https://demo.nopcommerce.com/");
	//driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test(priority=0)
public void validatemsgforallblankfield() throws InterruptedException
{
	testId="tc_00";
	register.selectREGISTERfrommenubar();
	Thread.sleep(2000);
	register.selectregisterbutton();
	Thread.sleep(1000);
	
	String expectedmsg="First name is required.";
	WebElement actaulvalidatemsg= driver.findElement(By.xpath("//span[text()='First name is required.']"));
	String actmsg=actaulvalidatemsg.getText();
	asrt.assertEquals(expectedmsg,actmsg ,"validate message not show as per requirement");
	
	String expectedLnamemsg="Last name is required.";
	WebElement actaulvalidateLnamemsg= driver.findElement(By.xpath("//span[text()='Last name is required.']"));
	String actlname=actaulvalidateLnamemsg.getText();
	asrt.assertEquals(expectedLnamemsg,actlname ,"validate message not show as per requirement");
	
	String expectedemailmsg="Email is required.";
	WebElement actaulvalidateemailmsg= driver.findElement(By.xpath("//span[text()='Email is required.']"));
	asrt.assertEquals(expectedemailmsg,actaulvalidateemailmsg.getText() ,"validate message not show as per requirement");
	
	String expectedpasswordmsg="Password is required.";
	WebElement actaulvalidatepasswordmsg= driver.findElement(By.xpath("//span[text()='Password is required.']"));
	asrt.assertEquals(expectedpasswordmsg,actaulvalidatepasswordmsg.getText() ,"validate message not show as per requirement");
	asrt.assertAll();
	Thread.sleep(2000);
}

@Test(priority=1)
public void validateinvalidformatofallfields() throws IOException, InterruptedException
{
	testId="tc_01";
	register.selectREGISTERfrommenubar();
	Thread.sleep(2000);
	register.selectMALEradiobutton();
	Thread.sleep(2000);
	
	String FIRSTNAME=Utili.getdatafromExcelsheet("NCtestdata",row+1, 0);
	register.EnterFirstname(FIRSTNAME);
	row++;
	String expmsg="firstname should not accept numeric value";
	String actmsg="Fistname is accept numeric value";
	asrt.assertEquals(expmsg, actmsg);
	Thread.sleep(2000);
	 
	String LASTNAME=Utili.getdatafromExcelsheet("NCtestdata",row, 1);
	register.Enterlastname(LASTNAME);
	String expLnamemsg="lastname should not accept numeric value";
	String actLnamemsg="lastname is accept numeric value";
	asrt.assertEquals(expLnamemsg, actLnamemsg);
	
	register.selectDobfromdropdown();
	Thread.sleep(2000);
	 
	String EMAIL=Utili.getdatafromExcelsheet("NCtestdata",row, 2);
	register.Enteremail(EMAIL);
	Thread.sleep(2000);
	
	register.Entercompanyname("jayeshprivate ltd");
	Thread.sleep(2000);
	
	String expemailmsg="Wrong email";
	WebElement actemailmsg=driver.findElement(By.xpath("//span[text()='Wrong email']"));
	asrt.assertEquals(expemailmsg, actemailmsg.getText(), "if wrong email enter validate msg is Wrong email");
	 
	register.selectnewsletter();
	Thread.sleep(2000);
	 
	String PASSWORD=Utili.getdatafromExcelsheet("NCtestdata",row, 3);
	register.Enterpassword(PASSWORD);
	
	String REPASSWORD=Utili.getdatafromExcelsheet("NCtestdata",row, 4);
	register.EnterRepassword(REPASSWORD);
	String exppassmsg="must have at least 6 characters";
	WebElement actpassmsg=driver.findElement(By.xpath("//li[text()='must have at least 6 characters']"));
	asrt.assertEquals(exppassmsg,actpassmsg.getText() ,"password should be more than 6 character");
	Thread.sleep(2000);
	
	register.selectregisterbutton();
	String exprepassmsg="The password and confirmation password do not match.";
	WebElement actrepassmsg=driver.findElement(By.xpath("//span[text()='The password and confirmation password do not match.']"));
	asrt.assertEquals(exprepassmsg, actrepassmsg.getText());
	Thread.sleep(2000);
	 
	asrt.assertAll();
	
}

/*@Test(priority=2, invocationCount=7)
public void validateregistrationbyusingmultipledata() throws IOException, InterruptedException
{
	testId="tc_02";
	register.selectREGISTERfrommenubar();
	Thread.sleep(2000);
	 
	register.selectMALEradiobutton();
	Thread.sleep(2000);
	 
	String FIRSTName=Utili.getdatafromExcelsheet("NCtestdata",row+2, 0);
	register.EnterFirstname(FIRSTName);
	row++;
	Thread.sleep(2000);
	 
	
	String LASTName=Utili.getdatafromExcelsheet("NCtestdata",row, 1);
	register.Enterlastname(LASTName);
	Thread.sleep(2000);
	 
	register.selectDobfromdropdown();
	Thread.sleep(2000);
	 
	String EmaiL=Utili.getdatafromExcelsheet("NCtestdata",row, 2);
	register.Enteremail(EmaiL);
	Thread.sleep(2000);
	 
	register.Entercompanyname("jayeshprivate ltd");
	Thread.sleep(2000);
	 
	register.selectnewsletter();
	Thread.sleep(2000);
	 
	String PASSWord=Utili.getdatafromExcelsheet("NCtestdata",row, 3);
	register.Enterpassword(PASSWord);
	Thread.sleep(2000);
	 
	String REPASSWord=Utili.getdatafromExcelsheet("NCtestdata",row, 4);
	register.EnterRepassword(REPASSWord);
	Thread.sleep(2000);
	
	register.selectregisterbutton();
}*/

@AfterMethod
public void getscreenshotoffailtestcases(ITestResult result) throws IOException
{
	if(ITestResult.FAILURE==result.getStatus())
	{
		Utili.capturescreenshots(driver, "testId");
	}
}

@AfterClass
public void emptypomobjects()
{
	register=null;
	asrt=null;
}

@AfterTest
public void closebrowser()
{
	driver.close();
	driver.quit();
	driver=null;
	System.gc();
}
}


