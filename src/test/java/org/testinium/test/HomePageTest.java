package org.testinium.test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;
import org.testinium.base.BaseTest;
import org.testinium.pages.HomePage;
import org.testinium.util.Log;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@Order(1)

public class HomePageTest extends BaseTest {

    HomePage homePage;

    public HomePageTest(){

        this.homePage = new HomePage(webDriver);


    }

    @Test
    public void homePageCheck(){
        Assertions.assertTrue(homePage.homePageCheck());
    }

}
