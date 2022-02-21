package com.n11.pages;

import com.n11.utility.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

	//--product name as web element--
	@FindBy(className = "proName")
	private WebElement productNameWE;

	//--"favoriler" icon--
	@FindBy(css = ".addWishListBtn")
	private WebElement favIcon;

	//--"favorilerim" button appearing after clicking favIcon--
	@FindBy(id = "addToFavouriteWishListBtn")
	private WebElement favorilerimBtn;

	//--"Tamam" button after adding to favorites--
	@FindBy(css = ".btn.btnBlack.confirm")
	private WebElement tamamBtn;

	//--product name as String
	private static String productNameString;

	//--set the product name as String--
	public void setProductName(){
		Utils.waitForClickability(productNameWE);
		productNameString = productNameWE.getText();
	}

	//--get the product name as String--
	public String getProductName(){
		return productNameString;
	}

	//--add a product to favorites--
	public void addToFavorites(){
		Utils.waitForClickability(favIcon);
		//--add to favorites if it's not added before--
		if (!favIcon.getAttribute("class").contains("added")) {
			favIcon.click();

			Utils.waitForClickability(favorilerimBtn);
			favorilerimBtn.click();

			Utils.waitForClickability(tamamBtn);
			tamamBtn.click();
		}
	}





}
