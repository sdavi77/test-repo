package Tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standard_user_checkout {

			public static void main(String[] args) throws InterruptedException,NumberFormatException {
				// TODO Auto-generated method stub
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();

				driver.get("https://www.saucedemo.com/");
				Thread.sleep(4000);

				WebElement Username = driver.findElement(By.id("user-name"));
				WebElement Password = driver.findElement(By.id("password"));
				WebElement Login = driver.findElement(By.id("login-button"));

				Username.sendKeys("standard_user");
				Password.sendKeys("secret_sauce");
				Login.click();

				WebElement SauceBagPack = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
				WebElement SauceBikeLight = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
				WebElement PriceSauceBagPack = driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]"));
				WebElement PriceSauceBikeLight = driver.findElement(By.xpath("//div[@id='inventory_container']//div[2]//div[2]//div[2]//div[1]"));
				WebElement AddtoCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));


				String PriceofBag = PriceSauceBagPack.getText();
				String FinalPriceofBag = PriceofBag.substring(1);
				
				String PriceofLight = PriceSauceBikeLight.getText();
				String FinalPriceofLight = PriceofLight.substring(1);

				SauceBagPack.click();
				SauceBikeLight.click();

				AddtoCart.click();

				WebElement checkout = driver.findElement(By.id("checkout"));
				checkout.click();

				WebElement FirstName = driver.findElement(By.id("first-name"));
				WebElement LastName = driver.findElement(By.id("last-name"));
				WebElement PostalCode = driver.findElement(By.id("postal-code"));
				WebElement Continue = driver.findElement(By.id("continue"));


				FirstName.sendKeys("Surabhi");
				LastName.sendKeys("Yadav");
				PostalCode.sendKeys("60527");
				Continue.click();


				WebElement ItemTotal = driver.findElement(By.className("summary_subtotal_label"));
				String Total = ItemTotal.getText();

				String TotalValue = Total.substring(13,18);
				System.out.println("Actual total price of items is "+ TotalValue);

					double Amount = Double.parseDouble(TotalValue);

					double CalcPriceofBag = Double.parseDouble(FinalPriceofBag);
					double CalcPriceofLight= Double.parseDouble(FinalPriceofLight);
				
				
					double CalcTotal = CalcPriceofBag + CalcPriceofLight;
					System.out.println("Calculate total price of the items is "+ CalcTotal);
					
					
					Assert.assertEquals(CalcTotal,Amount);
				}
			
			}


