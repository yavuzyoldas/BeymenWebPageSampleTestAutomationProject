package org.testinium.test;

import org.junit.jupiter.api.*;
import org.testinium.base.BaseTest;
import org.testinium.pages.HomePage;
import org.testinium.pages.SearchPage;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@Order(2)


public class SearchPageTest extends BaseTest {


    SearchPage searchPage;
    HomePage homePage;

    public SearchPageTest(){
        this.searchPage = new SearchPage(webDriver);
        this.homePage = new HomePage(webDriver);
    }

    @Test
    @Order(1)
    public void chooseProduct()  {
        homePage.homePageCheck();

        searchPage.readDataFromExcelForFirst();
        searchPage.typeDataToSearchBarFirst();
        searchPage.cleanToSearchBar();
        searchPage.readDataFromExcelForSecond();
        searchPage.typeDataToSearchBarSecond();
        searchPage.sendKeyDataWithEnter();
        Assertions.assertTrue(searchPage.chooseRandomShirt());

    }


}
