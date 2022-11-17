package com.login;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	static WebDriver driver;
	static String name;
	@Given("user launch the browser")
	public void user_launch_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  
	}

	@Given("user enter valid user name and password")
	public void user_enter_valid_user_name_and_password() {
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("9500967493");
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("9213");
	    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	}
	
	@When("user search realme mobile")
	public void user_search_realme_mobile() {
		name="realme";
		driver.findElement(By.name("q")).sendKeys("realme",Keys.ENTER);
	    driver.findElement(By.xpath("(//div[contains(text(),'realme')])[2]")).click();
	    String windowid= driver.getWindowHandle();
		Set<String> windowids=driver.getWindowHandles();
		for(String id:windowids) {
			if(!id.equals(windowid)) {
				driver.switchTo().window(id);

			}
		}

	}

	@When("user click add to kart")
	public void user_click_add_to_kart() {
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
	    
	}


}
