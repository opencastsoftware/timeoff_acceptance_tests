package com.opencastsoftware.timeoff.acceptancetest.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginSteps {
	private WebDriver driver;
	
	@Given("^I access the homepage$")
	public void i_access_the_homepage() throws Throwable {
		
		driver = new ChromeDriver();
		driver.get("https://timeoff.opencastsoftware.com/");
	}

	@When("^I fill in valid email address and password$")
	public void i_fill_in_valid_email_address_and_password() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("jon.everett@opencastsoftware.com");
        driver.findElement(By.name("password")).sendKeys("Br!tann!a01");
        driver.findElement(By.id("submit")).click();
	}

	@Then("^I should be successfully logged into the homepage$")
	public void i_should_be_successfully_logged_into_the_homepage() throws Throwable {
		System.out.println(driver.getTitle());
	    Assert.assertEquals("Dashboard", driver.getTitle());
	}

	@Then("^I should see \"([^\"]*)\" at the top left hand corner$")
	public void i_should_see_at_the_top_left_hand_corner(String arg1) throws Throwable {
	    String text = driver.findElement(By.cssSelector(".navbar-left")).getText();
	    System.out.println(text);
	    Assert.assertTrue(text.contains(arg1));
	}
	
	@When("^I fill \"([^\"]*)\"  and \"([^\"]*)\"$")
	public void i_fill_and(String email, String password) throws Throwable {
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
	
	}
	
	@Then("^I should see error \"([^\"]*)\" displayed$")
	public void i_should_see_error_displayed(String arg1) throws Throwable {
		//String text = driver.findElement(By.cssSelector(".help-block")).getText();
		String text = driver.findElement(By.cssSelector("span[id$=error_0]")).getText();
		System.out.println(text);
	    Assert.assertTrue(text.contains(arg1));
	}
	
	@After
	public void after() {
		driver.quit();
	}
}
