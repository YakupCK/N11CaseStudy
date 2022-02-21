package com.n11.pages;

import com.n11.utility.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavorilerimPage extends BasePage {

	//--favourite product listed on favourites page--
	@FindBy(css = ".wishGroupListItem.favorites li a")
	private WebElement favouriteProduct;

	//--name of the selected favourite product--
	@FindBy(className = "productName")
	private WebElement favProductName;

	//--"Sil" button for deleting favourite products--
	@FindBy(className = "deleteProFromFavorites")
	private WebElement silButton;

	//--"Tamam" button after clicking "Sil" btn--
	@FindBy(css = ".btn.btnBlack.confirm")
	private WebElement tamamBtn;

	//--select one of the favourite product from the list --
	public void selectFavoriteItem() {
		Utils.waitForClickability(favouriteProduct);
		favouriteProduct.click();
	}

	//--get the name of selected favourite product--
	public String getFavProductName() {
		return favProductName.getText();
	}

	/*	verify if the product name
	  	displayed on the product details page
	  	and favourites page is the same  */
	public void verifyProductName() {
		String actual = getFavProductName();
		String expected = new ProductDetailsPage().getProductName();
		Assert.assertEquals(expected, actual);
	}

	public void deleteFavouriteProducts() {
		try {
			Utils.waitForClickability(silButton);
			silButton.click();
			Utils.waitForClickability(tamamBtn);
			tamamBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
