package computer;

import browsersetup.BaseTest;
import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;


public class TestSuits extends BaseTest {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    /*  @After
      public void closebrowser(){
          driver.quit();
      }*/
/*Write the following Test:
1.Test name verifyProductArrangeInAlphaBaticalOrder()
	1.1 Click on Computer Menu.
	1.2 Click on Desktop
	1.3 Select Sort By position "Name: Z to A"
	1.4 Verify the Product will arrange in Descending order.*/
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //  clickonelement(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[1]/a"));
        Actions actions = new Actions(driver);

        WebElement Computers = driver.findElement(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[1]"));
        WebElement Desktops = driver.findElement(By.xpath("//ul[@class='sublist first-level']/li[1]"));

        actions.moveToElement(Computers).moveToElement(Desktops).click().build().perform();

        selectbyvaluefromdropdown(By.id("products-orderby"), "6");

        String expectedMessage = "Name: Z to A";
        WebElement message = driver.findElement(By.xpath("//select[@id='products-orderby']"));
        String actualMessage = gettextfromelemrnt(By.xpath("//select[@id='products-orderby']/option[3]"));
        Assert.assertEquals("User able to see Product will arrange in Descending order  Name: Z to A", expectedMessage, actualMessage);
    }
//2. Test name verifyProductAddedToShoppingCartSuccessFully()

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        Actions actions = new Actions(driver);
//2.1 Click on Computer Menu.
//2.2 Click on Desktop
        Thread.sleep(3000);
        WebElement Computers = driver.findElement(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[1]"));
        WebElement Desktops = driver.findElement(By.xpath("//ul[@class='sublist first-level']/li[1]"));
        actions.moveToElement(Computers).moveToElement(Desktops).click().build().perform();

//2.3 Select Sort By position "Name: A to Z"
        selectbyvaluefromdropdown(By.id("products-orderby"), "5");
//2.4 Click on "Add To Cart"
        Thread.sleep(3000);
        clickonelement(By.xpath("//button[@class='button-2 product-box-add-to-cart-button']"));
//2.5 Verify the Text "Build your own computer"*/
        Thread.sleep(2000);
        String expectedMessage = "Build your own computer";
        //  WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        String actualMessage = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("in add to cart user able to see build your own computer", expectedMessage, actualMessage);

//2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        Thread.sleep(3000);
        selectbyvaluefromdropdown(By.id("product_attribute_1"), "1");
//2.7.Select "8GB [+$60.00]" using Select class.
        Thread.sleep(3000);
        selectbyvaluefromdropdown(By.xpath("//select[@id='product_attribute_2']"), "5");
//2.8 Select HDD radio "400 GB [+$100.00]"
//2.9 Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(5000 );
        WebElement field = driver.findElement(By.xpath("//label[contains(text(),'HDD')]"));
        WebElement radiobtn = driver.findElement(By.xpath("//dd[@id='product_attribute_input_3']/ul/li[2]/input"));
        actions.moveToElement(field).moveToElement(radiobtn).click().build().perform();

//2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
       Thread.sleep(3000);
       WebElement os = driver.findElement(By.xpath("//dt[@id='product_attribute_label_4']"));
       WebElement radiobtn1 = driver.findElement(By.xpath("//input[@id='product_attribute_4_9']"));
       actions.moveToElement(os).moveToElement(radiobtn1).click().build().perform();


       Thread.sleep(3000);
       WebElement software = driver.findElement(By.xpath("//label[contains(text(),'Software')]"));
       WebElement total = driver.findElement(By.xpath("//input[@id='product_attribute_5_12']"));
       actions.moveToElement(software).moveToElement(total).click().build().perform();

//2.11 Verify the price "$1,475.00"
        Thread.sleep(3000);
        String expectedMessage1 = "$1,475.00";
        String actualMessage1 = gettextfromelemrnt(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals("total price value", expectedMessage1, actualMessage1);


//2.12 Click on "ADD TO CARD" Button.
        Thread.sleep(4000);
        clickonelement(By.xpath("//button[@id='add-to-cart-button-1']"));
// 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
//After that close the bar clicking on the cross button.
        clickonelement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        clickonelement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        Thread.sleep(1000);
        String expectedMessage2 = "The product has been added to your shopping cart";
        String actualMessage2 = gettextfromelemrnt(By.xpath("//body/div[@id='bar-notification']/div[1]"));
        Assert.assertEquals("cannot click on addtocart", expectedMessage2, actualMessage2);
//After that close the bar clicking on the cross button.

//2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
        WebElement shoppingcart = driver.findElement(By.xpath("//li[@id='topcartlink']"));
        WebElement clickcart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        actions.moveToElement(shoppingcart).moveToElement(clickcart).click().build().perform();

//2.15 Verify the message "Shopping cart"
        String expectedMessage3 = "Shopping cart";
        //  WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        String actualMessage3 = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("products in shopping cart", expectedMessage3, actualMessage3);

//2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        sendtexttoelement(By.xpath("//input[@value='1']"), "2");
        clickonelement(By.xpath("//button[contains(text(),'Update shopping cart')]"));

        //2.17 Verify the Total"$2,950.00"
        String expectedMessage4 = "$2,950.00";
        String actualMessage4 = gettextfromelemrnt(By.xpath("//tr[@class='order-total']/td/span"));
        Assert.assertEquals("cannot grt total value", expectedMessage4, actualMessage4);

//2.18 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickonelement(By.xpath("//input[@id='termsofservice']"));
//2.19 Click on “CHECKOUT”
        clickonelement(By.xpath("//button[@id='checkout']"));
//2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage5 = "Welcome, Please Sign In!";
        String actualMessage5 = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("please sign in", expectedMessage5, actualMessage5);

//2.21Click on “CHECKOUT AS GUEST”Tab
        Thread.sleep(1000);
        clickonelement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
//2.22 Fill the all mandatory field
        Thread.sleep(7000);
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"antarctica");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"loren");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_Email']"),"abc12@yahoo.com");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_Company']"),"processor");
        Thread.sleep(3000);
        //selectbyvaluefromdropdown((By.name("country")),"Ireland");
         sendtexttoelement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United kingdom");
        //selectbyvaluefromdropdown(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]"),"united kingdom");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_City']"),"brighton");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"nfj43fj");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"309001");
        sendtexttoelement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07583213112");


