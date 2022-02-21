package com.n11.pages;

import com.n11.utility.Utils;
import org.junit.Assert;

import java.util.List;

public class MarkalarPages extends BasePage {

	//--list of String for all footer links--
	private List<String> markalarFooterLinks;

	//--set the list above
	public void setMarkalarFooterLinks(){
		markalarFooterLinks = getFooterLinksText();
	}

	//--get the list above
	public List<String> getMarkalarFooterLinks(){
		setMarkalarFooterLinks();
		return markalarFooterLinks;
	}

	//--verify if footer links under Markalar page
	//	and footer links in text file are the same--
	public void verifyFooterContent(){
		Assert.assertEquals(getMarkalarFooterLinks(), Utils.readTextFromFile());
	}


}
