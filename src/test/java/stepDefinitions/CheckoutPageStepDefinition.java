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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestBase;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition 
{

	public String ProductName2;
	TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;
    //Spring framework , EJB, picocontainer

	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) 
	{
		this.testContextSetup = testContextSetup;
		this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo()
	{
		
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());	
	}
	
	
	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) throws InterruptedException
	{
		checkoutPage.CheckOutItems();
		//Thread.sleep(3000);
		//Assertion to extract name from screen and compare with name
	}

}
