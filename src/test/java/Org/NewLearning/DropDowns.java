package Org.NewLearning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//System.setProperty(null, null)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//select dropdown - currency
		WebElement currency_DD = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select selDD = new Select(currency_DD);
		System.out.println(selDD.getFirstSelectedOption().getText());
		selDD.selectByValue("AED");
		System.out.println(selDD.getFirstSelectedOption().getText());
		selDD.selectByVisibleText("INR");
		System.out.println(selDD.getFirstSelectedOption().getText());
		selDD.selectByIndex(3);
		System.out.println(selDD.getFirstSelectedOption().getText());
		
		
		List<WebElement> alloptions = selDD.getOptions();
		for (WebElement ddWebEle : alloptions) {
			System.out.println(ddWebEle.getText());
			
		}
		
		//Div Tag dropdown- passengers
		
		driver.findElement(By.className("paxinfo")).click();
		Thread.sleep(2000);
		
		int i=1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		driver.findElement(By.cssSelector("[value='Done']")).click();
			
		
		//Auto suggestive dd
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> sugOptions = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li a"));
		
		for(WebElement option :sugOptions) 
		{
			if(option.getText().equalsIgnoreCase("india")) 
			{
				option.click();
				System.out.println("--selected india--");
				break;
			}
		}	

	}

}
