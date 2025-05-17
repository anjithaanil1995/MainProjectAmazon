package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.AmazonBase;

public class CartPage extends AmazonBase {
	    By cartIcon = By.id("nav-cart");
	    By cartItem = By.name("sc-list-item-content");
	    By cartTitle = By.id("sc-active-items-header");
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    WebElement goToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart")));
	    //goToCartButton.click();

	    public void goToCart() {
	        driver.findElement(cartIcon).click();
	    }

	    public boolean isCartItemVisible() {
	        return driver.findElements(cartItem).size() > 0;
	    }

	    public String getCartProductTitle() {
	        return driver.findElement(cartTitle).getText();
	    }

}
