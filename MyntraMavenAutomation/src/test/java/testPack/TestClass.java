package testPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import POM.AddToCartPage;
import POM.HomePage;

public class TestClass 
{
	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hp\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.myntra.com/");
		
		
		HomePage homePage=new HomePage(driver);
		
		homePage.sendMobiles();
		homePage.clickOnSearchIcon();
		
		AddToCartPage addToCartPage=new AddToCartPage(driver);
		addToCartPage.clickOnMobiles();
	
	
	
		
	}
}
