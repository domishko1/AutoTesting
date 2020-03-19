package pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class SearchPage extends Page{

    @AndroidFindBy(id = "search_src_text")
    private WebElement searchField;

    @AndroidFindBy(id = "listing_add_to_favorite")
    private List<WebElement> addToFavorite_heartBtn;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Изображение продукта\"]")
    private List<WebElement> imgListOfProduct;

    public SearchPage(AndroidDriver driver) throws MalformedURLException, InterruptedException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchProductByTitle(String title) {
        searchField.sendKeys(title);
        driver.pressKeyCode(66);
    }

    public void openFirstProduct()
    {
        imgListOfProduct.get(0).click();
    }

    public void addToFavoriteFirstProduct() { addToFavorite_heartBtn.get(0).click(); }

    private void swipeToUp() throws InterruptedException {
        TouchAction action = new TouchAction((MobileDriver) this.driver);

        Dimension size = this.driver.manage().window().getSize();
        int     endy = (int) (size.height * 0.7),
                starty = (int) (size.height * 0.3),
                startx = size.width / 2;
        sleep(1000);
        action.press(PointOption.point(startx,starty)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(startx, endy)).release().perform();
    }
}
