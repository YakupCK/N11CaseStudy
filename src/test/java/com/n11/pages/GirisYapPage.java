package com.n11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GirisYapPage extends BasePage{

	//--"Facebook ile Giriş Yap" button--
	@FindBy(css = ".facebook_large.medium.facebookBtn.btnLogin")
	private WebElement facebookBtn;


	//--click on "Facebook ile Giriş Yap" button--
	public void selectFacebook(){
		facebookBtn.click();
	}

}
