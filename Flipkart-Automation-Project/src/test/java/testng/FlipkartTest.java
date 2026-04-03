package testng;


import Page.FlipkartPage;
import base.BaseTest;
import org.testng.annotations.Test;


public class FlipkartTest extends BaseTest {

    @Test
    public void searchAndApplyFilters() throws InterruptedException {

        FlipkartPage page = new FlipkartPage(driver);

        // Step 1: Close login popup
        page.closeLoginPopup();

        // Step 2: Search for laptop
        page.searchProduct("laptop");

        // Step 3: Apply price filter
        page.applyPriceFilter();

        // Step 4: Apply brand filter (Libas - just for demo)
        page.applyBrandFilter();

        page.printFirst10Products();
    }
}