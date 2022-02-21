package com.n11.stepDefs;

import com.n11.pages.HomePage;
import com.n11.pages.MarkalarPages;
import com.n11.utility.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FooterMenuStepDef {

	PageManager pageManager = new PageManager();
	HomePage homePage = pageManager.getHomePage();
	MarkalarPages markalarPages = pageManager.getMarkalarPages();

	@Given("I write all the footer links to a text file")
	public void i_write_all_the_footer_links_to_a_text_file() {
		homePage.writeFooterLinksToFile();
	}

	@When("I click on {string} at the footer")
	public void i_click_on_at_the_footer(String footerLink) {
		homePage.navigateToPage(footerLink);
	}

	@Then("footer links must be the same as the text file")
	public void footer_links_must_be_the_same_as_the_text_file() {
		markalarPages.verifyFooterContent();
	}


}
