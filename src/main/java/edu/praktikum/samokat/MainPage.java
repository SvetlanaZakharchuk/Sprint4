/* Выпадающий список в разделе «Вопросы о важном».
Тебе нужно проверить: когда нажимаешь на стрелочку,
открывается соответствующий текст.*/

package edu.praktikum.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;

    //локатор для кнопки, чтобы принять куки
    private final By cookieButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    //локатор  для первого вопроса
    private final By question_1 = By.xpath(".//div[@id='accordion__heading-0']");
    //локатор для первого ответа
    private final By answer_1 = By.xpath(".//div[@id='accordion__panel-0']/p");
    //локатор для второго вопроса
    private final By question_2 = By.xpath(".//div[@id='accordion__heading-1']");
    //локатор для второго ответа
    private final By answer_2 = By.xpath(".//div[@id='accordion__panel-1']/p");
    //локатор для третьего вопроса
    private final By question_3 = By.xpath(".//div[@id='accordion__heading-2']");
    //локатор для третьего ответа
    private final By answer_3 = By.xpath(".//div[@id='accordion__panel-2']/p");
    //локатор для четвертого вопроса
    private final By question_4 = By.xpath(".//div[@id='accordion__heading-3']");
    //локатор для четвертого ответа
    private final By answer_4 = By.xpath(".//div[@id='accordion__panel-3']/p");
    //локатор для пятого вопроса
    private final By question_5 = By.xpath(".//div[@id='accordion__heading-4']");
    //локатор для пятого ответа
    private final By answer_5 = By.xpath(".//div[@id='accordion__panel-4']/p");
    //локатор для шестого вопроса
    private final By question_6 = By.xpath(".//div[@id='accordion__heading-5']");
    //локаторя для шестого ответа
    private final By answer_6 = By.xpath(".//div[@id='accordion__panel-5']/p");
    //локатор для седьмого вопроса
    private final By question_7 = By.xpath(".//div[@id='accordion__heading-6']");
    //локатор для седьмого ответа
    private final By answer_7 = By.xpath(".//div[@id='accordion__panel-6']/p");
    //локатор для восьмого вопроса
    private final By question_8 = By.xpath(".//div[@id='accordion__heading-7']");
    //локатор для восьмого ответа
    private final By answer_8 = By.xpath(".//div[@id='accordion__panel-7']/p");


    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    //открываем браузер
   public void openUrl(String current_url){
        driver.get(current_url);
       
    //принять куки
    public void takeCookie(){
        driver.findElement(cookieButton).click();
    }

    //получаем первый ответ
    public String getAnswerOne(){
        driver.findElement(question_1).click();
        return (driver.findElement(answer_1).getText());
    }

    //получаем второй ответ
    public String getAnswerTwo(){
        driver.findElement(question_2).click();
        return (driver.findElement(answer_2).getText());
    }

    //получаем третий ответ
    public String getAnswerThree(){
        driver.findElement(question_3).click();
        return (driver.findElement(answer_3).getText());
    }

    //получаем четвертый ответ
    public String getAnswerFour(){
        driver.findElement(question_4).click();
        return (driver.findElement(answer_4).getText());
    }

    //получаем пятый ответ
    public String getAnswerFive(){
        driver.findElement(question_5).click();
        return (driver.findElement(answer_5).getText());
    }

    //получаем шестой ответ
    public String getAnswerSix(){
        driver.findElement(question_6).click();
        return (driver.findElement(answer_6).getText());
    }

    //получаем седьмой ответ
    public String getAnswerSeven(){
        driver.findElement(question_7).click();
        return (driver.findElement(answer_7).getText());
    }

    //получаем восьмой ответ
    public String getAnswerEight(){
        driver.findElement(question_8).click();
        return (driver.findElement(answer_8).getText());
    }


}

