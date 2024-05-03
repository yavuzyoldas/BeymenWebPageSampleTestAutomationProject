package org.testinium.test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.testinium.base.BaseTest;
import org.testinium.pages.DetailPage;
import org.testinium.pages.HomePage;
import org.testinium.pages.SearchPage;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@Order(3)

public class DetailPageTest extends BaseTest {

    SearchPage searchPage;
    HomePage homePage;
    DetailPage detailPage;

    public DetailPageTest(){

        this.searchPage = new SearchPage(webDriver);
        this.homePage = new HomePage(webDriver);
        this.detailPage = new DetailPage(webDriver);

    }

    @Test
    @Order(1)
    public void addProductToBasket(){
        homePage.homePageCheck();

        searchPage.readDataFromExcelForFirst();
        searchPage.typeDataToSearchBarFirst();
        searchPage.cleanToSearchBar();
        searchPage.readDataFromExcelForSecond();
        searchPage.typeDataToSearchBarSecond();
        searchPage.sendKeyDataWithEnter();
        searchPage.chooseRandomShirt();

        detailPage.getAndWriteDetailsToTxt();
        Assertions.assertTrue(detailPage.addProductToBasket());



    }



}
