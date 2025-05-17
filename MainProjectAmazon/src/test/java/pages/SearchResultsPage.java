package pages;

import org.openqa.selenium.By;

import bases.AmazonBase;

public class SearchResultsPage extends AmazonBase {
	
	    By resultItems = By.xpath("//h2[text()='Results']");
	    By brandFilter = By.xpath("//span[text()='Brand']");
	    By priceFilter = By.xpath("//span[text()='Price']");
	    By firstProduct = By.cssSelector(".s-main-slot .s-result-item h2 a");

	    
	    public boolean isBrandFilterVisible() {
	        return driver.findElements(brandFilter).size() > 0;
	    }

	    public boolean isPriceFilterVisible() {
	        return driver.findElements(priceFilter).size() > 0;
	    }

	    public void clickFirstProduct() {
	        driver.findElement(firstProduct).click();
	    }

		public boolean isResultDisplayed() {
			// TODO Auto-generated method stub
			
			return driver.findElements(resultItems).size() > 0;
		}

}
