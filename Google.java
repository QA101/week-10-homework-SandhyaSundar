import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.google.common.io.Files;
		
public class Google {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayja\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.navigate().to("http://demoqa.com");
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Sandhya Sundar+ qa+linkedin profile");
		File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
      
      	 Files.copy(scrFile,  new File("C:\\Users\\jayja\\eclipse-workspace\\DemoQa_class\\resources\\screenshot1.png"));
     	
        } catch(Exception e) {
          e.printStackTrace();
      } 	
       // System.out.println("going to submit");
		driver.findElement(By.name("btnK")).submit();
		
		 scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       try {
	    	   Thread.sleep(5000);
	 Files.copy(scrFile,new File("C:\\Users\\jayja\\eclipse-workspace\\DemoQa_class\\resources\\screenshot2.png"));
	       }catch (Exception e){
	    	   e.printStackTrace();
	       }
		  List<WebElement> resultPage = driver.findElements(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/h3/a"));
		  String myLink = resultPage.get(0).getAttribute("href");
		  driver.navigate().to(myLink);
		  driver.navigate();
		  scrWait(4000);
		  driver.switchTo().activeElement();
		  scrWait(4000);
		  driver.findElement(By.partialLinkText("Sign in")).click();
		  driver.switchTo().activeElement();
		  driver.findElement(By.id("login-email")).sendKeys("sundarsandhya6@gmail.com");
		  driver.findElement(By.id("login-password")).sendKeys("Jobacc@20");
		  scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		      try {
    	   Thread.sleep(5000);
		  Files.copy(scrFile,new File("C:\\Users\\jayja\\eclipse-workspace\\DemoQa_class\\resources\\screenshot3.png"));
		      }catch (Exception e){
    	   e.printStackTrace();
		      }
		  driver.findElement(By.id("login-submit")).submit();
		  scrWait(3000);
		  
		  scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   		 try {
		    	   Thread.sleep(5000);
	   		  Files.copy(scrFile,new File("C:\\Users\\jayja\\eclipse-workspace\\DemoQa_class\\resources\\screenshot4.png"));
	   		 }catch (Exception e){
		    	   e.printStackTrace();
	   		 }
	   		driver.quit();
	}
	
	public static void scrWait(long waitTime) {
		try {
			Thread.sleep(waitTime);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}