// 2.23 Click on “CONTINUE”
        clickonelement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
// 2.24 Click on Radio Button “Next Day Air($0.00)”
        clickonelement(By.xpath("//input[@id='shippingoption_1']"));
//2.25 Click on “CONTINUE”
        clickonelement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
//2.26 Select Radio Button “Credit Card”
        clickonelement(By.xpath("//input[@id='paymentmethod_1']"));
        clickonelement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
//2.27 Select “Master card” From Select credit card dropdown
        sendtexttoelement(By.xpath("//select[@id='CreditCardType']"),"Master card");
//2.28 Fill all the details
        Thread.sleep(4000);
        sendtexttoelement(By.xpath("//input[@id='CardholderName']"),"ghost");
        sendtexttoelement(By.xpath("//input[@id='CardNumber']")," 5137465850631425");
        //selectbyvaluefromdropdown(By.xpath("//select[@id='ExpireMonth']")," 12");
        sendtexttoelement(By.xpath("//select[@id='ExpireMonth']")," 12");
        selectbyvaluefromdropdown(By.xpath("//select[@id='ExpireYear']"),"2022");
        sendtexttoelement(By.xpath("//input[@id='CardCode']"),"439");

//2.29 Click on “CONTINUE”
        Thread.sleep(1000);
        clickonelement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
//2.30 Verify “Payment Method” is “Credit Card”
        String expectedMessage6 = "Credit Card";
        String actualMessage6 = gettextfromelemrnt(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("please select payment method", expectedMessage6, actualMessage6);

//2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedMessage7 = "Next Day Air";
        String actualMessage7 = gettextfromelemrnt(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Assert.assertEquals("please select shipping method", expectedMessage7, actualMessage7);

//	2.33 Verify Total is “$2,950.00”
        String expectedMessage8 = "$2,950.00";
        String actualMessage8 = gettextfromelemrnt(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("please select shipping method", expectedMessage8, actualMessage8);

// 	2.34 Click on “CONFIRM”
        clickonelement(By.xpath("//button[contains(text(),'Confirm')]"));

//	2.35 Verify the Text “Thank You”
        String expectedMessage9 = "Thank you";
        String actualMessage9 = gettextfromelemrnt(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("please select shipping method", expectedMessage9, actualMessage9);

//	2.36 Verify the message “Your order has been successfully processed!”
        String expectedMessage10 = "Your order has been successfully processed!";
        String actualMessage10 = gettextfromelemrnt(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("please select shipping method", expectedMessage10, actualMessage10);

//	2.37 Click on “CONTINUE”
       clickonelement(By.xpath(" //button[contains(text(),'Continue')]"));
//2.37 Verify the text “Welcome to our store”
        String expectedMessage11 = "Welcome to our store";
        String actualMessage11 = gettextfromelemrnt(By.xpath(" //h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("please select shipping method", expectedMessage11, actualMessage11);


    }
}