package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Page {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public Page(AndroidDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //this.wait = new WebDriverWait(driver, 10);
    }

}


