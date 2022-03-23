package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

public String ProductName2;
TestContextSetup testContextSetup;
PageObjectManager pageObjectManager;
//single responsibiloity principle
//Loosely coupled
//Facory design pattern

public OfferPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
}

	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {
		switchToOffersPage();
		//OffersPage offersPage= new OffersPage(testContextSetup.driver);
		OffersPage offersPage=testContextSetup.pageObjectManager.OffersPage();
		offersPage.searchItem(shortName);
	    //testContextSetup.driver.findElement(By.id("search-field")).sendKeys(shortName);
	    Thread.sleep(2000);
	    ProductName2=offersPage.getProductName();
	    System.out.println(ProductName2+" is extracted from offers page");
	    
	}

	public void switchToOffersPage()
	{
		//pageObjectManager=new PageObjectManager(testContextSetup.driver);
		//LandingPage landingPage=pageObjectManager.getLandingPage();
		//LandingPage landingPage=new LandingPage(testContextSetup.driver);
		LandingPage landingPage=testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
	    testContextSetup.genericUtils.SwitchWindowToChild();
	}
	
	@Then("validate name in offers page matches with landing page")
	public void validate_name_in_offers_page_matches_with_landing_page() {
	    Assert.assertEquals("pass", ProductName2, testContextSetup.ProductName1);
	    System.out.println("Added");
	    System.out.println("Added");
	    System.out.println("Added");
	}
	
}
