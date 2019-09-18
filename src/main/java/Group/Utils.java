package Group;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

//import java.nio.channels.SeekableByteChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage {

   //open chrome Browser
    public void openchromeBrowser(){
        driver  = new ChromeDriver();
        //maximise the browser window screen
        driver.manage().window().fullscreen();
        //set implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //open the website
        //driver.get(loadProps.getProperty("Url"));
    }
    public void driverquit(){
        driver.quit();
    }
    //to click ob elements
    public void clickonLocator(By by)
    {
     driver.findElement(by).click();
    }

    // to enter text of element
    public void entertext(By by, String text)
    {
     driver.findElement(by).sendKeys(text);
    }

    // to get the text for expected and actual result
    public String gettext(By by)
    {
     return driver.findElement(by).getText();
    }
    //wait unit it find element to click
    public static void waitForClickable(By by,long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    //explicit method for visible element
    public static void waitForElementVisible(By by,long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    //alert wait method
    public static void waitForAlertPresent(By by,long time) {
          WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.alertIsPresent());
    }
    //explicit wait method for invisible element
    public static void waitForElementInvisble(By by, long time)
    {
        WebDriverWait wait = new WebDriverWait(BasePage.driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    //
    public String generateEmail(String startValue)
    {
        String email = startValue.concat(new Date().toString());
        return email;
    }
   //using random date method
    public static String randomDate(){
        DateFormat format=new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());
    }
    //to cleat  the text
    public void clearlocator(By by)
    {
     driver.findElement(by).clear();

    }
    //to clear and enter the text
    public void clearandenteranelement(By by,String text)
    {
      driver.findElement(by).clear();
      driver.findElement(by).sendKeys(text);
    }
  //dropdown method by value
    public void selectbyValue(By by,String value){
        Select select=new Select(driver.findElement(by));
        select.selectByValue(value);
        //default value in dropdown
        //select.getFirstSelectedOption();
    }
    //using dropdown by visible
    public void selectbyvisibletext(By by,String text){
        Select select=new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    //using dropdown by index
    public void selectbyindex(By by,int num){
        Select select=new Select(driver.findElement(by));
        select.selectByIndex(num);
    }
    public void dropdownPresent(By by)
     {
        Select select=new Select(driver.findElement(by));
        select.getOptions();
     }
     //to navigate
    public void navigateback(){
       driver.navigate().back();
     }
    //checking webelement present on webpage
    //1. isSelected()
    public boolean webElementIsSelected(By by)
    {
        return driver.findElement(by).isSelected();
    }
    //2. isEnabled()
    public boolean webElementIsEnabled(By by)
    {
        return driver.findElement(by).isEnabled();
    }
    //3. isDisplayed()
    public  boolean webElementisDisplayed(By by)
    {
        return driver.findElement(by).isDisplayed();
    }
 //get attribute with no retun
  public void getAttribute(By by,String text){
      driver.findElement(by).getAttribute(text);
  }
  // get css value
  public void getCssVaue(By by,String text){
      driver.findElement(by).getCssValue(text);
}
}