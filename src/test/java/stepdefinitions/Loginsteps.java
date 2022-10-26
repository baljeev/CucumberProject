package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginsteps {
	public WebDriver driver;
	@Given("user is navigating to orangeHRM url")
	public void user_is_navigating_to_orange_hrm_url() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Orange HRM webpage launched succesfully");
	  
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("user should navigate to the home page.")
	public void user_should_navigate_to_the_home_page() {
	WebElement element = 	driver.findElement(By.xpath("//a[contains(.,'Admin')]"));
	if(element.isDisplayed());{
		System.out.println("Element is displayed");
	}
	}

	@And ("close the application")
	public void close_the_application() {
	  driver.close();
	}
	@When("user enters invalid username and password")
	public void user_enters_invalid_username_and_password() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin1");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Then("user should see an error message")
	public void user_should_see_an_error_message() {
	   WebElement errormsg =  driver.findElement(By.xpath("//p[.='Invalid credentials']"));
	   if (errormsg.isDisplayed()) {
		   System.out.println("Invalid log in details entered");
	   }
	}
	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	@Then("user should navigate to the next page")
	public void user_should_navigate_to_the_next_page() {
	  System.out.println("Test is passed");
	}
	

}
