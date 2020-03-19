package app;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Application {
    protected AndroidDriver driver;
    protected MainPage mainPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CatalogPage catalogPage;
    private SearchPage searchPage;
    private FavoritePage favoritePage;

    public Application() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "HA0PSUNR");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //platformName
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0"); //platformVersion
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");

        cap.setCapability("appPackage", "ru.filit.mvideo.b2c");
        cap.setCapability("appActivity", "ru.filit.mvideo.b2c.ui.main.view.MainActivity");

        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        catalogPage = new CatalogPage(driver);
        searchPage = new SearchPage(driver);
        favoritePage = new FavoritePage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void moveToCatalogPage() {
        mainPage.firstCityChoose();
        mainPage.moveToCatalog();
    }

    public void moveToFavoritePage() {
        mainPage.firstCityChoose();
        mainPage.moveToFavorite();
    }

    public void searchProductByTitle(String title) {
        catalogPage.openSearchContainer();
        searchPage.searchProductByTitle(title);
    }

    public boolean checkChoosenProductByTitle(String title)
    {
        return productPage.checkProductByTitle(title);
    }

    public void addProductToCart()
    {
        searchPage.openFirstProduct();
        productPage.addProductToCart();
    }

    public boolean isCartEmpty()
    {
        return cartPage.isCartEmpty();
    }

    public void deleteAllFromCart()
    {
        cartPage.deleteAllFromCart();
    }

    public void addFirstProductToFavoriteFromSearch() { searchPage.addToFavoriteFirstProduct(); }

    public void deleteAllFromFavorite()
    {
        favoritePage.deleteAllProductFromFavorite();
    }

    public boolean isFavoriteEmpty() { return favoritePage.isFavoriteEmpty(); }
}
