package com.n11.pages;

import com.n11.utility.PropertyReader;
import com.n11.utility.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginWithFacebookPage extends BasePage {

	//--email field--
	@FindBy(id = "email")
	private WebElement emailInput;

	//--password field--
	@FindBy(id = "pass")
	private WebElement passwordInput;

	//--log in button--
	@FindBy(css = "[name='login']")
	private WebElement loginButton;

	//--log in the app. through Facebook account--
	public void loginWithFacebook()  {
		Utils.waitForTab(2);
		Utils.switchToWindow(1);
		Utils.waitForClickability(emailInput);

		emailInput.sendKeys(PropertyReader.getProperty("email"));
		passwordInput.sendKeys(PropertyReader.getProperty("password"));
		loginButton.click();

		Utils.switchToWindow(0);
		Utils.waitForTab(1);
	}

}
