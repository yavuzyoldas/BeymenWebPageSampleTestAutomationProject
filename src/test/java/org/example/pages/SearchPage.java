package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.base.BasePage;
import org.example.uielements.DetailPageUIElements;
import org.example.uielements.SearchPageUIElements;
import org.example.util.ElementHelper;

import org.example.util.Log;
import org.example.util.UtilFunctions;

import java.util.Random;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    SearchPageUIElements searchPageUIElements;
    DetailPageUIElements detailPageUIElements;
    ElementHelper elementHelper;
    public ArrayList<String> list = new ArrayList<>();
    private String data;


    public SearchPage(WebDriver driver) {
        super(driver);

        this.searchPageUIElements = new SearchPageUIElements();
        this.detailPageUIElements = new DetailPageUIElements();
        this.elementHelper = new ElementHelper(driver,new WebDriverWait(driver, Duration.ofSeconds(60)));
    }

    public void readDataFromExcelForFirst(){

        data =  UtilFunctions.readDataFromExcel(0,0);
        System.out.println("data : " + data);
        Log.info("step -> deleteProductsFromBasketAndCheck");

    }

    public void typeDataToSearchBarFirst(){
        elementHelper.sendKeys(searchPageUIElements.searchPageSearchBar,data);
        Log.info("step -> typeDataToSearchBarFirst");
    }

    public void cleanToSearchBar(){


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        elementHelper.waitElements(30);
        elementHelper.click(searchPageUIElements.searchPageSearchBarCleanButton);
        Log.info("step -> cleanToSearchBar");
    }

    public void readDataFromExcelForSecond(){
        data =  UtilFunctions.readDataFromExcel(0,1);
        System.out.println("data : " + data);
        Log.info("step -> readDataFromExcelForSecond");
    }
    public void typeDataToSearchBarSecond(){

        elementHelper.sendKeys(searchPageUIElements.searchPageSearchBarSecond,data);
        Log.info("step -> typeDataToSearchBarSecond");
    }

    public void sendKeyDataWithEnter(){

        elementHelper.sendKeys(searchPageUIElements.searchPageSearchBarSecond, Keys.ENTER);
        Log.info("step -> sendKeyDataWithEnter");
    }

    public boolean chooseRandomShirt(){

        List<WebElement> elements = driver.findElements(searchPageUIElements.searchPageChooseProduct);
        Random random = new Random();
        int randomNumber = random.nextInt(elements.size());
        System.out.println("randomNumber : " + randomNumber);
        WebElement element = elements.get(randomNumber);
        elementHelper.click(element);
        elementHelper.waitVisibilityOfElementLocated(detailPageUIElements.detailPageVariation);
        boolean check = elementHelper.isDisplayedElement(elementHelper.findElement(detailPageUIElements.detailPageVariation));
        Log.info("step -> chooseRandomShirt");
        return check;


    }







}
