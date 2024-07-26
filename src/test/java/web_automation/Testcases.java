package web_automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Testcases {
	 WebDriver driver = new ChromeDriver();
	
	
	@BeforeMethod
	public void beforetestt() {
		 driver.get("file:///C:/Users/User/Desktop/Nitheesh/AutomationChallenge_2022%20(1)/QE-index.html");
	      driver.manage().window().maximize();
	}
	public void aftertestt() {
		driver.quit();
	}
  @Test
  public void Test1() throws InterruptedException {
	 
      WebElement emailAddress = driver.findElement(By.xpath("//*[@id='inputEmail']"));
      WebElement password = driver.findElement(By.xpath("//*[@id='inputPassword']"));
      WebElement signinButton = driver.findElement(By.xpath("//*[@class='btn btn-lg btn-primary btn-block']"));

      assert emailAddress.isDisplayed() & emailAddress.isEnabled();
      assert password.isDisplayed()  & password.isEnabled();
      assert signinButton.isDisplayed() & signinButton.isEnabled();

      emailAddress.sendKeys("nitheesh2267@gmail.com");
      password.sendKeys("test");
      Thread.sleep(3000);
      signinButton.click();

   Thread.sleep(3000);
   
  }
 
  @Test
public void Test2() {
	
      WebElement test2div = driver.findElement(By.xpath("//*[@id=\"test-2-div\"]/h1"));
      List<WebElement> elementvalues = test2div.findElements(By.className("elementvalues"));

      assert elementvalues.size() == 3:"Expected 3 items But got :"+elementvalues.size();

      WebElement secondlist = elementvalues.get(1);
      String secodlistText = secondlist.getText().trim();
      assert secodlistText.equals("List Item 2"):"Expected List Item 2 but got :"+secodlistText;

      WebElement secondlistbadgeValue = driver.findElement(By.xpath("//*[@id=\"test-2-div\"]/ul/li[3]"));
      String badgetext = secondlistbadgeValue.getText().trim();
      assert badgetext.equals("6"):"Expected 6 but got : "+badgetext;

      driver.quit();

	  
  }

public void Test3() {

     WebElement dropdown = driver.findElement(By.xpath("//*[@class='btn btn-secondary dropdown-toggle']"));
     Select select = new Select(dropdown);
     WebElement selectOption = select.getFirstSelectedOption();
     String defaultSelectValue = selectOption.getText();
     assertEquals("Option 1",defaultSelectValue);

     select.selectByVisibleText("Option 3");

     driver.close();

	  
}

public void Test4() {
	 
      WebElement firstbutton = driver.findElement(By.xpath("//*[@class='btn btn-lg btn-primary']"));
      WebElement SecondButton = driver.findElement(By.xpath("//*[@class='btn btn-lg btn-secondary']"));
     
      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
      WebElement div = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"test-4-div\\\"]/h1")));
      if(firstbutton.isEnabled()) {
      	System.out.println("First button is enabled");
      }
      else {
      	System.out.println("First button is disabled");
      }
      
      if(!SecondButton.isEnabled()) {
      	System.out.println("Second button is disabled");
      }
      else
      	System.out.println("Second button is enabled.");
     driver.close();

}

@Test
public void test5() {
	 
       WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(2));
       WebElement div5 = driver.findElements(By.tagName("div")).get(4);
       WebElement button5 = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id ='test5-button']")));
       button5.click();
       
       WebElement successmsg = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id ='test5-alert']")));
       
       Assert.assertTrue("Success msg is not displayed",successmsg.isDisplayed());
       
       Assert.assertTrue("Button is not disabled", button5.getAttribute("disabled") != null);
      
            
}

@Test
public void test6() {
	
	          String cellvalue = getCellValues(driver,2,2);
	          Assert.assertEquals(cellvalue, "Ventosanzap","cell values are not matching as expected");
	  
     }

public static String getCellValues(WebDriver driver ,int row ,int column) {
	String cellXpath = String.format("//table[@class='table table-bordered table-dark']/tbody/tr[%d]/td[%d]", row+1,column+1);
	WebElement cell = driver.findElement(By.xpath(cellXpath));
	return cell.getText();
}

}




  

