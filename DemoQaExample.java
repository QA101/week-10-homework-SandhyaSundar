import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class DemoQaExample {

	//creating a web driver
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayja\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	//(WebDriver is Superclass and Chrome driver is sub Class)
	driver.manage().window().maximize();
	driver.navigate().to("http://demoqa.com");//CAN ALSO BE CALLED AS driver.get("http://demoqa.com");
	
	WebElement w =driver.findElement(By.partialLinkText("Registration"));
	w.click();
	if(driver.getCurrentUrl().contains("Registraion")) {
	}
	
	System.out.println("Done");    
	//fill in the first name
	driver.findElement(By.id("name_3_firstname")).sendKeys("Sandhya");//sendkeys just send to keyboard
	driver.findElement(By.id("name_3_lastname")).sendKeys("Sundar");
	
	
	Select country = new Select(driver.findElement(By.id("dropdown_7")));
		   country.selectByValue("India");
	
	 List<WebElement> status=driver.findElements(By.name("radio_4[]"));
     		for(WebElement radiobutton: status) {
                  if(radiobutton.getAttribute("value").equals("married")) {
                  radiobutton.click();
         }
     }

    List<WebElement> Hobby= driver.findElements(By.name("checkbox_5[]"));
             for (WebElement checkBox: Hobby) {
            	  if (checkBox.getAttribute("value").equals("reading")) {
            	      checkBox.click();
                }
             }
   
        //Date Of Birth
    Select Month = new Select(driver.findElement(By.id("mm_date_8")));  
           Month.selectByValue("12");
    Select day= new Select(driver.findElement(By.id("dd_date_8")));
           day.selectByValue("20");
    Select year=new Select (driver.findElement(By.id("yy_date_8")));
           year.selectByValue("1988");
             
        //phone,email,profile pic etc... 
      driver.findElement(By.id("phone_9")).sendKeys("4254991339");
      driver.findElement(By.id("username")).sendKeys("sarayu");
      driver.findElement(By.id("email_1")).sendKeys("sarayu@gmail.com");
      driver.findElement(By.id("profile_pic_10")).sendKeys("C:\\Users\\jayja\\Documents\\profilepic.jpg");
      driver.findElement(By.id("description")).sendKeys("Good");
      driver.findElement(By.id("password_2")).sendKeys("proFile@20#17");
      driver.findElement(By.id("confirm_password_password_2")).sendKeys("proFile@20#17");
       
     File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
     Files.copy(scrFile,  new File("C:\\Users\\jayja\\eclipse-workspace\\DemoQa_class\\resources\\screenshot.png"));
      } catch(Exception e) {
         e.printStackTrace();
     }
    

    driver.findElement(By.name("pie_submit")).click();
	
    driver.quit();
  
}
}
