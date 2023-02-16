package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//input[contains(@placeholder,'Search for products')]")
	private WebElement searchbar;
	
	@FindBy(xpath="//a[@class='desktop-submit']")
	private WebElement searchicon;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void sendMobiles() {
		searchbar.sendKeys("OnePlus Mobiles");
		
	}
	public void clickOnSearchIcon() {
		searchicon.click();
		
	}

	
}
