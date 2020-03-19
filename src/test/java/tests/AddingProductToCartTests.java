package tests;

import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddingProductToCartTests extends TestBase {

    @Test
    public void canAddProductToCart()
    {
        Pair<String, String> codeAndTitleOfProduct = new Pair<>("10010788", "Видеокамера экшн Sony HDR-AS300R/W");
        app.moveToCatalogPage();
        app.searchProductByTitle(codeAndTitleOfProduct.getKey());

        assertTrue(app.checkChoosenProductByTitle(codeAndTitleOfProduct.getValue()));
        app.addProductToCart();

        assertFalse(app.isCartEmpty());
        app.deleteAllFromCart();
    }
}
