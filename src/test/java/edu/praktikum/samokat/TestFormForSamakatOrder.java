package edu.praktikium.samokat;

import edu.praktikum.samokat.CheckReadyOrder;
import edu.praktikum.samokat.OpenOrderForm;
import edu.praktikum.samokat.PersonInfo;
import edu.praktikum.samokat.SamokatInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class TestFormForSamakatOrder {


    private static final String MSG = "Заказ оформлен";
    private WebDriver driver;
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

    @Before
    public void SetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
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
        personInfo.FillPersonInfo(name, surname,adress, phoneNumber);
        personInfo.clickNextButton();
        //заполняем данные на странице "Про адренду"
        SamokatInfo samokatInfo = new SamokatInfo(driver);
        samokatInfo.fillSamokatInfo();
        samokatInfo.clickButtonOrderInForm();

        //Подтверждаем заказ
        CheckReadyOrder checkReadyOrder = new CheckReadyOrder(driver);
        checkReadyOrder.clickButtonYes();
        //проверяем, что заказ сформирован
        assertEquals(checkReadyOrder.isOrderReadyOpen(), "Заказ оформлен");
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
        personInfo.FillPersonInfo(name, surname,adress, phoneNumber);
        personInfo.clickNextButton();
        //заполняем данные на странице "Про самокат"
        SamokatInfo samokatInfo = new SamokatInfo(driver);
        samokatInfo.fillSamokatInfo();
        samokatInfo.clickButtonOrderInForm();
        //Подтверждаем заказ
        CheckReadyOrder checkReadyOrder = new CheckReadyOrder(driver);
        checkReadyOrder.clickButtonYes();
        //проверяем, что заказ оформлен
        assertEquals(checkReadyOrder.isOrderReadyOpen(), "Заказ оформлен");
    }

    @After
    public void tearsDown(){
        driver.quit();
    }


}


