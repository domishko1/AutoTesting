package pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class CatalogPage extends Page {

    @AndroidFindBy(id = "catalog_search_container")
    private WebElement catalogSearchContainer;

    public CatalogPage(AndroidDriver driver) {
        super(driver);
    }

    public void openSearchContainer() {
        catalogSearchContainer.click();
    }
}
