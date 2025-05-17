package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bases.AmazonBase;
import pages.AmazonHomePage;
import pages.CartPage;
import pages.ProductDetailsPage;
import pages.SearchResultsPage;

@Listeners
public class AmazonTestcases extends AmazonBase {
	AmazonHomePage homePage;
    SearchResultsPage searchPage;
    ProductDetailsPage productPage;
    CartPage cartPage;

    @BeforeClass
    public void setUp() throws IOException {
        loadprop();
        homePage = new AmazonHomePage();
        searchPage = new SearchResultsPage();
        productPage = new ProductDetailsPage();
        cartPage = new CartPage();
    }

    @Test(priority = 1)
    public void verifyHomePage() {
        Assert.assertTrue(homePage.isLogoDisplayed());
        Assert.assertTrue(homePage.isSearchBarVisible());
        Assert.assertTrue(homePage.isSignInVisible());
        Assert.assertTrue(homePage.isCartVisible());
    }

    @Test(priority = 2)
    public void searchAndValidateResults() {
        homePage.searchProduct(prop.getProperty("searchItem"));
        Assert.assertTrue(searchPage.isResultDisplayed());
        Assert.assertTrue(searchPage.isBrandFilterVisible());
        Assert.assertTrue(searchPage.isBrandFilterVisible());
    }

    @Test(priority = 3)
    public void validateProductDetails() {
        searchPage.clickFirstProduct();;
        Assert.assertTrue(productPage.isProductTitleVisible());
        Assert.assertTrue(productPage.isPriceVisible());
        Assert.assertTrue(productPage.isAddToCartVisible());
    }

    @Test(priority = 4)
    public void addToCartAndVerify() {
        productPage.clickAddToCart();
        cartPage.goToCart();
        Assert.assertTrue(cartPage.isCartItemVisible());
        Assert.assertTrue(cartPage.getCartProductTitle().toLowerCase().contains("bluetooth"));
    }

    @AfterClass
    public void tearDownSuite() {
        tearDown();
    }

}
