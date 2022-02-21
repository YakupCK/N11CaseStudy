package com.n11.utility;

import com.n11.pages.*;

public class PageManager {

	private HomePage homePage;
	private FavorilerimPage favorilerimPage;
	private GirisYapPage girisYapPage;
	private KozmetikPage kozmetikPage;
	private LoginWithFacebookPage loginWithFacebookPage;
	private MarkalarPages markalarPages;
	private ParfumDeoPage parfumDeoPage;
	private ProductDetailsPage productDetailsPage;

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage() : homePage;
	}

	public FavorilerimPage getFavorilerimPage() {
		return (favorilerimPage == null) ? favorilerimPage = new FavorilerimPage() : favorilerimPage;
	}

	public GirisYapPage getGirisYapPage() {
		return (girisYapPage == null) ? girisYapPage = new GirisYapPage() : girisYapPage;
	}

	public KozmetikPage getKozmetikPage() {
		return (kozmetikPage == null) ? kozmetikPage = new KozmetikPage() : kozmetikPage;
	}

	public LoginWithFacebookPage getLoginWithFacebookPage() {
		return (loginWithFacebookPage == null) ? loginWithFacebookPage = new LoginWithFacebookPage() : loginWithFacebookPage;
	}

	public MarkalarPages getMarkalarPages() {
		return (markalarPages == null) ? markalarPages = new MarkalarPages() : markalarPages;
	}

	public ParfumDeoPage getParfumDeoPage() {
		return (parfumDeoPage == null) ? parfumDeoPage = new ParfumDeoPage() : parfumDeoPage;
	}

	public ProductDetailsPage getProductDetailsPage() {
		return (productDetailsPage == null) ? productDetailsPage = new ProductDetailsPage() : productDetailsPage;
	}
}
