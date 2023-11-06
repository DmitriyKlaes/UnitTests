package seminars.five;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class SeleniumTest {
    /*
    Напишите автоматизированный тест, который выполнит следующие шаги:
1. Открывает главную страницу Google.
2. Вводит "Selenium" в поисковую строку и нажимает кнопку "Поиск в Google".
3. В результатах поиска ищет ссылку на официальный сайт Selenium
(https://www.selenium.dev) и проверяет, что ссылка действительно присутствует среди
результатов поиска.
     */

    @Test
    void seleniumTest() throws InterruptedException {
//        WebDriver webDriver = new ChromeDriver();
//        WebDriver webDriver = new FirefoxDriver();
        WebDriver webDriver = new EdgeDriver();
        webDriver.get("https://www.google.com");
        WebElement webElement = webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();
        WebElement seleniumElement = webDriver.findElement(By.tagName("cite"));

        assertEquals(seleniumElement.getText(), "https://www.selenium.dev");

        Thread.sleep(1000);
        webDriver.quit();
    }

    // Альрентативное решение:
//    @Test
//    void seleniumTest() throws InterruptedException {
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.get("https://www.google.com");
//        WebElement webElement = webDriver.findElement(By.name("q"));
//        webElement.sendKeys("Selenium");
//        webElement.submit();
//        List<WebElement> seleniumElement = webDriver.findElements(By.cssSelector("div"));
//        boolean f = false;
//        for (WebElement element : seleniumElement) {
//            if (element.getText().contains("https://www.selenium.dev")) {
//                f = true;
//                break;
//            }
//        }
//        assertThat(f).isTrue();
//
//        Thread.sleep(1000);
//        webDriver.quit();
//    }


    /*
    Нужно написать сквозной тест с использованием Selenium, который авторизует пользователя на
сайте https://www.saucedemo.com/.
Данные для входа - логин: "standard_user", пароль: "secret_sauce".
Проверить, что авторизация прошла успешно и отображаются товары.
Вам необходимо использовать WebDriver для открытия страницы и методы sendKeys() для ввода
данных в поля формы, и submit() для отправки формы. После этого, проверьте, что на странице
отображаются продукты (productsLabel.getText() = "Products").
     */

    @Test
    void autorizationTest() {
        WebDriver webDriver = new EdgeDriver();
        webDriver.get("https://www.saucedemo.com");

        WebElement nameElement = webDriver.findElement(By.id("user-name"));
        nameElement.sendKeys("standard_user");
        WebElement passElement = webDriver.findElement(By.id("password"));
        passElement.sendKeys("secret_sauce");
        passElement.submit();

        WebElement citeElement = webDriver.findElement(By.className("title"));
        
        assertEquals(citeElement.getText(), "Products");

        webDriver.quit();
    }
}
