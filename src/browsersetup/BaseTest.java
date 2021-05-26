package browsersetup;

import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Utility {
    public void openBrowser(String baseurl){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe ");
        //open chrome web create object
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseurl);
    }

    public void closeBrowser(){
        if(driver!=null){
            driver.quit();
        }

    }

}
