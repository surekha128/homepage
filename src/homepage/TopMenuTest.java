package homepage;

import browsersetup.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

import java.util.List;
import java.util.Scanner;

/*
1.1 create method with name "selectMenu" it has one parameter name "menu" of  type string
 */
public class TopMenuTest extends BaseTest {

    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

  /*  @After
    public void closebrowser(){
        driver.quit();
    }*/
//    1.2 This method should click on the menu whatever name is passed as parameter.
    public void selectMenu(String menu) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Actions actions = new Actions(driver);

        Thread.sleep(3000);
        switch (menu) {
            case  "Computers ":
                scanner.equals("Computers");
                Thread.sleep(5000);
                //clickonelement(By.xpath());
                mouseHoverToElement(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[1]"));
                String expectedMessage = "Computers";
                String actualMessage = gettextfromelemrnt(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[1]"));
                Assert.assertEquals("please select menu", expectedMessage, actualMessage);
                scanner.close();
                break;

            case "Electronics ":
                scanner.match();
                mouseHoverToElement(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[2]"));
                Thread.sleep(3000);
                String expectedMessage1 = "Electronics";
                String actualMessage1 = gettextfromelemrnt(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[2]"));
                Assert.assertEquals("please select menu", expectedMessage1, actualMessage1);
                scanner.close();
                break;

            case "Apparel ":
            clickonelement(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[3]"));
            Thread.sleep(3000);
            String expectedMessage2 = "Apparel";
            String actualMessage2 = gettextfromelemrnt(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[3]"));
            Assert.assertEquals("please select menu", expectedMessage2, actualMessage2);

            case "Digital downloads":
            clickonelement(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[4]"));
            Thread.sleep(3000);
            String expectedMessage3 = "Digital downloads";
            String actualMessage3 = gettextfromelemrnt(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[4]"));
            Assert.assertEquals("please select menu", expectedMessage3, actualMessage3);
break;
            case "Books":
            clickonelement(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[5]"));
            Thread.sleep(3000);
            String expectedMessage4 = "Books";
            String actualMessage4 = gettextfromelemrnt(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[5]"));
            Assert.assertEquals("please select menu", expectedMessage4, actualMessage4);
break;
            case "Jewelry":
            clickonelement(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[6]"));
            Thread.sleep(3000);
            String expectedMessage5 = "Jewelry";
            String actualMessage5 = gettextfromelemrnt(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[6]"));
            Assert.assertEquals("please select menu", expectedMessage5, actualMessage5);
break;
            case "Gift Cards":
            clickonelement(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[7]"));
            Thread.sleep(3000);
            String expectedMessage6 = "Gift Cards";
            String actualMessage6 = gettextfromelemrnt(By.xpath("//div[@class='header-menu']/child::ul[@class='top-menu notmobile']/child::li[7]"));
            Assert.assertEquals("please select menu", expectedMessage6, actualMessage6);
break;
        }
    }

//1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu
//and click on it and verify the page navigation.
    @Test
    public void verifyPageNavigation() throws InterruptedException {
      //  "Computers\n,Electronics\n,Apparel\n,Digital downloads\n,Books \n,Jewelry \n,Gift Cards \n"

        selectMenu("Computers");


    }

}
