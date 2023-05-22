package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CataloguePage {
    WebDriver driver;

    public CataloguePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By addHolySocksItem = By.xpath(".//a[@onclick=\"addToCart('03fef6ac-1896-4ce8-bd69-b798f85c6e0b')\"]");
    private final By addCatSocksItem = By.xpath(".//a[@onclick=\"addToCart('837ab141-399e-4c1f-9abc-bace40296bac')\"]");
    private final By basketButton = By.id("basket-overview");

    public void addHolySocks() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(addHolySocksItem));
        driver.findElement(addHolySocksItem).click();
    }

    public void addCatSocks() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(addCatSocksItem));
        driver.findElement(addCatSocksItem).click();
    }

    public void clickBasketButton() {
        driver.findElement(basketButton).click();
    }

}
