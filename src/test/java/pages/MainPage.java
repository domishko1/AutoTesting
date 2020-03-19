package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.util.List;

public class MainPage extends Page {

    public MainPage(AndroidDriver driver) throws MalformedURLException, InterruptedException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @AndroidFindBy(id = "android:id/button2")
    private WebElement chooseCityOKBtn;

    @AndroidFindBy(id = "cities_radiobutton")
    private WebElement firstCityInListRadioBtn;

    @AndroidFindBy(id = "navigation_main")
    private WebElement navigationMainBtn;

    @AndroidFindBy(id = "navigation_catalog")
    private WebElement navigationCatalogBtn;

    @AndroidFindBy(id = "navigation_favorites")
    private WebElement navigationFavoritesBtn;

    @AndroidFindBy(id = "navigation_profile")
    private WebElement navigationProfileBtn;

    @AndroidFindBy(id = "navigation_cart")
    private WebElement navigationCartBtn;

    public void firstCityChoose() {
        try {

            chooseCityOKBtn.click();
            firstCityInListRadioBtn.click();
        } catch(Exception ex)
        {
            System.out.println("No city selected!");
        }
    }

    public void moveToCatalog() { navigationCatalogBtn.click(); }

    public void moveToCart() {
        navigationCartBtn.click();
    }

    public void moveToFavorite() {
        navigationFavoritesBtn.click();
    }

}
