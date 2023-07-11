package edu.praktikum.samokat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.After;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

abstract public class InitAndQuitTestClass {
   public WebDriver driver;

    @Before
    public void setUp() {
        //Для Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //для ForeFox
        //driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearsDown(){
        driver.quit();
    }
}
