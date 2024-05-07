package org.example.test;


import org.junit.jupiter.api.*;
import org.example.base.BaseTest;
import org.example.pages.DetailPage;
import org.example.pages.HomePage;
import org.example.pages.SearchPage;

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

    @BeforeEach
    public void precondition(){

        homePage.homePageCheck();

        searchPage.readDataFromExcelForFirst();
        searchPage.typeDataToSearchBarFirst();
        searchPage.cleanToSearchBar();
        searchPage.readDataFromExcelForSecond();
        searchPage.typeDataToSearchBarSecond();
        searchPage.sendKeyDataWithEnter();
        searchPage.chooseRandomShirt();

    }

    @Test
    @Order(1)
    public void addProductToBasket(){


        detailPage.getAndWriteDetailsToTxt();
        Assertions.assertTrue(detailPage.addProductToBasket());



    }



}
