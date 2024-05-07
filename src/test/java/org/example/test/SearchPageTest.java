package org.example.test;

import org.junit.jupiter.api.*;
import org.example.base.BaseTest;
import org.example.pages.HomePage;
import org.example.pages.SearchPage;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@Order(2)


public class SearchPageTest extends BaseTest {


    SearchPage searchPage;
    HomePage homePage;

    public SearchPageTest(){
        this.searchPage = new SearchPage(webDriver);
        this.homePage = new HomePage(webDriver);
    }

    @BeforeEach
    public void precondition(){

        homePage.homePageCheck();
    }

    @Test
    @Order(1)
    public void chooseProduct()  {

        searchPage.readDataFromExcelForFirst();
        searchPage.typeDataToSearchBarFirst();
        searchPage.cleanToSearchBar();
        searchPage.readDataFromExcelForSecond();
        searchPage.typeDataToSearchBarSecond();
        searchPage.sendKeyDataWithEnter();
        Assertions.assertTrue(searchPage.chooseRandomShirt());

    }


}
