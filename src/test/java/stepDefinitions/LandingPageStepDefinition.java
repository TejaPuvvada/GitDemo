package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import pageObjects.LandingPage;
import utils.TestBase;
import utils.TestContextSetup;

public class LandingPageStepDefinition {


public String ProductName2;
TestContextSetup testContextSetup;
LandingPage landingPage;
//Spring framework , EJB, picocontainer

public LandingPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
	this.landingPage=testContextSetup.pageObjectManager.getLandingPage();
}
	@Given("user is on Green Cart landing page") 
	public void user_is_on_green_cart_landing_page() {
		/*
		 * System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +
		 * "//Drivers/chromedriver.exe"); testContextSetup.driver=new ChromeDriver(); //
		 * driver gets life testContextSetup.driver.get(
		 * "https://rahulshettyacademy.com/seleniumPractise/#/");
		 */
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^user searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		//LandingPage landingPage=new LandingPage(testContextSetup.driver);
		
		landingPage.searchItem(shortName);
		
	    Thread.sleep(2000);
	    testContextSetup.ProductName1=landingPage.getProductName().split("-")[0].trim();
	    System.out.println(testContextSetup.ProductName1+" is extracted from homepage");
	}
	
	@When("Added {string} items of the selected product to the cart")
	public void Added_items_product(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		System.out.println("Added by Gitx");
		System.out.println("Added by Gitx");
		System.out.println("Added by Gitx");
	}

	
}
