package proj.maven.test.Naukri.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class UpdateProfile 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    	
    	
     FileInputStream fis = new FileInputStream("config.properties");
    Properties prop = new Properties();	
	prop.load(fis);
    	System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\resource_new\\chromedriver.exe");
    	
    
    	
    	
    	
	WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		driver.get("https://www.naukri.com/");
		
String MainWindow=driver.getWindowHandle();
		
		Set<String> handle = driver.getWindowHandles();
		
		System.out.println(MainWindow);
		for(String a : handle ) {
			if(!a.equals(MainWindow)) {
				driver.switchTo().window(a).close();
			}
		}
		driver.switchTo().window(MainWindow);
		driver.findElement(By.xpath("//*[@id='login_Layer']/div")).click();
		driver.findElement(By.xpath("//*[@id='eLoginNew']")).sendKeys(prop.getProperty("signInEmail_id"));
		driver.findElement(By.xpath("//*[@id='pLogin']")).sendKeys(prop.getProperty("signInPWD_id"));
		driver.findElement(By.xpath("//*[@id='lgnFrmNew']/div[9]/button")).click();
		 WebElement elm = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul[2]/li[2]/a/div[2]"));
		 
		 WebElement elm1= driver.findElement(By.xpath("/html/body/div[1]/div/div/ul[2]/li[2]/div/ul[1]/li[1]/a"));
		
		Actions act = new Actions(driver);
		act.moveToElement(elm).click(elm1).build().perform();
		driver.findElement(By.xpath("//*[@id='lazyResumeHead']/div/div/div/div[1]/span[2]")).click();
		
		driver.findElement(By.xpath("/html/body/div[5]/div[8]/div[2]/form/div[3]/div/button")).submit();
		
		
		
		Thread.sleep(10000);
		
		driver.close();
		
		
    }
}
