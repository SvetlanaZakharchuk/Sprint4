/* Заказ самоката. Весь флоу позитивного сценария.
Обрати внимание, что есть две точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу.
*/

package edu.praktikum.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//страница с информацией об аренде
public class SamokatInfo {
    WebDriver driver;

    //локатор для поля Когда привезти самокат (календарь)
    private final By checkDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By chooseDay = By.xpath(".//div[@aria-label='Choose пятница, 28-е июля 2023 г.']");
    //локатор для списка Срок аренды
    private final By rentPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");

    private final By rentValue = By.xpath(".//div[(@class='Dropdown-option') and (text()='сутки')]");

    //локатор для кнопки Заказать
    private final By OrderButtonInForm = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[contains(text(), 'Заказать')]");
    //Локатор для кнопки Да
    private final By buttonYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[contains(text(), 'Да')]");

    //Локатор для надписи "Заказ оформлен"
    private final By orderIsReady = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_ModalHeader__3FDaJ']");

    public SamokatInfo(WebDriver driver){
        this.driver = driver;
    }

    //заполняем дату доставки самоката
    public void selectDate(){
        driver.findElement(checkDate).click();
        driver.findElement(chooseDay).click();
    }
    //заполняем срок
    public void setRentPeriod(){
        driver.findElement(rentPeriod).click();
        driver.findElement(rentValue).click();
    }

    public void clickButtonOrderInForm(){
        driver.findElement(OrderButtonInForm).click();
    }
    //собираем все методы заполнения полей в один
    public void fillSamokatInfo(){
        selectDate();
        setRentPeriod();
    }
}

