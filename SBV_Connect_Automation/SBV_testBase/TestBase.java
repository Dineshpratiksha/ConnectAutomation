package SBV_testBase;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import SBV_utility.ExceptionHandling;
import SBV_utility.Logs;

public class TestBase extends pageBase {
	
	public static String TestCaseName;
	
	public static void waitForElement(By locator, long ltime) throws Exception {
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(ltime));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			Logs.info("Element is visible");
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Element not available");
		}
	}
	
	public static void typeinTextBox(By locator , String data,String elementName) throws Exception {
		try {
			if(driver.findElement(locator).isDisplayed()) {
				driver.findElement(locator).clear();
				driver.findElement(locator).sendKeys(data);
				Logs.info("Text Entered into "+elementName);
			}else {
				Logs.info("Unable to enter text into "+elementName);
			}
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to Identify text field ");
		}
	}
	
	public static void clickonElement(By locator, String elementName) throws Exception {
		boolean bflag=false;
		try {
			if(driver.findElement(locator).isDisplayed()) {
				driver.findElement(locator).click();
				bflag=true;
				Logs.info("Clicked on "+elementName);
			}
			else {
				Logs.info("Unable to click on  "+elementName);
			}
			
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to click on element "+elementName);
		}
	}
	
	public static void JsclickonElement(By locator, String elementName) throws Exception {
		boolean bflag=false;
		try {
			if(driver.findElement(locator).isDisplayed()) {
				bflag=true;
				JavascriptExecutor executor=(JavascriptExecutor) driver;
				executor.executeAsyncScript("arguments[0].click();", driver.findElement(locator));
				Logs.info("Click on  "+elementName);
			}
			else {
				Logs.info("Unable to click on  "+elementName);
			}
			
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to click on element "+elementName);
		}
	}
	
	public static String getElementText(By locator, String elementName) throws Exception {
		String sText="";
		try {
			if(driver.findElement(locator).isDisplayed()) {
				sText=driver.findElement(locator).getText();
				Logs.info("Text got from "+elementName);
			}else
			{
				Logs.info("Unable to get Text from "+elementName);
			}
			
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to get text from element"+elementName);
		}
		return sText;
	}
	
	public static void ScrollToElementByPixel(int pixelSize) throws Exception {
		try {
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) (TestBase.driver);
			javascriptExecutor.executeScript("window.scrollBy(0, " + pixelSize + ")", "");
			Logs.info("Element is Scrolled");
		} catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "unable to scroll");
		}
	}
	
	public static void NavigateToNewTab(int Tabnumber,String elementName) throws Exception {
		boolean bflag=false;
		
		try {
			pageBase.driver.switchTo().newWindow(WindowType.TAB);
			Logs.info("Navigated to New tab");
			}catch(Exception e) {
				ExceptionHandling.HandleExecption(e, "Unable to move new Tab"+elementName);
			}
	}
	public static List windowHandles(int TabNumber,String elementName) throws Exception {
		try {
			Set<String> windowHandle=pageBase.driver.getWindowHandles();
			List<String> windowHandleList= new ArrayList<>(windowHandle);
			
			pageBase.driver.switchTo().window(windowHandleList.get(TabNumber));
			Logs.info("Using Window Handles");
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to move given window"+elementName);
		}
		return null;
	}
	public static void NeavigateToNewWindow(int Window,String elementName) throws Exception {
		boolean bflag=false;
		
		try {
			pageBase.driver.switchTo().newWindow(WindowType.WINDOW);
			Logs.info("Navigated to New tab");
			}catch(Exception e) {
				ExceptionHandling.HandleExecption(e, "Unable to move new Window"+elementName);
			}
	}
	
	public static void clearTextbox(By object,String elementName) throws Exception {
        try {
            if(driver.findElements(object).size() > 0) {
                driver.findElement(object).clear();
                Logs.info("text is cleared from"+elementName);
            } else ExceptionHandling.HandleAssertion("Unable to find Element");
        }
        catch (Exception e) {
        	ExceptionHandling.HandleExecption(e,"Failed to clear text from " + elementName);
        }
    }
	
	public static void doubleClick(By object, String elementName) throws Exception {
		try {
			if (driver.findElement(object).isDisplayed()) {
				WebElement mo = driver.findElement(object);
				new Actions(driver).moveToElement(mo).doubleClick().build().perform();
				 Logs.info("able to double click to"+elementName);
			} else {
				ExceptionHandling.HandleAssertion("Failed to click on " + elementName);
			}
		} catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "Failed to click on " + elementName);
		}
	}
	
	public static void RightClick(By object, String elementName) throws Exception {
		try {
			if (driver.findElement(object).isDisplayed()) {
				WebElement mo = driver.findElement(object);
				new Actions(driver).moveToElement(mo).contextClick().build().perform();
				Logs.info("able to Right click on"+elementName);
			} else {
				ExceptionHandling.HandleAssertion("Failed to click on " + elementName);
			}
		} catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "Failed to click on " + elementName);
		}
	}
	
	public static void RefreshPage() {
		driver.navigate().refresh();
		Logs.info("able to refresh page");
	}
	
	public static boolean isElementVisible(By object,String elementName) throws Exception {
		boolean bFlag = false;
		try {
			if(driver.findElements(object).size() > 0) {
				bFlag= true;
				Logs.info("able to Right click to"+elementName);
			}
		} catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to check if the " + elementName +" element is visible or not");
		}
		return bFlag;
	}
	public static List<WebElement> getElements(By Obj) throws Throwable {
		List<WebElement> webele = null;
		try {
			Thread.sleep(1000);
			webele = driver.findElements(Obj);
			Logs.info("elements are stored in array");
		} catch (Exception e) {
			ExceptionHandling.HandleExecption(e, e.toString());
		}
		return webele;
	}
	
	public static WebElement getListElementsText(By object) throws Exception {
		try {
			List<WebElement> listofele = driver.findElements(object);
			for(WebElement i : listofele) {
				return i;
			}
			Logs.info("elements are stored in list");
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Fail to locate Elements");

		}
		
		return null;
		}
	
	public static WebElement getListElementsTextList(By object) throws Exception {
		List<String> elements = new ArrayList<>();
		try {
			List<WebElement> listofele = driver.findElements(object);
			for(WebElement i : listofele) {
				String text = i.getText();
				elements.add(text);
			}
			Logs.info("elements are stored in list");
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Fail to locate Elements");
		}
		return null;
		}
	
	public static boolean isDisplayed(By profileName) throws Exception {
		boolean flag = false;
		
		try {
			flag = driver.findElement(profileName).isDisplayed();
			Logs.info("elements is displayed");
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "incorrect profile name");

		}
		return false;	
	}
	
	public static void dropdownSelectElement(By objLocator, String sVisibletext) throws Throwable {
		try {
			Select s = new Select(driver.findElement(objLocator));
			s.selectByVisibleText(sVisibletext);
			Logs.info("elements is selected from dropdown");
		} catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "Option not selected");
		}
	}
	
	public static void ClickWithActions(By object, String elementName) throws Exception {
		try {
			if (driver.findElement(object).isDisplayed()) {
				WebElement mo = driver.findElement(object);
				new Actions(driver).moveToElement(mo).click().build().perform();
				Logs.info("elements is clicked");
			} else {
				ExceptionHandling.HandleAssertion("Failed to click on " + elementName);
			}
		} catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "Failed to click on " + elementName);
		}
	}
	
	public static void mouseOver(By ele) throws Exception {
		try {
			Actions action = new Actions(pageBase.driver);
			action.moveToElement(driver.findElement(ele)).build().perform();
			Logs.info("elements is moved");
		}catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "Failed to click on ");
		}
	}
	public static void ClickViaMouse(By object,String elementName) throws Exception {
		try {
			if(driver.findElements(object).size() > 0) {
				WebElement mo = driver.findElement(object);
				new Actions(driver).moveToElement(mo).click().build().perform();
				Logs.info("elements is clicked");
			}
			else {
				ExceptionHandling.HandleAssertion("Unable to click on element " + elementName);
			}
		} catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "Failed to click on " + elementName );
		}
	}
	public static void ClickWithActions(By Nearobj,By targetobj,String eleName) throws Exception {
		try {
			WebElement nearEle = driver.findElement(Nearobj);
			WebElement targetEle = driver.findElement(targetobj);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",targetEle);
			if(driver.findElement(targetobj).isDisplayed()) {
				new Actions(driver).moveToElement(nearEle).click(targetEle).build().perform();
				Logs.info("elements is clicked");
			}else {
				ExceptionHandling.HandleAssertion("Element"+eleName+" not Displayed");
			}
		}catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to click on "+eleName);
		}
	}
	
	public static String getCurrentDateTime(String timeZone, String elementName) {
		String getCurrentDateandTime = null;
		try {
			TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
			SimpleDateFormat dateformat = new SimpleDateFormat("ddMMyyyyhhmmss");
			Date date = new Date();
			getCurrentDateandTime = dateformat.format(date);
			Logs.info("date and time is displayed");
		}catch(Exception e) {
			Logs.info("Unable to get the time and date of "+timeZone+" timezone");
		}
		return getCurrentDateandTime;
	}
	public static boolean waitForElementToBevisible(By Locator, long lTime) throws Exception {
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));	
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			Logs.info("elements is displayed");
			return true;
		} 
		
		catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "Failed to wait for element to be visible");
			return true;
		}
	}
	public static void ScrollDownBottom() throws Throwable {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("window.scrollBy(0,300);");
	            Logs.info("elements is scrolled");
	        } catch (Exception e) {
	        	ExceptionHandling.HandleExecption(e, "unable to scroll");

	        }
	}
	
	
	public static String getTextFromPropertis(By object) throws Exception {
		String text = null;
		try {
			text = (String) ((JavascriptExecutor) pageBase.driver).executeScript("return arguments[0].value;", pageBase.driver.findElement(object));	
			Logs.info("text is getting from properties");
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "unable to get text from properties");
		}
		
		return text;
		
	}
	
	public static String getElementAttribute(By object, String AttributeName, String elementName) throws Exception {
		String sText = "";
		try {
			if(driver.findElement(object).isDisplayed()) {
				sText = driver.findElement(object).getAttribute(AttributeName);
				Logs.info("elements is getting attribute");
			}else {
				Logs.info("failed to get Text from the "+ elementName + "Element");
			}
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Element Text not available");
		}
		return sText;
		
	}
	
	public static String getFakeName() {

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        Logs.info("name is displayed");
        return firstName;
    }

   public static String getFakeLastname() {

        Faker faker = new Faker();
        String LastName = faker.name().lastName();
        Logs.info("last name is displayed");
        return LastName;

    }  
	
   public static List windowHandle(int TabNumber,String elementName) throws Exception {
		try {
			Set<String> windowHandle=pageBase.driver.getWindowHandles();
			List<String> windowHandleList= new ArrayList<>(windowHandle);
			
			pageBase.driver.switchTo().window(windowHandleList.get(TabNumber)).close();
			Logs.info("Using Window Handles");
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to move given window"+elementName);
		}
		
		return null;
		
	}
	
   public static void scrollUp() throws Exception
	{
		try {
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
			  Logs.info("element is scrolled");
		} catch (Exception e) {
			ExceptionHandling.HandleExecption(e, e.getMessage());
		}
		
	}
   
   public static void FileUpload(By object,String filepath) throws Exception
	{
       try {
			Thread.sleep(3000);
	        String absoluteFilePath = System.getProperty("user.dir") + "/" + filepath;
	        pageBase.driver.findElement(object).sendKeys(absoluteFilePath);
	        Logs.info("File is uploaded Sucessfully");
	        
       }catch (Exception e){
			ExceptionHandling.HandleExecption(e, "Unable to upload file");



       }
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
