package com.n11.stepDefs;

import com.n11.pages.*;
import com.n11.utility.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FavouritesStepDef {

	PageManager pageManager = new PageManager();
	HomePage homePage = pageManager.getHomePage();
	KozmetikPage kozmetikPage = pageManager.getKozmetikPage();
	ParfumDeoPage parfumDeoPage = pageManager.getParfumDeoPage();
	ProductDetailsPage productDetailsPage = pageManager.getProductDetailsPage();
	FavorilerimPage favorilerimPage = pageManager.getFavorilerimPage();

	@Given("I navigate to {string} under {string}")
	public void i_navigate_to_under(String module2, String module1) {
		homePage.navigateToPage(module1);
		kozmetikPage.navigateToPage(module2);
	}
	@Given("I searched for {string}")
	public void i_searched_for(String product) {
		parfumDeoPage.searchProduct(product);
	}
	@Given("I click {int} th item and added to Favorilerim")
	public void i_click_th_item_and_added_to_Favorilerim(int index) {
		parfumDeoPage.clickNthProduct(index);
		productDetailsPage.setProductName();
		productDetailsPage.addToFavorites();
	}

	@When("I go to {string} page")
	public void i_go_to_page(String favorilerim) {
		productDetailsPage.goToHesabimMenuOptions(favorilerim);
	}

	@Then("the product title must be the same as product details page")
	public void the_product_title_must_be_the_same_as_product_details_page() {
		favorilerimPage.selectFavoriteItem();
		favorilerimPage.verifyProductName();
		favorilerimPage.deleteFavouriteProducts();

	}


}
