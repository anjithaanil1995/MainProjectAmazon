package pages;

import org.openqa.selenium.By;

import bases.AmazonBase;

public class ProductDetailsPage extends AmazonBase {

	    By productTitle = By.xpath("//a[text()='Headphones']");
	    By productPrice = By.cssSelector(".a-price .a-offscreen");
	    By addToCart = By.id("add-to-cart-button");
	    String currentUrl = driver.getCurrentUrl();
	    

	    public boolean isProductTitleVisible() {
	        return driver.findElement(productTitle).isDisplayed();
	    }

	    public boolean isPriceVisible() {
	        return driver.findElements(productPrice).size() > 0;
	    }

	    public boolean isAddToCartVisible() {
	        return driver.findElement(addToCart).isDisplayed();
	    }

	    public void clickAddToCart() {
	        driver.findElement(addToCart).click();
	    }
}
