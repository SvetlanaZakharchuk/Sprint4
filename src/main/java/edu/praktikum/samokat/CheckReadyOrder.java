/* Заказ самоката. Весь флоу позитивного сценария.
Обрати внимание, что есть две точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу.
*/

package edu.praktikum.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckReadyOrder {
    WebDriver driver;


    //Локатор для кнопки "Да"
    private final By buttonYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[contains(text(), 'Да')]");

    //Локатор для надписи "Заказ оформлен"
    private final By orderIsReady = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_ModalHeader__3FDaJ']");

    public CheckReadyOrder(WebDriver driver){
        this.driver = driver;
    }

    //нажимаем кнопку "Да"
    public void clickButtonYes(){
        driver.findElement(buttonYes).isEnabled();
        driver.findElement(buttonYes).click();
    }

    //Получаем текст с подтверждением заказа
    public String isOrderReadyOpen(){
        String result = driver.findElement(orderIsReady).getText();
        return result;
    }
}


