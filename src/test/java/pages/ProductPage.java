package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class ProductPage extends Page {
    @AndroidFindBy(id = "product_material_number")
    private WebElement productCode;

    @AndroidFindBy(id = "product_material_description")
    private WebElement productDescription;

    @AndroidFindBy(id = "product_add_to_cart")
    private WebElement addToCartBtn;

    public ProductPage(AndroidDriver driver) throws MalformedURLException, InterruptedException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean checkProductByTitle(String title)
    {
        return title.equals(productDescription.getText());
    }

    public void addProductToCart()
    {
        addToCartBtn.click();
    }

}
