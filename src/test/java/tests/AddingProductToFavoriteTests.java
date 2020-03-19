package tests;

import org.junit.Test;
import static org.junit.Assert.*;

public class AddingProductToFavoriteTests extends TestBase {
    @Test
    public void canAddProductToFavorite() {
        app.moveToCatalogPage();
        app.searchProductByTitle("lg");
        app.addFirstProductToFavoriteFromSearch();
        app.moveToFavoritePage();
        assertFalse(app.isFavoriteEmpty());
        app.deleteAllFromFavorite();
    }

}
