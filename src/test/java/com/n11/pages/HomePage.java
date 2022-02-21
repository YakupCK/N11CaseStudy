package com.n11.pages;

import com.n11.utility.PropertyReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	//--username displayed under 'Hesabim' menu--
	@FindBy(css = "[title='Hesabım']:nth-of-type(2)")
	private WebElement username;

	//--get text of the username under 'Hesabım' menu--
	public String getUserName(){
		return username.getText();
	}

	//--verify if login is successful--
	public void verifyLogIn(){
		Assert.assertEquals(PropertyReader.getProperty("username"), getUserName());
	}

	//--navigate to homepage:'n11.com'--
	public void navigateToHomePage(){
		driver.get(PropertyReader.getProperty("url"));
	}

}
