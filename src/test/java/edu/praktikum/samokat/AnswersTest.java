/* Выпадающий список в разделе «Вопросы о важном».
Тебе нужно проверить: когда нажимаешь на стрелочку,
открывается соответствующий текст.*/

package edu.praktikium.samokat;

import edu.praktikum.samokat.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AnswersTest {
    private WebDriver driver;

    private static final String ANSWER1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String ANSWER2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String ANSWER3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String ANSWER4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String ANSWER5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String ANSWER6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String ANSWER7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String ANSWER8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";



    @Before
    public void SetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void checkAllAnswers(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl();
        mainPage.takeCookie();

        //проверяем вопрос 1
        Assert.assertEquals(mainPage.getAnswerOne(), ANSWER1);
        Assert.assertEquals(mainPage.getAnswerTwo(), ANSWER2);
        Assert.assertEquals(mainPage.getAnswerThree(), ANSWER3);
        Assert.assertEquals(mainPage.getAnswerFour(), ANSWER4);
        Assert.assertEquals(mainPage.getAnswerFive(), ANSWER5);
        Assert.assertEquals(mainPage.getAnswerSix(), ANSWER6);
        Assert.assertEquals(mainPage.getAnswerSeven(), ANSWER7);
        Assert.assertEquals(mainPage.getAnswerEight(), ANSWER8);

    }

    @After
    public void tearsDown(){
        driver.quit();
    }
}

