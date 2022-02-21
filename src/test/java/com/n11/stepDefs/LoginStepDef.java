package com.n11.stepDefs;

import com.n11.pages.GirisYapPage;
import com.n11.pages.HomePage;
import com.n11.pages.LoginWithFacebookPage;
import com.n11.utility.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

	PageManager pageManager = new PageManager();
	HomePage homePage = pageManager.getHomePage();
	GirisYapPage girisYapPage = pageManager.getGirisYapPage();
	LoginWithFacebookPage loginWithFacebookPage = pageManager.getLoginWithFacebookPage();

	@Given("I navigate to home page")
	public void i_navigate_to_home_page() {
		homePage.navigateToHomePage();
	}

	@Given("I click on {string} button")
	public void i_click_on_button(String module) {
		homePage.navigateToPage(module);
	}

	@When("I try to log in through Facebook with valid credentials")
	public void i_try_to_log_in_through_facebook_with_valid_credentials() {
		girisYapPage.selectFacebook();
		loginWithFacebookPage.loginWithFacebook();
	}

	@Then("I should be logged in")
	public void i_should_be_logged_in() {
		homePage.verifyLogIn();
	}

	@Given("I logged in through Facebook")
	public void i_logged_in_through_Facebook() {
		homePage.navigateToHomePage();
		homePage.navigateToPage("Giriş Yap");
		girisYapPage.selectFacebook();
		loginWithFacebookPage.loginWithFacebook();
		homePage.verifyLogIn();
	}


}
