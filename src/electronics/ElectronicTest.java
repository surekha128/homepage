package electronics;

import browsersetup.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElectronicTest extends BaseTest {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

      @After
      public void closebrowser(){
          driver.quit();
      }
//1.Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
@Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
//1.1 Mouse Hover on “Electronics” Tab
//1.2 Mouse Hover on “Cell phones” and click
//1.3 Verify the text “Cell phones”
    mouseHoverToElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/a[1]"));
    mouseHoverToElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/a[1]"));
}

//2.	Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);
//2.1 Mouse Hover on “Electronics” Tab
//2.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(1000);
        WebElement electorics = driver.findElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        WebElement cellphones = driver.findElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]"));
        actions.moveToElement(electorics).moveToElement(cellphones).click().build().perform();

//2.3 Verify the text “Cell phones”
        Thread.sleep(3000);
        String expectedMessage = "Cell phones";
        String actualMessage = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("cannot click on cell phones", expectedMessage, actualMessage);
// 	2.4 Click on List View Tab
        clickonelement(By.xpath("//a[contains(text(),'List')]"));
//	2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickonelement(By.xpath("//h2[@class='product-title']/a[text()='Nokia Lumia 1020']"));
//	2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(1000);
        String expectedMessage1 = "Nokia Lumia 1020";
        String actualMessage1 = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
       Assert.assertEquals("cannot click on cell phones", expectedMessage1, actualMessage1);
//	2.7 Verify the price “$349.00”
        Thread.sleep(1000);
        String expectedMessage2 = "$349.00";
       String actualMessage2 = gettextfromelemrnt(By.xpath("//span[@id='price-value-20']"));
       Assert.assertEquals("cannot click on price", expectedMessage2, actualMessage2);
//	2.8 Change quantity to 2
        Thread.sleep(100);
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        sendtexttoelement(By.xpath("//input[@value='1']"), "2");
//	2.9 Click on “ADD TO CART” tab
        clickonelement(By.xpath("//button[@id='add-to-cart-button-20']"));
//	2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(1000);
        String expectedMessage3 = "The product has been added to your shopping cart";
        String actualMessage3 = gettextfromelemrnt(By.xpath("//body/div[@id='bar-notification']/div[1]"));
        Assert.assertEquals("cannot click on addtocart", expectedMessage3, actualMessage3);
//After that close the bar clicking on the cross button.
        clickonelement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

//2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickonelement(By.xpath("//li[@id='topcartlink']"));
//2.12 Verify the message "Shopping cart"
        Thread.sleep(1000);
        String expectedMessage4 = "Shopping cart";
        String actualMessage4 = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("cannot click on addtocart", expectedMessage4, actualMessage4);
//2.13 Verify the quantity is 2
        Thread.sleep(1000);
        String expectedMessage5 = "(2)";
        String actualMessage5 = gettextfromelemrnt(By.xpath("//span[contains(text(),'(2)')]"));
        Assert.assertEquals("quantity is not 2", expectedMessage5, actualMessage5);
//2.14 Verify the Total $698.00
        Thread.sleep(1000);
        String expectedMessage6 = "$698.00";
        String actualMessage6 = gettextfromelemrnt(By.xpath("//tr[@class='order-total']/td[2]"));
        Assert.assertEquals("total is not matched", expectedMessage6, actualMessage6);
        Thread.sleep(1000);
//2.15 click on checkbox “I agree with the terms of service”
        clickonelement(By.xpath("//input[@id='termsofservice']"));
//2.16 Click on “CHECKOUT”
        clickonelement(By.xpath("//button[@id='checkout']"));
//	2.17 Verify the Text “Welcome, Please Sign In!”

        Thread.sleep(1000);
        String expectedMessage7 = "Welcome, Please Sign In!";
        String actualMessage7 = gettextfromelemrnt(By.xpath(" //h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("cannot reached at sign in page", expectedMessage7, actualMessage7);

// 	2.18 Click on “REGISTER” tab
        clickonelement(By.xpath("//button[contains(text(),'Register')]"));
//	2.19 Verify the text “Register”

        Thread.sleep(1000);
        String expectedMessage8 = "Register";
        String actualMessage8 = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("cannot reached at sign in page", expectedMessage8, actualMessage8);

//	2.20 Fill the mandatory fields
        Thread.sleep(3000);
        clickonelement(By.xpath("//input[@id='gender-male']"));
        sendtexttoelement(By.xpath("//input[@id='FirstName']"),"drake");
        sendtexttoelement(By.xpath("//input[@id='LastName']"),"bb");
        selectbyvaluefromdropdown(By.xpath("//select[@name='DateOfBirthDay']"),"25");
        selectbyvaluefromdropdown(By.xpath("//select[@name='DateOfBirthMonth']"),"10");
        selectbyvaluefromdropdown(By.xpath("//select[@name='DateOfBirthYear']"),"1928");

                                                                                                //EMAIL CHANGE EVERYTIME
        sendtexttoelement(By.xpath("//input[@id='Email']"),"motu@yahoo.com");
        sendtexttoelement(By.xpath("//input[@id='Company']"),"Nokia");
        sendtexttoelement(By.xpath("//input[@id='Password']"),"qwe123");
        sendtexttoelement(By.xpath("//input[@id='ConfirmPassword']"),"qwe123");

//	2.21 Click on “REGISTER” Button
        clickonelement(By.xpath("//button[@id='register-button']"));
//	2.22 Verify the message “Your registration completed”
        Thread.sleep(1000);
        String expectedMessage9 = "Your registration completed";
        String actualMessage9 = gettextfromelemrnt(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("cannot reached at sign in page", expectedMessage9, actualMessage9);
//2.23 Click on “CONTINUE” tab
        clickonelement(By.xpath("//a[contains(text(),'Continue')]"));
//2.24 Verify the text “Shopping cart”
        Thread.sleep(1000);
        String expectedMessage10 = "Shopping cart";
        String actualMessage10 = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("cannot reached at shopping cart", expectedMessage10, actualMessage10);

//2.25 click on checkbox “I agree with the terms of service”
        clickonelement(By.xpath("//input[@id='termsofservice']"));

//2.26 Click on “CHECKOUT”
        clickonelement(By.xpath("//button[@id='checkout']"));
//2.27 Fill the Mandatory fields
        Thread.sleep(5000);
        sendtexttoelement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United kingdom");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_City']"),"brighton");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"nfj43fj");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"309001");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07583213112");


