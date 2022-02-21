package com.n11.pages;

import com.n11.utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParfumDeoPage extends BasePage{

	//--search icon to enable search box--
	@FindBy(css = "section.filter:nth-of-type(3) .openSearchBtn")
	private WebElement searchIcon;

	//--search box enabled after clicking on search icon--
	@FindBy(css = "section.filter:nth-of-type(3) input[type='text']")
	private WebElement searchInputBox;

	//--product displayed after search--
	@FindBy(css = "div[class$='filterItem wl'] a")
	private WebElement productDisplayed;

	//--search for a particular product--
	public void searchProduct(String product){
		searchIcon.click();
		Utils.waitForClickability(searchInputBox);
		searchInputBox.sendKeys(product, Keys.ENTER);
		productDisplayed.click();
	}

	//--click on the .nth product on the page--
	public void clickNthProduct(int index){
		String cssLocator = ".listingGroup li.column:nth-of-type(" + index + ") a";
		driver.findElement(By.cssSelector(cssLocator)).click();
	}

}
