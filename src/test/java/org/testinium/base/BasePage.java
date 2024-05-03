package org.testinium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

        public WebDriver driver;
        public WebDriverWait wait;

        public BasePage(WebDriver driver)
        {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        }

}
