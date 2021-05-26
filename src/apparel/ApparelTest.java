package apparel;

import browsersetup.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ApparelTest extends BaseTest {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    /*  @After
      public void closebrowser(){
          driver.quit();
      }*/

//1. click on apparel and navigate to clothing
    @Test
    public void verifyUserShouldNavigateToClothingPageSuccessfully() throws InterruptedException {
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[2]/a[1]"));
        clickonelement(By.linkText("Custom T-Shirt"));


    }
//2. select product and successfully checkout
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
       Thread.sleep(10000);
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
      //  mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[2]/a[1]"));
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[2]/a[1]"));


//  click on "Grid"
        Thread.sleep(5000);
        clickonelement(By.xpath("//a[contains(text(),'Grid')]"));
        Thread.sleep(5000);
        clickonelement(By.linkText("Custom T-Shirt"));

//clickonelement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]"));


//  Enter your text: on t-shirt
        Thread.sleep(2000);
        sendtexttoelement(By.xpath("//input[@id='product_attribute_12']"),"LOVE");


//  Click on “ADD TO CART” tab
        Thread.sleep(2000);
        clickonelement(By.xpath("//button[@id='add-to-cart-button-29']"));

//  Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(2000);
        String expectedMessage3 = "The product has been added to your shopping cart";
        String actualMessage3 = gettextfromelemrnt(By.xpath("//body/div[@id='bar-notification']/div[1]"));
        Assert.assertEquals("cannot show bar notification", expectedMessage3, actualMessage3);

//  After that close the bar clicking on the cross button.
        Thread.sleep(2000);
        clickonelement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

//  Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickonelement(By.xpath("//body/div[6]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]"));

//  Verify the message "Shopping cart"
        Thread.sleep(1000);
        String expectedMessage4 = "Shopping cart";
        String actualMessage4 = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("cannot show bar notification", expectedMessage4, actualMessage4);
//        quantity "5"
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        sendtexttoelement(By.xpath("//input[@value='1']"), "5");
        clickonelement(By.xpath("//button[contains(text(),'Update shopping cart')]"));


//  Verify the price “$75.00”
        Thread.sleep(2000);
        String expectedMessage5 = "$75.00";
        String actualMessage5 = gettextfromelemrnt(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("cannot verify total", expectedMessage5, actualMessage5);


//  click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickonelement(By.xpath("//input[@id='termsofservice']"));

//  Click on “CHECKOUT”
        Thread.sleep(1000);
        clickonelement(By.xpath("//button[@id='checkout']"));

//  Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(2000);
        String expectedMessage6 = "Welcome, Please Sign In!";
        String actualMessage6 = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("cannot checkout successfully", expectedMessage6, actualMessage6);

       /* //        login into nopcommerce acc
        clickonelement(By.xpath("//a[contains(text(),'Log in')]"));

//        login details
        Thread.sleep(3000);
        sendtexttoelement(By.xpath("//input[@id='Email']"),"Seend1962@dayrep.com");
        sendtexttoelement(By.xpath("//input[@id='Password']"),"send962d");

//click on check box remember me?
        clickonelement(By.xpath("//input[@id='RememberMe']"));

//        click on login button
        clickonelement(By.xpath("//button[contains(text(),'Log in')]"));
*/

        Thread.sleep(8000);
        //click pon register
clickonelement(By.xpath("//button[contains(text(),'Register')]"));
       // Verify the text “Register”

        Thread.sleep(1000);
        String expectedMessage7 = "Register";
        String actualMessage7 = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("cannot reached at sign in page", expectedMessage7, actualMessage7);

// Fill the mandatory fields
        Thread.sleep(3000);
        clickonelement(By.xpath("//input[@id='gender-male']"));
        sendtexttoelement(By.xpath("//input[@id='FirstName']"),"mickle");
        sendtexttoelement(By.xpath("//input[@id='LastName']"),"honey");
        selectbyvaluefromdropdown(By.xpath("//select[@name='DateOfBirthDay']"),"29");
        selectbyvaluefromdropdown(By.xpath("//select[@name='DateOfBirthMonth']"),"2");
        selectbyvaluefromdropdown(By.xpath("//select[@name='DateOfBirthYear']"),"2000");

        //EMAIL CHANGE EVERYTIME
        sendtexttoelement(By.xpath("//input[@id='Email']"),"vot@yahoo.com");
        sendtexttoelement(By.xpath("//input[@id='Company']"),"amazon");
        sendtexttoelement(By.xpath("//input[@id='Password']"),"send962d");
        sendtexttoelement(By.xpath("//input[@id='ConfirmPassword']"),"send962d");

// Click on “REGISTER” Button
        clickonelement(By.xpath("//button[@id='register-button']"));
// Verify the message “Your registration completed”
        Thread.sleep(1000);
        String expectedMessage8 = "Your registration completed";
        String actualMessage8 = gettextfromelemrnt(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("cannot reached at sign in page", expectedMessage8, actualMessage8);
// Click on “CONTINUE” tab
        clickonelement(By.xpath("//a[contains(text(),'Continue')]"));
// Verify the text “Shopping cart”
        Thread.sleep(1000);
        String expectedMessage9 = "Shopping cart";
        String actualMessage9 = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("cannot reached at shopping cart", expectedMessage9, actualMessage9);

// click on checkbox “I agree with the terms of service”
        clickonelement(By.xpath("//input[@id='termsofservice']"));

// Click on “CHECKOUT”
        clickonelement(By.xpath("//button[@id='checkout']"));
// Fill the Mandatory fields
        Thread.sleep(5000);
        sendtexttoelement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"Bhutan");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_City']"),"brighton");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"po2 go9");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"309011");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07764213412");
//click on register
        Thread.sleep(1000);
        clickonelement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));


Thread.sleep(5000);
        // clickonelement(By.xpath("//input[@id='shippingoption_1']"));
        // clickonelement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        Thread.sleep(3000);
        clickonelement(By.xpath("//input[@id='shippingoption_2']"));
        clickonelement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        clickonelement(By.xpath("//input[@id='paymentmethod_1']"));
        clickonelement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

Thread.sleep(5000);
        selectbyvaluefromdropdown(By.xpath("//select[@id='CreditCardType']"),"Amex");
        sendtexttoelement(By.xpath("//input[@id='CardholderName']"),"mickle");
        sendtexttoelement(By.xpath("//input[@id='CardNumber']"),"373968682242638");
        sendtexttoelement(By.xpath("//select[@id='ExpireMonth']"),"8");
        sendtexttoelement(By.xpath("//select[@id='ExpireYear']"),"2027");
        sendtexttoelement(By.xpath("//input[@id='CardCode']"),"380");
        clickonelement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

//click on confirm
             clickonelement(By.xpath("//button[contains(text(),'Confirm')]"));

//verify
        Thread.sleep(3000);
        String expectedMessage12 = "Thank you";
        String actualMessage12 = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("order not placed ", expectedMessage12, actualMessage12);

//        verify Thank you
        Thread.sleep(3000);
        String expectedMessage13 = "Your order has been successfully processed!";
        String actualMessage13 = gettextfromelemrnt(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("order not placed ", expectedMessage13, actualMessage13);

//        click countinue
        clickonelement(By.xpath("//button[contains(text(),'Continue')]"));

//        verify Welcome to our store
        //h2[contains(text(),'Welcome to our store')]
        Thread.sleep(1000);
        String expectedMessage14 = "Welcome to our store";
        String actualMessage14 = gettextfromelemrnt(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("order not placed ", expectedMessage14, actualMessage14);







    }

}
