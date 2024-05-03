package org.testinium.pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testinium.base.BasePage;
import org.testinium.uielements.MyBasketPageUIElements;
import org.testinium.util.ElementHelper;
import org.testinium.util.Log;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.testinium.pages.DetailPage.price;

public class MyBasketPage  extends BasePage {


    MyBasketPageUIElements myBasketPageUIElements;
    ElementHelper elementHelper;

    public MyBasketPage(WebDriver driver) {
        super(driver);
        this.myBasketPageUIElements = new MyBasketPageUIElements();
        this.elementHelper = new ElementHelper(driver,new WebDriverWait(driver, Duration.ofSeconds(60)));

    }

    public void openTheBasket(){
        elementHelper.waitElements(50);
        elementHelper.waitVisibilityOfElementLocated(myBasketPageUIElements.myBasketPageElement);
        elementHelper.click(myBasketPageUIElements.myBasketPageElement);
        Log.info("step -> openTheBasket");
    }

    public void comparisonOfProductPriceAndBasketPrice(){
        elementHelper.waitElements(50);
        elementHelper.waitVisibilityOfElementLocated(myBasketPageUIElements.myBasketPagePrice);
        String basketPrice = elementHelper.getText(myBasketPageUIElements.myBasketPagePrice);
        String editedBasketPrice = basketPrice.replace(",00","");
        assertEquals(price, editedBasketPrice);
        Log.info("step -> comparisonOfProductPriceAndBasketPrice");

    }

    public void increaseNumberProducts(){
        elementHelper.waitVisibilityOfElementLocated(myBasketPageUIElements.myBasketNumber);
        WebElement selectBox = elementHelper.findElement(myBasketPageUIElements.myBasketNumber);
        selectBox.click();
        elementHelper.waitElements(30);
        Select select = new Select(selectBox);
        select.selectByValue("2");
        elementHelper.waitElements(30);
        Log.info("step -> increaseNumberProducts");

    }

    public void productNumberCheck(){
        WebElement selectBox = elementHelper.findElement(myBasketPageUIElements.myBasketNumber);
        Select select = new Select(selectBox);
        assertEquals("2 adet", select.getFirstSelectedOption().getText());
        elementHelper.waitElements(30);
        Log.info("step -> productNumberCheck");
    }

    public boolean deleteProductsFromBasketAndCheck(){

        Log.info("step -> deleteProductsFromBasketAndCheck");
        elementHelper.click(myBasketPageUIElements.myBasketClean);
        elementHelper.waitVisibilityOfElementLocated(myBasketPageUIElements.myBasketEmptyInfo);
        return elementHelper.isDisplayedElement(myBasketPageUIElements.myBasketEmptyInfo);

    }






}
