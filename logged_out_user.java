package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class logged_out_user {

			public static void main(String[] args) throws InterruptedException {
				// TODO Auto-generated method stub
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();

				driver.get("https://www.saucedemo.com/");
				Thread.sleep(4000);

				WebElement Username = driver.findElement(By.id("user-name"));
				WebElement Password = driver.findElement(By.id("password"));
				WebElement Login = driver.findElement(By.id("login-button"));
				
				
				Username.sendKeys("locked_out_user");
				Password.sendKeys("secret_sauce");
				Login.click();

				WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
				Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.",error.getText());

			}
	}

