/* Заказ самоката. Весь флоу позитивного сценария.
Обрати внимание, что есть две точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу.
*/

package edu.praktikum.samokat;
//страница для заполнения данных о человеке
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonInfo {
    WebDriver driver;
    //локатор поля имя
    private final By fieldName = By.xpath(".//input[@placeholder='* Имя']");
    //локатор для фамилии
    private final By fieldSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //локатор для адреса
    private final By fieldAdrress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор для выбора станции метро
    private final By fieldMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By selectMetroTitle = By.xpath(".//li[@data-value='1']");

    //локатор для поля телефон
    private final By fieldPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор для кнопки Далее
    private final By buttonNext = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");


    public PersonInfo(WebDriver driver){
        this.driver = driver;
    }
    //заполнить поле имя
    public void inputName(String name){
        driver.findElement(fieldName).clear();
        driver.findElement(fieldName).sendKeys(name);
    }

    //заполняем поле фамилия
    public void inputSurname(String surname){
        driver.findElement(fieldSurname).clear();
        driver.findElement(fieldSurname).sendKeys(surname);
    }
    //заполняем поле Адрес
    public void inputAdress(String adress){
        driver.findElement(fieldAdrress).clear();
        driver.findElement(fieldAdrress).sendKeys(adress);

    }
    //выбираем станцию метро
    public void selectMetro(){
        driver.findElement(fieldMetro).clear();
        driver.findElement(fieldMetro).click();
        driver.findElement(selectMetroTitle).click();
    }
    //заполняем номер телефона
    public void inputPhone(String phoneNumber){
        driver.findElement(fieldPhone).clear();
        driver.findElement(fieldPhone).sendKeys(phoneNumber);
    }
    //нажимаем кнопку Далее

    public void clickNextButton(){
        //добавить проверку, что кнопка доступн
        driver.findElement(buttonNext).click();
    }
    //собиарем все методы для заполнения полей в один
    public void fillPersonInfo(String name, String surname, String adress, String phoneNumber){
        inputName(name);
        inputSurname(surname);
        inputAdress(adress);
        selectMetro();
        inputPhone(phoneNumber);
    }
}

