package StepDefinitions;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.AmazonPage;
import Utils.baseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class AmazonTestSteps {

	
	public AmazonPage amazonpage;
	private static WebDriver driver;
	public WebDriverWait wait;
	baseClass baseclass ;
	
	//WebElement price;
	
	@Given("User is logged into Amazon Shopping website")
	public void user_is_logged_into_amazon_shopping_website() {
	    driver = baseclass.initDriver();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		amazonpage = new AmazonPage(driver);
	}

	@Given("User enters {string} into Searchbox")
	public void user_enters_into_searchbox(String ProductName) throws InterruptedException {
	    
		wait.until(ExpectedConditions.elementToBeClickable(amazonpage.getsearchbox())).sendKeys(ProductName);
		Thread.sleep(1000);
	}

	@Given("User Presses Enter button from keyboard")
	public void user_presses_enter_button_from_keyboard() throws InterruptedException {
	   
		amazonpage.getsearchbox().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
	}

	@Given("User selects first item from the search result list")
	public void user_selects_first_item_from_the_search_result_list() throws InterruptedException {
	  
		wait.until(ExpectedConditions.elementToBeClickable(amazonpage.getfirstSearchResult())).click();
		Thread.sleep(1000);
		
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
		
		Thread.sleep(2000);
		
		
		
	
	}

	@Given("User adds the item into the cart by clicking on Add to Cart button")
	public void user_adds_the_item_into_the_cart_by_clicking_on_add_to_cart_button() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(amazonpage.getaddToCart())).click();
		Thread.sleep(2000);
		
        WebElement closebutton = driver.findElement(By.xpath("//a[@aria-label=\"Exit this panel and return to the product page. \"]"));
        Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(closebutton)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(amazonpage.getsearchbox())).clear();
		Thread.sleep(1000);
		
	
		
	}

	@Given("User opens Cart from the top-left of the website")
	public void user_opens_cart_from_the_top_left_of_the_website() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(amazonpage.getcart())).click();
		Thread.sleep(2000);
	    
	}

	@Given("User verifies the price is identical to the product page")
	public void user_verifies_the_price_is_identical_to_the_product_page() throws InterruptedException {
	   
		WebElement  cartprice = driver.findElement(By.xpath("//span[@class=\"a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold\"]"));
		
		String getcartprice = cartprice.getText();
		
		
		
		System.out.println(getcartprice);
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		WebElement price = driver.findElement(By.xpath("//span[@data-a-size=\"xl\"]//span//span//following-sibling::span"));
		
		String getprice = price.getText();
		
		String originalPrice = getprice+".00";
		
		System.out.println(originalPrice);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(amazonpage.getcart())).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(getcartprice.trim(), originalPrice.trim());
		
		System.out.println("Price verified Successfully!!!!!");
		
	  
	   
	   
	}

	@Given("User verifies that the sub total is identical to the product page")
	public void user_verifies_that_the_sub_total_is_identical_to_the_product_page() {
		
        WebElement  cartprice = driver.findElement(By.xpath("//span[@class=\"a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold\"]"));
		
		String getcartprice = cartprice.getText();
		
		WebElement subTotalPrice = driver.findElement(By.xpath("//*[@id=\"sc-subtotal-amount-buybox\"]/span"));
		
		String getsubTotalPrice = subTotalPrice.getText();
		
		Assert.assertEquals(getsubTotalPrice.trim(), getcartprice.trim());
		
		System.out.println("Subtotal and Cart prices are verified Successfully!!!!!");
		
	
	}
   
	
	@And("user search for Headphones in the Website")
	public void user_search_for_Headphones_in_the_Website() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(amazonpage.getsearchbox())).sendKeys("Headphones");
		Thread.sleep(1000);
		
	}
	
	@And("user search for Keyboard in the Website")
	public void user_search_for_Keyboard_in_the_Website() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(amazonpage.getsearchbox())).sendKeys("Keyboard");
		Thread.sleep(1000);
		
	}
	
	@And("User switches to the new tab")
	public void User_switches_to_the_new_tab() throws InterruptedException {
		
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(2));
		
		Thread.sleep(2000);
		
	}
	
	
	
	
	@And("User verifies the cart and subtotal prices")
	public void User_verifies_the_cart_and_subtotal_prices() {
		
		WebElement Cartsubtotal = driver.findElement(By.xpath("//*[@id=\"sc-subtotal-amount-activecart\"]/span"));
		
		String getCartsubtotal = Cartsubtotal.getText();
		
        WebElement subTotalPrice = driver.findElement(By.xpath("//*[@id=\"sc-subtotal-amount-buybox\"]/span"));
		
		String getsubTotalPrice = subTotalPrice.getText();
		
        Assert.assertEquals(getsubTotalPrice.trim(), getCartsubtotal.trim());
		
		System.out.println("Subtotal and Cart prices are verified Successfully!!!!!");
		
	}
	

}
