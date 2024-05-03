package org.testinium.test;

import org.junit.jupiter.api.*;
import org.testinium.base.BaseTest;
import org.testinium.pages.DetailPage;
import org.testinium.pages.HomePage;
import org.testinium.pages.MyBasketPage;
import org.testinium.pages.SearchPage;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@Order(4)

public class MyBasketPageTest extends BaseTest {

    SearchPage searchPage;
    HomePage homePage;
    DetailPage detailPage;
    MyBasketPage myBasketPage;

    public MyBasketPageTest(){

        this.searchPage = new SearchPage(webDriver);
        this.homePage = new HomePage(webDriver);
        this.detailPage = new DetailPage(webDriver);
        this.myBasketPage = new MyBasketPage(webDriver);

    }

    @Test
    @Order(1)
    public void checkTheBasket() throws InterruptedException {
        homePage.homePageCheck();

        searchPage.readDataFromExcelForFirst();
        searchPage.typeDataToSearchBarFirst();
        searchPage.cleanToSearchBar();
        searchPage.readDataFromExcelForSecond();
        searchPage.typeDataToSearchBarSecond();
        searchPage.sendKeyDataWithEnter();
        searchPage.chooseRandomShirt();

        detailPage.getAndWriteDetailsToTxt();
        detailPage.addProductToBasket();

        myBasketPage.openTheBasket();
        myBasketPage.comparisonOfProductPriceAndBasketPrice();
        myBasketPage.increaseNumberProducts();
        myBasketPage.productNumberCheck();
        Assertions.assertTrue(myBasketPage.deleteProductsFromBasketAndCheck());


    }



}
