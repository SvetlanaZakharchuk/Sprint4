package edu.praktikum.samokat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;



@RunWith(Parameterized.class)
public class TestFormForSamakatOrder extends InitAndQuitTestClass{


    private static final String LOOK_UP_STATUS = "Посмотреть статус";
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    
    private final String name;
    private final String surname;
    private final String adress;
    private final String phoneNumber;

    public TestFormForSamakatOrder(String name, String surname, String adress, String phonenumber){
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phoneNumber = phonenumber;
    }

    @Parameterized.Parameters
    public static Object[] getOrderInfo() {
        return new Object[][] {
                { "Иван", "Иванов", "ул. Серова, д. 6", "12345678912" },
                { "Петр", "Петров", "ул. Доваторцев, 15", "43234543234"}
        };
    }

/*    @Before
    public void SetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }*/
    //проверяем заполнение формы заказа (кнопка Закзаать находится вверху страницы)
    @Test
    public void fillFormWithOrderPageInTheHeader(){
        OpenOrderForm openOrderForm = new OpenOrderForm(driver);
        //открываем страницу
        //принимаем куки
        //нажимаем кнопку Заказать
        openOrderForm.open();
        openOrderForm.takeCookie();
        openOrderForm.clickOrderButtonInTheHeader();
        //заполняем данные на странице "Для кого самокат"
        PersonInfo personInfo = new PersonInfo(driver);
        personInfo.fillPersonInfo(name, surname,adress, phoneNumber);
        personInfo.clickNextButton();
        //заполняем данные на странице "Про адренду"
        SamokatInfo samokatInfo = new SamokatInfo(driver);
        samokatInfo.fillSamokatInfo();
        samokatInfo.clickButtonOrderInForm();

        //Подтверждаем заказ
        CheckReadyOrder checkReadyOrder = new CheckReadyOrder(driver);
        checkReadyOrder.clickButtonYes();
        //проверяем, что заказ сформирован
        assertEquals(LOOK_UP_STATUS, checkReadyOrder.isOrderReadyOpen());
    }


    //проверяем форму (кнопка Заказать находится внизу страницы)
    @Test
    public void fillFormWithOrderPageInThePage(){
        OpenOrderForm openOrderForm = new OpenOrderForm(driver);
        //открываем странице
        //принимаем куки
        //нажимаем кнопку Заказать
        openOrderForm.open();
        openOrderForm.takeCookie();
        openOrderForm.clickOrderButtonInThePage();
        //заполняем данные на странице "Для кого самокат"
        PersonInfo personInfo = new PersonInfo(driver);
        personInfo.fillPersonInfo(name, surname,adress, phoneNumber);
        personInfo.clickNextButton();
        //заполняем данные на странице "Про самокат"
        SamokatInfo samokatInfo = new SamokatInfo(driver);
        samokatInfo.fillSamokatInfo();
        samokatInfo.clickButtonOrderInForm();
        //Подтверждаем заказ
        CheckReadyOrder checkReadyOrder = new CheckReadyOrder(driver);
        checkReadyOrder.clickButtonYes();
        //проверяем, что заказ оформлен
        assertEquals(LOOK_UP_STATUS, checkReadyOrder.isOrderReadyOpen());
    }

/*    @After
    public void tearsDown(){
        driver.quit();
    }*/


}