//2.28 Click on “CONTINUE”
        Thread.sleep(3000);
        clickonelement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
//2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickonelement(By.xpath("//input[@id='shippingoption_2']"));
//2.30 Click on “CONTINUE”
        clickonelement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
//2.31 Select Radio Button “Credit Card”
        clickonelement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(2000);
        clickonelement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
//2.32 Select “Visa” From Select credit card dropdown
        Thread.sleep(1000);
        clickonelement(By.xpath("//select[@id='CreditCardType']"));
      //  selectbyvaluefromdropdown(By.xpath("//select[@id='CreditCardType']"),"Visa");
//2.33 Fill all the details
       Thread.sleep(4000);
        sendtexttoelement(By.xpath("//input[@id='CardholderName']"),"drake");
        sendtexttoelement(By.xpath("//input[@id='CardNumber']"),"4024007138399547");
        selectbyvaluefromdropdown(By.xpath("//select[@id='ExpireMonth']"),"6");
        selectbyvaluefromdropdown(By.xpath("//select[@id='ExpireYear']"),"2027");
        sendtexttoelement(By.xpath("//input[@id='CardCode']"),"578");
//2.34 Click on “CONTINUE”
        clickonelement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
//2.35 Verify “Payment Method” is “Credit Card”
        Thread.sleep(1000);
        String expectedMessage11 = "Credit Card";
        String actualMessage11 = gettextfromelemrnt(By.xpath("//li[@class='payment-method']/span[2]"));
        Assert.assertEquals("another payment method", expectedMessage11, actualMessage11);

//2.36 Verify “Shipping Method” is “2nd Day Air”
        Thread.sleep(1000);
        String expectedMessage12 = "2nd Day Air";
        String actualMessage12 = gettextfromelemrnt(By.xpath("//li[@class='shipping-method']/span[2]"));
        Assert.assertEquals("another shipping  method chosen", expectedMessage12, actualMessage12);

//2.37 Verify Total is “$698.00”
        Thread.sleep(1000);
        String expectedMessage13 = "$698.00";
        String actualMessage13 = gettextfromelemrnt(By.xpath("//tr[@class='order-total']/td[2]"));
        Assert.assertEquals("total value is different", expectedMessage13, actualMessage13);

//2.38 Click on “CONFIRM”
        clickonelement(By.xpath("//button[contains(text(),'Confirm')]"));
//2.39 Verify the Text “Thank You”

        Thread.sleep(1000);
        String expectedMessage14 = "Thank you";
        String actualMessage14 = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("not placed your order successfully ", expectedMessage14, actualMessage14);

//2.40 Verify the message “Your order has been successfully processed!”
        Thread.sleep(1000);
        String expectedMessage15 = "Your order has been successfully processed!";
        String actualMessage15 = gettextfromelemrnt(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("not placed your order successfully ", expectedMessage15, actualMessage15);

//2.41 Click on “CONTINUE”
        clickonelement(By.xpath("//button[contains(text(),'Continue')]"));
//2.42 Verify the text “Welcome to our store”
        Thread.sleep(1000);
        String expectedMessage16 = "Welcome to our store";
        String actualMessage16 = gettextfromelemrnt(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("not successfully loged out", expectedMessage16, actualMessage16);

//2.43 Click on “Logout” link
        clickonelement(By.xpath("//a[contains(text(),'Log out')]"));
//2.44 Verify the URL is “https://demo.nopcommerce.com/”
        Thread.sleep(1000);
        String expectedMessage17 = "https://demo.nopcommerce.com/";
        String actualMessage17 =(baseurl);
        Assert.assertEquals("not on website", expectedMessage17, actualMessage17);


    }
}
