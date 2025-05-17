package pages;

import bases.AmazonBase;
import org.openqa.selenium.By;

public class AmazonHomePage extends AmazonBase {
	
    By logo = By.xpath("//a[text()='Amazon']");
    By searchBar = By.xpath("//input[@title='Search For']");
    By searchButton = By.xpath("//input[@type='submit']");
    By signIn = By.xpath("//span[text() ='Hello, sign in']");
    By cart = By.id("nav-cart-count");

    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public boolean isSearchBarVisible() {
        return driver.findElement(searchBar).isDisplayed();
    }

    public boolean isSignInVisible() {
        return driver.findElement(signIn).isDisplayed();
    }

    public boolean isCartVisible() {
        return driver.findElement(cart).isDisplayed();
    }

    public void searchProduct(String product) {
        driver.findElement(searchBar).sendKeys(product);
        driver.findElement(searchButton).click();
    }
}