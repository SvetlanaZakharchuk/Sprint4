/* Выпадающий список в разделе «Вопросы о важном».
Тебе нужно проверить: когда нажимаешь на стрелочку,
открывается соответствующий текст.*/

package edu.praktikum.samokat;

import org.junit.Assert;
import org.junit.Test;


public class AnswersTest extends InitAndQuitTestClass{
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    
    private static final String ANSWER1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String ANSWER2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String ANSWER3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String ANSWER4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String ANSWER5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String ANSWER6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String ANSWER7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String ANSWER8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";



/*    @Before
    public void SetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
*/

  @Test
    public void checkFirstAnswer() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl(URL);
        mainPage.takeCookie();
        //проверяем вопрос 1
        Assert.assertEquals(ANSWER1, mainPage.getAnswerOne());
    }

    @Test
    public void checkSecondAnswer() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl(URL);
        mainPage.takeCookie();
        Assert.assertEquals(ANSWER2, mainPage.getAnswerTwo());
    }
    @Test
    public void checkTherdAnswer() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl(URL);
        mainPage.takeCookie();
        Assert.assertEquals(ANSWER3, mainPage.getAnswerThree());
    }

    @Test
    public void checkFourAnswer() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl(URL);
        mainPage.takeCookie();
        Assert.assertEquals(ANSWER4, mainPage.getAnswerFour());
    }

    @Test
    public void checkFiveAnswer() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl(URL);
        mainPage.takeCookie();
        Assert.assertEquals(ANSWER5, mainPage.getAnswerFive());
    }

    @Test
    public void checkSixAnswer() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl(URL);
        mainPage.takeCookie();

        Assert.assertEquals(ANSWER6, mainPage.getAnswerSix());
    }

    @Test
    public void checkSevenAnswer() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl(URL);
        mainPage.takeCookie();

        Assert.assertEquals(ANSWER7, mainPage.getAnswerSeven());
    }

    @Test
    public void checkEightAnswer() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl(URL);
        mainPage.takeCookie();

        Assert.assertEquals(ANSWER8, mainPage.getAnswerEight());
    }

 

/*    @After
    public void tearsDown(){
        driver.quit();
    }*/
}

