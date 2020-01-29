package Chrome;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class validateString {

	public void OpenUrl() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/users/balaje/chromedriver");

// Initialize browser
        WebDriver driver = new ChromeDriver();
        //
        //2.       Feature: Use the website to find restaurants

        //3.                So that I can order food

        //4.                As a hungry customer

        //5.                 I want to find error message area

        //6.        Scenario: Search for restaurants in an area

        //7.                Given I want food in "balajersundaramp"

        //8.                When I search for restaurants

      //  9.                Then I should see some error
        driver.get("http://www.just-eat.co.uk/");
        driver.navigate().refresh();
       
// Maximize browser

        driver.manage().window().maximize();
      
       driver.findElement(By.xpath("/html/body/app/div/div/div[1]/div[2]/form/div/div/label/input")).sendKeys("balajersundaramp");
       driver.findElement(By.xpath("//*[@id=\"skipToMain\"]/form/div/button/span")).click();
       //driver.findElement(By.xpath("//*[@id=\'token2\']")).sendKeys("Password1!");
       if(driver.findElement(By.xpath("//*[@id=\"errorMessage\"]")).getText().contains("valid postcode"))
       {
    	   System.out.println("Error Caught");
       }
    	 


        //driver.findElement(By.xpath("//*[@id=\'userNavigationLabel\']")).click();

        //this.takeSnapShot(driver, "/users/balaje/Downloads/FailedScr/test.png") ;

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        File DestFile=new File("/users/balaje/Screenshots/"+date+".png");

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);
        driver.quit();
        
        var htmlReporter = new ExtentHtmlReporter("/users/balaje/Screenshots/extentreports/reports/");
        var extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        var test = extent.createTest("Extend Test Case");
        test.log(Status.INFO, "Test case starts");
        test.log(Status.PASS, "Test case for pass");
        test.log(Status.FAIL, "Test case for fail");

    }
	
    
    
    public static void main(String[] args) throws Exception {
    	validateString p1 = new validateString();
p1.OpenUrl();
    }

}



