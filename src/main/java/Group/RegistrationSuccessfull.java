package Group;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.plugin.ClassLoaderInfo;

import java.util.concurrent.TimeUnit;

import static Group.BasePage.driver;

public class RegistrationSuccessfull extends Utils {
    LoadProps loadProps = new LoadProps();

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDriver\\chromedriver.exe");
        openchromeBrowser();
        driver.get(loadProps.getProperty("Url"));
    }
    @AfterMethod
    public void quit(){
        driverquit();
    }

    @Test
    public void UserShouldAbleToRegisterSuccessfully() {
        clickonLocator(By.xpath("//a[@class='ico-register']"));
        entertext(By.id("FirstName"), loadProps.getProperty("FirstName"));
        entertext(By.xpath("//input[@name='LastName']"), loadProps.getProperty("LastName"));
        // entertext(By.name("Email"),);
        selectbyValue(By.xpath("//select[@name=\"DateOfBirthDay\"]"), "2");
        selectbyvisibletext(By.xpath("//select[@name=\"DateOfBirthMonth\"]"), "February");
        selectbyindex(By.xpath("//select[@name='DateOfBirthYear']"), 4);
        webElementisDisplayed(By.xpath("//a[@href='/']"));
        entertext(By.name("Email"), loadProps.getProperty("EmailName1") + randomDate() + loadProps.getProperty("EmailFormat1"));
        //enter password
        entertext(By.id("Password"), loadProps.getProperty("password"));
        //re-enter same password to confirm
        entertext(By.id("ConfirmPassword"), loadProps.getProperty("password"));
        //click on register
        clickonLocator(By.name("register-button"));
        //expected result
        String expectedresult = loadProps.getProperty("regmsg");
        //actual result
        String actual = gettext(By.xpath("//div[@class=\"result\"]"));

        //Comparing actual and expected result
        Assert.assertEquals(actual, expectedresult);
    }


    @Test
    public void userShouldAbletoSendAnEmail() {
        clickonLocator(By.xpath("//a[@class='ico-register']"));
        entertext(By.id("FirstName"), loadProps.getProperty("FirstName"));
        entertext(By.xpath("//input[@name='LastName']"), loadProps.getProperty("LastName"));
        // entertext(By.name("Email"),);
        selectbyValue(By.xpath("//select[@name=\"DateOfBirthDay\"]"), "2");
        selectbyvisibletext(By.xpath("//select[@name=\"DateOfBirthMonth\"]"), "February");
        selectbyindex(By.xpath("//select[@name='DateOfBirthYear']"), 4);
        webElementisDisplayed(By.xpath("//a[@href='/']"));
        entertext(By.name("Email"), loadProps.getProperty("EmailName1") + randomDate() + loadProps.getProperty("EmailFormat1"));
        //enter password
        entertext(By.id("Password"), "password");
        //re-enter same password to confirm
        entertext(By.id("ConfirmPassword"), "password");
        //click on register
        clickonLocator(By.name("register-button"));
        //click on continue button
        clickonLocator(By.name("register-continue"));
        //click on apple macbook
        clickonLocator(By.linkText("Apple MacBook Pro 13-inch"));
        // driver.findElement(By.xpath("//h2/a[@href=\"/electronics\"]")).click();
        //send a email
        clickonLocator(By.xpath("//div[@class='email-a-friend']"));
        //friends email
        entertext(By.className("friend-email"), loadProps.getProperty("friendemail"));
        //message
        entertext(By.xpath("//textarea[@placeholder='Enter personal message (optional)]"), loadProps.getProperty("msg"));
        //send email
        clickonLocator(By.name("send-email"));
        //compare the send message
        String expectresult = loadProps.getProperty("confmsgforfrndemail");
        String actualresult = gettext(By.cssSelector("div.result"));
        Assert.assertEquals(actualresult, expectresult);
    }

    @Test(priority = 2)
    public void userShouldNavigateToCameraAndPhoto() {//click on Electronics
        clickonLocator(By.linkText("Electronics"));
        //click on camera and photo
        clickonLocator(By.linkText("Camera & photo"));
        //need to verify expected ans actual message
        String expectedmsgcamera = loadProps.getProperty("MessageForAFriend");
        String actualcamera = gettext(By.tagName("h1"));
        Assert.assertEquals(expectedmsgcamera, actualcamera);
    }

    @Test(priority = 3)
    public void userShouldbeabletoSelectJewelryByPrice() {
        //go to Jewelry category
        clickonLocator(By.linkText("Jewelry"));
        //select price$700-&3000
        clickonLocator(By.xpath("//a[@href=\"//demo.nopcommerce.com/jewelry?price=700-3000\"]"));
        //find min range
        String minrange = gettext(By.xpath("//span[@class=\"PriceRange\"][1]"));
        //replace $ using string  replace() method
        String minrange1 = String.valueOf(minrange.replace("$", ""));
        //convert double to int
        double minrange2 = Double.valueOf(minrange1);
        //find max range
        String maxrange = gettext(By.xpath("//span[@class=\"PriceRange\"][2]"));
        String maxrange1 = String.valueOf(maxrange.replace("$", ""));
        String maxrange2 = String.valueOf(maxrange1.replace(",", ""));
        double maxrange3 = Double.valueOf(maxrange2);
        //Expected result value
        String myvalue = gettext(By.xpath("//span[@class=\"price actual-price\"]"));
        String myvalue1 = String.valueOf(myvalue.replace("$", ""));
        String myvalue2 = String.valueOf(myvalue1.replace(",", ""));
        double myvalue3 = Double.valueOf(myvalue2);

        Assert.assertTrue(myvalue3 >= minrange2 && myvalue3 <= maxrange3);

    }

    @Test(priority = 4)
    public void userShouldAbleToAddTwoBooks() {//click on books
        clickonLocator(By.linkText("Books"));
        //click on specific
        clickonLocator(By.linkText("Fahrenheit 451 by Ray Bradbury"));
        //click on add to cart
        clickonLocator(By.id("add-to-cart-button-37"));
        //click on cancel button
       // clickonLocator(By.className("close"));
        // nagivate to back
         navigateback();
        //click on second back
        clickonLocator(By.linkText("First Prize Pies"));
        //click on add to cart
        clickonLocator(By.id("add-to-cart-button-38"));
        //click on close
        clickonLocator(By.className("close"));
        //click on shopping cart
        clickonLocator(By.linkText("Shopping cart"));
        //actual result
        String actualsku1book = gettext(By.xpath("//span[text()='FR_451_RB']"));
        //expected result
        String expectedsku1book = "FR_451_RB";
        Assert.assertEquals(actualsku1book,expectedsku1book);
        String actualr2book = gettext(By.xpath("//span[text()='FIRST_PRP']"));
        String expectr2book= "FIRST_PRP";
        Assert.assertEquals(actualr2book,expectr2book);
    }
}



