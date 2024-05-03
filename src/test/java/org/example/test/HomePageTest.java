package org.example.test;

import org.junit.jupiter.api.*;

import static org.junit.Assert.assertTrue;
import org.example.base.BaseTest;
import org.example.pages.HomePage;

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
