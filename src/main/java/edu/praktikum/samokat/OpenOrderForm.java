/* Заказ самоката. Весь флоу позитивного сценария.
Обрати внимание, что есть две точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу.
*/

package edu.praktikum.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//открываем форму заказа
public class OpenOrderForm {
    WebDriver driver;

    //локатор для кнопки Принять куки
    private final By cookieButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");
    //локатор кнопки "Заказать" в заголовке страницы
    private final By orderButtonInTheHeader = By.xpath(".//div[@class='Header_Header__214zg']/div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    //локатор кнопки "Заказать" внизу страницы
    private final By orderButtonInThePage = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    public OpenOrderForm(WebDriver driver){
        this.driver = driver;
    }

    //методы
    //открываем страницу
    public void open(){
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }
    //принимаем куки
    public void takeCookie(){
        driver.findElement(cookieButton).click();
    }
    //нажать кнопку Заказать в заголовке страницы
    public void clickOrderButtonInTheHeader(){
        driver.findElement(orderButtonInTheHeader).click();
    }
    //нажать кнопку Заказать внизу страницы
    public void clickOrderButtonInThePage(){
        driver.findElement(orderButtonInThePage).click();
    }
}

