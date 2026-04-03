package Page;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlipkartPage {

    WebDriver driver;

    public FlipkartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By closeLoginPopup = By.xpath("//div[contains(@class,'q7ywiQ')]//span");
    By searchBox = By.name("q");
    By searchButton = By.xpath("//button[@type='submit']");

    // Filters (may change dynamically - sample locators)
    By priceFilter = By.xpath("//div[contains(@class,'WoGl7t')]//select/option[@value='50000']");
    By brandFilter = By.xpath("//div[text()='ASUS']");

    By productTitles = By.xpath("//div[@class='RG5Slk']");

    // Actions
    public void closeLoginPopup() {
        try {
            driver.findElement(closeLoginPopup).click();
        } catch (Exception e) {
            // Popup not present
        }
    }

    public void searchProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }

    public void applyPriceFilter() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(priceFilter).click();
    }

    public void applyBrandFilter() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class ,'_6odwB')]")).click();
        driver.findElement(brandFilter).click();
    }

    public void printFirst10Products() throws InterruptedException {

        Thread.sleep(3000); // better: use WebDriverWait

        List<WebElement> products = driver.findElements(productTitles);

        int count = Math.min(products.size(), 10);

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + products.get(i).getText());
        }
    }
}