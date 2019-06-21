package proj.maven.test.Naukri.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class UpdateProfile 
{
    public static void main( String[] args ) throws InterruptedException
    {
     
    	
    	System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\resourses\\chromedriver.exe");
    	
    	
	WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		driver.get("https://www.naukri.com/");
		driver.findElement(By.xpath("//*[@id='login_Layer']/div")).click();
		driver.findElement(By.xpath("//*[@id='eLoginNew']")).sendKeys("sanketpandey2@gmail.com");
		driver.findElement(By.xpath("//*[@id='pLogin']")).sendKeys("India@123");
		driver.findElement(By.xpath("//*[@id='lgnFrmNew']/div[9]/button")).click();
		 WebElement elm = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul[2]/li[2]/a/div[2]"));
		 
		 WebElement elm1= driver.findElement(By.xpath("/html/body/div[1]/div/div/ul[2]/li[2]/div/ul[1]/li[1]/a"));
		
		Actions act = new Actions(driver);
		act.moveToElement(elm).click(elm1).build().perform();
		driver.findElement(By.xpath("//*[@id='lazyResumeHead']/div/div/div/div[1]/span[2]")).click();
		
		driver.findElement(By.xpath("/html/body/div[5]/div[8]/div[2]/form/div[3]/div/button")).submit();
		
		Thread.sleep(1000);
		
		driver.close();
		
		
    }
}
