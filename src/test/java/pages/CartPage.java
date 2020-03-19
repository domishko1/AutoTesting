package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.List;

public class CartPage extends Page {

    @AndroidFindBy(id = "cart_total_items")
    private WebElement totalItemsInCart;

    @AndroidFindBy(id = "cart_item_remove")
    private List<WebElement> itemsToRemove;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement confirmDeletiobBtn;


    public CartPage(AndroidDriver driver) throws MalformedURLException, InterruptedException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCartEmpty()
    {
        String text = "1 товар";
        return text.equals(totalItemsInCart.getText());
    }

    public void deleteAllFromCart()
    {
        int itemsToRemoveSize = itemsToRemove.size();
        for (WebElement item : itemsToRemove) {
            item.click();
            confirmDeletiobBtn.click();
        }
    }
}
