package POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	
	@FindBy(xpath="(//img[@draggable='false'])[4]")
	private WebElement mobileCover;

	
	public AddToCartPage(WebDriver driver){
		PageFactory.initElements(driver, this);	
		
	}
	public void clickOnMobiles() {
		mobileCover.click();
	}

	
	
	
	
	
	
	
	

}
