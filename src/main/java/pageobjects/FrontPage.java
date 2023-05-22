package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FrontPage {

    WebDriver driver;

    public FrontPage(WebDriver driver) {
        this.driver = driver;
    }

    // каталог
    private final By catalogueButton = By.xpath(".//div[@id=\"navbar\"]//a[text()='Catalogue ']");
    // авторизация
    private final By loginButton = By.xpath(".//a[text()='Login']");
    private final By usernameInput = By.id("username-modal");
    private final By passwordInput = By.id("password-modal");
    private final By customerLoginButton = By.xpath(".//button[contains(text(),'Log in')]");

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void fillUsername(String username) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void fillPassword(String password) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void fillCustomerLogin(String username, String password) {
        fillUsername(username);
        fillPassword(password);
    }

    public void clickCustomerLoginButton() {
        driver.findElement(customerLoginButton).click();
    }

    public void clickCatalogueButton() {
        driver.findElement(catalogueButton).click();
    }
    public void waitForPageToLoad() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("login-modal")));
    }

}
