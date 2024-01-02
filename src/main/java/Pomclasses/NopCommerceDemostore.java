package Pomclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NopCommerceDemostore {

	@FindBy(xpath="//a[text()='Register']")
	private WebElement register;
	
	@FindBy(xpath="//input[@id='gender-male']")
	private WebElement male;
	
	@FindBy(xpath="//input[@id='FirstName']")
	private WebElement Fname;
	
	@FindBy(xpath="//input[@id='LastName']")
	private WebElement Lname;
	
	@FindBy(xpath="//select[@name='DateOfBirthDay']")
	private WebElement DOBDay;
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']")
	private WebElement DOBMonth;
	
	@FindBy(xpath="//select[@name='DateOfBirthYear']")
	private WebElement DOBYear;
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement Email;
	
	@FindBy(xpath="//input[@id='Company']")
	private WebElement Company;
	
	@FindBy(xpath="//input[@id='Newsletter']")
	private WebElement newsletter;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	private WebElement Confirmpassword;
	
	@FindBy(xpath="//button[@id='register-button']")
	private WebElement registerbutton;
	
	WebDriver driver;
	
	public NopCommerceDemostore (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectREGISTERfrommenubar()
	{
		register.click();
	}
	
	public void selectMALEradiobutton()
	{
		male.click();
	}
	
	public void EnterFirstname(String fname)
	{
		Fname.sendKeys(fname);
	}
	
	public void Enterlastname(String lname)
	{
		Lname.sendKeys(lname);
	}
	
	public void selectDobfromdropdown()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(DOBDay));
		
		Select day = new Select(DOBDay);
		day.selectByValue("13");
		
		Select month = new Select(DOBMonth);
		month.selectByValue("6");
		
		Select year = new Select(DOBYear);
		year.selectByValue("1998");		
	}
	
	public void Enteremail(String email)
	{
		Email.sendKeys(email);
	}
	
	public void Entercompanyname(String cname)
	{
		Company.sendKeys(cname);
	}
	
	public void selectnewsletter()
	{
		Boolean result=newsletter.isSelected();
		if(result==true)
		{
			System.out.println(result);
		}
		else
		{
			newsletter.click();
		}
	}
	
	public void Enterpassword(String Password)
	{
		password.sendKeys(Password);
	}
	
	public void EnterRepassword(String confirmpassword)
	{
		Confirmpassword.sendKeys(confirmpassword);
	}
	
	public void selectregisterbutton()
	{
		registerbutton.click();
	}
	
	
	
	
	
	
	
	
	
	
}
