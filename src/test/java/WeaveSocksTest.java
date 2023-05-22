import api.RandomUser;
import api.Requests;
import api.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.CartPage;
import pageobjects.CataloguePage;
import pageobjects.FrontPage;

import static additional.URLs.BASE_URL;
import static junit.framework.TestCase.assertEquals;

public class WeaveSocksTest {

    WebDriver driver;
    FrontPage frontPage;
    CataloguePage cataloguePage;
    CartPage cartPage;
    User user;
    Requests request;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        frontPage = new FrontPage(driver);
        cataloguePage = new CataloguePage(driver);
        cartPage = new CartPage(driver);
        request = new Requests();
    }

    @Test
    public void test() {
        // создаем юзера через api
        user = RandomUser.createRandomUser();
        Response response = request.registerNewUser(user);
        user.setId(response.then().extract().path("id"));
        // авторизация через ui
        frontPage.clickLoginButton();
        frontPage.fillCustomerLogin(user.getUsername(), user.getPassword());
        frontPage.clickCustomerLoginButton();
        frontPage.waitForPageToLoad();
        // переходим в каталог и добавляем товары
        frontPage.clickCatalogueButton();
        cataloguePage.addHolySocks();
        cataloguePage.addCatSocks();
        cataloguePage.clickBasketButton();
        // переходим в корзину и проверяем total
        cartPage.waitForPageToLoad();
        assertEquals("$114.99", cartPage.getTotalSum());
    }

    @After
    public void tearDown() {
        // удаляем юзера и закрываем браузер
        request.deleteUser(user.getId());
        driver.quit();
    }
}
