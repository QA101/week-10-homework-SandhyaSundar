import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class Expedia {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayja\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.expedia.com/");
		
		WebElement flight= driver.findElement(By.id("tab-flight-tab-hp"));
		flight.click();
		
		File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
      	Files.copy(scrFile,  new File("C:\\Users\\jayja\\eclipse-workspace\\DemoQa_class\\resources\\screenshot5.png"));
        } catch(Exception e) {
          e.printStackTrace();
        } 	
		//selecting oneway trip
		driver.findElement(By.id("flight-type-one-way-label-hp-flight")).click();
		driver.findElement(By.id("flight-origin-hp-flight")).sendKeys("Seattle, WA (SEA-Seattle - Tacoma Intl.)");
		driver.findElement(By.id("flight-destination-hp-flight")).sendKeys(" Mexico (MEX-Mexico City Intl.)");
		
		driver.findElement (By.id("flight-departing-single-hp-flight")).click();
		Thread.sleep(3000);
		
		//selecting travel date
		driver.findElement(By.xpath("//*[@id=\"flight-departing-wrapper-single-hp-flight\"]/div/div/div[3]/table/tbody/tr[1]/td[6]")).click();
       
	    Select Adult = new Select (driver.findElement(By.id("flight-adults-hp-flight")));
	    Adult.selectByValue("2");
	    
	    Select child =new Select(driver.findElement(By.id("flight-children-hp-flight")));
	    child.selectByValue("2");
	    
	    Select AgeChild1= new Select(driver.findElement(By.id("flight-age-select-1-hp-flight")));
	    AgeChild1.selectByValue("5");
	   
	    Select AgeChild2= new Select(driver.findElement(By.id("flight-age-select-2-hp-flight")));
	    AgeChild2.selectByValue("3");
	   
	    scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
     	Files.copy(scrFile,  new File("C:\\Users\\jayja\\eclipse-workspace\\DemoQa_class\\resources\\screenshot6.png"));
     	     } catch(Exception e) {
             e.printStackTrace();
      } 	
	    driver.findElement(By.xpath("//*[@id=\"gcw-flights-form-hp-flight\"]/div[8]/label/button")).click();
	  
	   scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
       Files.copy(scrFile, new File("C:\\Users\\jayja\\eclipse-workspace\\DemoQa_class\\resources\\screenshot7.png"));
             } catch(Exception e) {
              e.printStackTrace();
      } 	
	     
      driver.findElement(By.xpath("//*[@id=\"sortBar\"]/div/fieldset/label/select")).click();
      
      driver.quit();
      driver.close();
      
        
        
	}

}
