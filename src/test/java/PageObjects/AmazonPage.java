package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPage {

	
	
	
	private WebDriver driver;
	
	public AmazonPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private By searchbox = By.xpath("//input[@id=\"twotabsearchtextbox\"]");
	public WebElement getsearchbox() {
		
		return driver.findElement(searchbox);
	}
	
	private By firstSearchResult  = By.xpath("//div[@data-index='3']//div//h2//a//span");
	public WebElement getfirstSearchResult() {
		
		return driver.findElement(firstSearchResult);
	}
	
	private By addToCart = By.xpath("//div[@id=\"quantityLayoutLow_feature_div\"]//following-sibling::div//span//input[@id=\"add-to-cart-button\"]");
	public WebElement getaddToCart() {
		
		return driver.findElement(addToCart);
	}
	
	private By cart = By.xpath("//span[@id=\"nav-cart-count\"]");
	public WebElement getcart() {
		
		return driver.findElement(cart);
	}
	
	
	
	
}
