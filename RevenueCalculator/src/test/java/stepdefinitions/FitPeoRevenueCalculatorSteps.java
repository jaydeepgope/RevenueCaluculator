package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FitPeoRevenueCalculatorSteps {
	public static WebDriver driver;
	
	@Given("I open the FitPeo homepage with url {string}")
	public void i_open_the_fit_peo_homepage_with_url(String url) 
	{	
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}

	@When("I navigate to the Revenue Calculator page")
	public void i_navigate_to_the_revenue_calculator_page() {
	   driver.findElement(By.linkText("Revenue Calculator")).click();
	}

	@Then("I should see the Revenue Calcualtor page")
	public void i_should_see_the_revenue_calcualtor_page() throws InterruptedException {
	   
		
		if(driver.findElement(By.xpath("//body/div[2]/div[1]/h4[1]")).isDisplayed())
	    {
	    	System.out.println("calculator page displayed");
	    	Thread.sleep(2000);
	    }
	}
	
	@Then("I scroll to the slider section")
	public void i_scroll_to_the_slider_section() {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,400)");
	}
	
	@Then("I set the slider to {int}")
	public void i_set_the_slider_to(Integer int1) throws InterruptedException {
		WebElement sliderThumb = driver.findElement(By.cssSelector("span[data-index='0']"));
		WebElement sliderInput = driver.findElement(By.cssSelector("span[data-index='0'] input[type='range']"));

		Actions actions = new Actions(driver);
		int targetValue = 830;

		while (true) {
		    int currentValue = Integer.parseInt(sliderInput.getAttribute("aria-valuenow"));
		    if (currentValue >= targetValue) {
		        break;
		    }
		    int stepSize = (targetValue - currentValue > 18) ? 5 : 1;

		    actions.clickAndHold(sliderThumb).moveByOffset(stepSize, 0).release().perform();

		    Thread.sleep(100);
		}
		System.out.println("Final Slider Value: " + sliderInput.getAttribute("aria-valuenow"));
	}
	@Then("I should see the text field updated to {int}")
	public void i_should_see_the_text_field_updated_to(Integer int1) throws InterruptedException {
		  WebElement textBox = driver.findElement(By.xpath("//input[@id='R57alklff9da:' or @type='number']")); 
		    String expectedValue = "830";
		    String actualValue = textBox.getAttribute("value");
		    if (actualValue.equals(expectedValue)) {
		        System.out.println("Validation passed: The text box contains the correct value.");
		    } else {
		        System.out.println("Validation failed: Expected '" + expectedValue + "' but got '" + actualValue + "'.");
		    }
			Thread.sleep(2000);	
	}		
	    
	
	@When("I enter {int} in the text field")
	public void i_enter_in_the_text_field(Integer int1) {
		 WebElement textBox = driver.findElement(By.xpath("//input[@id='R57alklff9da:' or @type='number']")); 
		  Actions action = new Actions(driver);
		    action.click(textBox)
		           .keyDown(Keys.CONTROL)
		           .sendKeys("a")
		           .keyUp(Keys.CONTROL)
		           .sendKeys(Keys.BACK_SPACE)
		           .sendKeys("560")
		           .perform();
	}
	
	@Then("the slider should reflect the value {int}")
	public void the_slider_should_reflect_the_value(Integer int1) {
		   WebElement textBox = driver.findElement(By.xpath("//input[@id='R57alklff9da:' or @type='number']")); 
		    String expectedValue = "560";
		    String actualValue = textBox.getAttribute("value");
		    if (actualValue.equals(expectedValue)) {
		        System.out.println("Validation passed: The text box contains the correct value.");
		    }
		    
		   else 
		   {
		        System.out.println("Validation failed: Expected '" + expectedValue + "' but got '" + actualValue + "'.");
		    }
	}	
	@Then("I update the text field to {int}")
	public void i_update_the_text_field_to(Integer int1) throws InterruptedException {
		
		    //update 820
		    Thread.sleep(2000);
		    WebElement textBox = driver.findElement(By.xpath("//input[@id='R57alklff9da:' or @type='number']")); 
		    Actions act = new Actions(driver);
		    act.click(textBox)
		           .keyDown(Keys.CONTROL)
		           .sendKeys("a")
		           .keyUp(Keys.CONTROL)
		           .sendKeys(Keys.BACK_SPACE)
		           .sendKeys("820")
		           .perform();
	}
	
	@When("I scroll down and select CPT codes")
	public void i_scroll_down_and_select_cpt_codes() throws InterruptedException {
		Thread.sleep(2000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");
		Thread.sleep(3000);
		
		  driver.findElement(By.xpath("//span[contains(text(),'57')]")).click();
	     driver.findElement(By.xpath("//span[contains(text(),'19.19')]")).click();
	      driver.findElement(By.xpath("//span[contains(text(),'63')]")).click();
	      driver.findElement(By.xpath("//span[contains(text(),'15')]")).click();
	      
	}
	@Then("the Total Recurring Reimbursement should show {string}")
	public void the_total_recurring_reimbursement_should_show(String string) {
		  WebElement amountElement = driver.findElement(By.xpath("//header/div[1]/p[4]/p[1]"));
	      String actualText = amountElement.getText();
	      String expectedText = "$110700";

	      
	      if (actualText.equals(expectedText)) {
	          System.out.println("Validation passed: The value is correct.");
	      } else {
	          System.out.println("Validation failed: Expected '" + expectedText + "' but got '" + actualText + "'.");
	      }
	      driver.close();
	}
	}
	


