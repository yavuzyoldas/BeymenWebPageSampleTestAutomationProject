package org.example.base;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public static  WebDriver webDriver;
    private static ChromeOptions options;

    @BeforeAll
    public static void setUp(){

        options = new ChromeOptions();
        options.addArguments("start-maximized");
        setWebDriver();
        getWebDriver().navigate().to("https://www.beymen.com");
    }

    @AfterAll
    public static void tearDown(){
        webDriver.close();
    }

    private static void setWebDriver(){
        webDriver = new ChromeDriver(options);
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

}
