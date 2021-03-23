package io.google.pages;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.base.DriverInit;
import io.supplydata.Conditions;

public class GoogleLinkPage {
	
	static WebDriver driver;

	@FindBy(tagName = "a")
	static List<WebElement> links;
	
	@FindBy(xpath = "//a[contains(@href,'mail.google')]")
	WebElement gmaillink;
	
	@FindBy(css = "#identifierId")
	WebElement gmailid;
	
	
	public GoogleLinkPage clickGmail()
	{
		gmaillink.click();
		return this;
	}
	
	public GoogleLinkPage enterGmailID(JavascriptExecutor js)
	{
		if(gmailid.isEnabled())
		{
			js.executeScript("arguments[0].value='abc@gmail.com'", gmailid);
		}
		return this;
	}
	
	public static GoogleLinkPage init() {
		 DriverInit init= DriverInit.getinstance();
		  driver = init.initDriver();
		return PageFactory.initElements(driver, GoogleLinkPage.class);
		
	}
	
	
	 public void getTextOfLinks(Predicate<String> predicate)
	 {
		 List<String> val = links.stream().map(s->s.getText()).collect(Collectors.toList());
		 val.stream().filter(predicate).forEach(Conditions.GETTITLE);
	 }
	 
	 public int getCountofLinks()
	 {
		 int count = links.size();
		 System.out.println(count);
		 return count;
	 }
	 
	 public void SwitchandGetTitle(String switchURL)
		{
		
		 Actions actions = new Actions(driver);
		 actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
		 driver.get(switchURL);
		 
		Set<String>windowSet =  driver.getWindowHandles();
		windowSet.stream().forEach(s->System.out.println(driver.switchTo().window(s).getTitle()));
		}
	
	 
	 public GoogleLinkPage checkGmailfromGoogle(WebDriverWait wait)
	 {
		 
		 wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOf(gmaillink));
		 return this;
	 }




}
