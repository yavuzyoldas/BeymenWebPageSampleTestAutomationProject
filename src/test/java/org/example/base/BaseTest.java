package org.example.base;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class BaseTest {

    public static  WebDriver webDriver;
    private static ChromeOptions options;

    @BeforeAll
    public static void setUp(){

        options = new ChromeOptions();
        options.addArguments("start-maximized");
        setWebDriver();
        getWebDriver().navigate().to("https://www.beymen.com");

        setMousePosition();

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

    public static void setMousePosition(){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        robot.mouseMove(-screenSize.width, -screenSize.height);
    }

}
