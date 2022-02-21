package com.n11.pages;

import com.n11.utility.Driver;
import com.n11.utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

	protected WebDriver driver;

	//constructor to initialize @FindBy annotations with PageFactory class
	BasePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	//--to hover over 'Hesabim' menu--
	@FindBy(css = ".myAccountHolder")
	private WebElement hesabimBtn;

	//--all anchor tags under footer--
	@FindBy(css = "#footer .column a")
	private List<WebElement> allFooterLinks;

	//--to navigate to any module--
	public void navigateToPage(String module) {
//		Utils.waitForClickability(By.linkText(module));
		driver.findElement(By.linkText(module)).click();
	}

	//--get text of all footer links--
	public List<String> getFooterLinksText() {
		List<String> list = new ArrayList<>();
		for (WebElement link : allFooterLinks) {
			list.add(link.getText());
		}
		return list;
	}

	//--write all footer links to a file--
	public void writeFooterLinksToFile() {
		Utils.writeTextToFile(getFooterLinksText());
	}

	//--navigate through and option under 'Hesabim' menu--
	public void goToHesabimMenuOptions(String menuOption) {
		Actions actions = new Actions(driver);
		Utils.waitForClickability(hesabimBtn);
		actions.moveToElement(hesabimBtn).build().perform();
		Utils.waitForClickability(By.linkText(menuOption));
		navigateToPage(menuOption);
	}


}
