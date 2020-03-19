package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FavoritePage extends Page {
    public FavoritePage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "favorites_total")
    private WebElement totalItemsInFavorite;

    @AndroidFindBy(id = "favorites_items")
    private List<WebElement> favoriteProducts;


    public boolean isFavoriteEmpty()
    {
        String text = "1 товар";
        return text.equals(totalItemsInFavorite.getText());
    }
    public void deleteAllProductFromFavorite()
    {
        if(! isFavoriteEmpty())
            for (WebElement item : favoriteProducts) {
                item.click();
            }
    }
}
