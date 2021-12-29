package com.crm.Autodesk.genericutility;

import java.awt.Desktop.Action;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;



/**
 * its contains WebDriver specific reusable actions
 * 
 * @author DELL
 *
 */
public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * wait for page to load before identifying any assychronized[java scripts
	 * actions]element in DOM [HTML-Document]
	 * 
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}

	/**
	 * use to wait for element to be clickAble in GUI,& check for specific element
	 * for every 500 milli second
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickAble(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * used to wait for element to be clickable in GUI,& check for specific element
	 * for every 500 milli seconds
	 * 
	 * @param driver
	 * @param element
	 * @param pollingTime in the form second @ throws Throwable
	 */
	public void waitForElementWithCumtomTimeOut(WebDriver driver, WebElement element, int pollingTime)
			throws Throwable {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * used to switch to Any window based on Window Title
	 * 
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if (currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * used to switch to Alert window & click on OK button
	 * 
	 * @param driver
	 */
	public void switchToAlertWindowAndAccpect(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * used to switch on Alert window & click on Cancel button
	 * 
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * used to switch to Frame Window based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * used to switch to Frame Window based on id or name attribute
	 * 
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}

/**
 * used to select value from from the dropDown based on value/option available in GUI
 * @param element
 * @param text
 */
public void select(WebElement element, String text) {
Select sel = new Select(element);
sel.selectByVisibleText(text);
}

/**
 * used to place mouse cursor on specified element
 * @param driver
 * @param element
 */
public void mouseOverOnElement(WebDriver driver, WebElement element) 
{
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();

}
 /**
  * used to right click on specified element
  * @param driver
  * @param element
  */
public void rightClickOnElement(WebDriver driver,WebElement element) {
Actions act = new Actions(driver);
act.moveToElement(element).perform();
}
/**
 * 
 * @param driver
 * @param javaScript
 */
public void executeJavaScript(WebDriver driver,String javaScript) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeAsyncScript(javaScript, null);
}
   public void waitAndClick(WebElement element) throws InterruptedException
   {
	      int count=0;
	      while(count<20) {
	    	  try {
	    		  element.click();
	    		  break;
	    	  }catch(Throwable e) {
	    		  Thread.sleep(1000);
	    		  count++;
	    	  }
	      }
   }
   public void takeScreenshot(WebDriver driver,String screenshotName) throws Throwable {
	   TakesScreenshot ts =(TakesScreenshot)driver;
	   File src= ts.getScreenshotAs(OutputType.FILE);
	   File dest=new File("./screenshot/"+screenshotName+".PNG");
	   Files.copy(src,dest);
	    	  }
      public void passEnterKey(WebDriver driver) {
    	  Actions actions =new Actions(driver);
    	  actions.sendKeys(Keys.ENTER).perform();
	      }
      /**
       *  used to maximize the browser window 
       * @param driver
       */
      public void windowMaximize(WebDriver driver) {
    	  driver.manage().window().maximize();
      }

		
	}
   




