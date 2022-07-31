package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListAssignment_classroom {
	
	public static void main(String args[]) {

	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://amazon.in");
	driver.manage().window().maximize();
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phones");
	driver.findElement(By.className("nav-input")).sendKeys(Keys.ENTER);

	List<WebElement> allPhoneElements =  driver.findElements(By.className("a-price-whole"));
	List<Integer> phonePrices = new ArrayList<Integer>();
	for(int i=0;i<allPhoneElements.size();i++) {
	System.out.println(allPhoneElements.get(i).getText());
	String priceStr = allPhoneElements.get(i).getText().replace(",","");
	int price = Integer.parseInt(priceStr);
	phonePrices.add(price);
	
	}
	Collections.sort(phonePrices);
	System.out.println(phonePrices.get(0));

}
	
}
