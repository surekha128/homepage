package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility {
    public WebDriver driver;

    //this method will click on element
    public void clickonelement(By by) {
        driver.findElement(by).click();

    }

 //* This method will used to hover mouse on element

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    //this method will get text from element
    public String gettextfromelemrnt(By by) {
        return driver.findElement(by).getText();


    }

    //this method will send text on element
    public void sendtexttoelement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }


    //this method will select by value from dropdown
    public void selectbyvaluefromdropdown(By by, String value) {

        Select select = new Select(driver.findElement(by));
        //select by value
        select.selectByValue(value);
        //select by text

    }
}
