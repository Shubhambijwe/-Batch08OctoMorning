package testPack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.AddToCartPage;
import POM.HomePage;

public class TestNGClass {
	
	
	WebDriver driver;
	@BeforeClass
	public void openHomePage(){
	System.out.println("Before Class");	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Hp\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	}
	
	@BeforeMethod
	public void homePage() {
		System.out.println("Before Method");
		driver.get("https://www.myntra.com/");
		
		HomePage homePage=new HomePage(driver);
		homePage.sendMobiles();
		homePage.clickOnSearchIcon();
		
		ArrayList<String>addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(0));
		
		AddToCartPage addToCartPage=new AddToCartPage(driver);
		addToCartPage.clickOnMobiles();

	}
	
	@Test (priority=1)
	public void verifyHomePage() {
		System.out.println("Test-1");
		
		HomePage homePage=new HomePage(driver);		
		homePage.clickOnSearchIcon();	
		
		String actualURL=driver.getCurrentUrl();
		String actualTitle=driver.getTitle();
		
		String expectedURL="https://www.myntra.com/oneplus-mobiles";
		String expectedTitle="Oneplus Mobile - Buy Oneplus Mobile online in India";
		
		if(actualURL.equals(expectedURL)&& actualTitle.equals(expectedTitle))
		{
			System.out.println("PASSED");
		}
		else 
		{
			System.out.println("FAILED");
		}
		
}
	@Test (priority=2)
	public void verifyAddToCartPage() {
		System.out.println("Test-2");
		
		AddToCartPage addToCartPage=new AddToCartPage(driver);
		addToCartPage.clickOnMobiles();
		
		
		String actualURL=driver.getCurrentUrl();
		String actualTitle=driver.getTitle();
		
		String expectedURL="https://www.myntra.com/mobile-accessories/karwan/karwan-oneplus-nord-mobile-phone-back-case/21339728/buy";
		
		String expectedTitle="Buy Karwan OnePlus Nord Mobile Phone Back Case  - Mobile Accessories for Unisex 21339728 | Myntra";
		
		if(actualURL.equals(expectedURL)&& actualTitle.equals(expectedTitle))
		{
			System.out.println("PASSED");
		}
		else 
		{
			System.out.println("FAILED");
		}
		
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		System.out.println("After Method");
		
	
		ArrayList<String>addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));		
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

