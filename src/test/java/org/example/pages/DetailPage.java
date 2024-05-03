package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.base.BasePage;
import org.example.uielements.DetailPageUIElements;
import org.example.uielements.MyBasketPageUIElements;
import org.example.util.ElementHelper;
import org.example.util.Log;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.example.util.UtilFunctions.saveToTxtFile;

public class DetailPage extends BasePage {

    DetailPageUIElements detailPageUIElements;
    MyBasketPageUIElements myBasketPageUIElements;
    ElementHelper elementHelper;
    public static String price;

    public DetailPage(WebDriver driver) {

        super(driver);
        this.detailPageUIElements = new DetailPageUIElements();
        this.myBasketPageUIElements = new MyBasketPageUIElements();
        this.elementHelper = new ElementHelper(driver,new WebDriverWait(driver, Duration.ofSeconds(60)));

    }

    public void getAndWriteDetailsToTxt(){

      String description = elementHelper.getText(detailPageUIElements.detailPageDescription);
      price = elementHelper.getText(detailPageUIElements.detailPagePrice);
      saveToTxtFile(description,price);
      elementHelper.waitElements(30);
      Log.info("step -> getAndWriteDetailsToTxt");

    }

    public boolean addProductToBasket(){

        elementHelper.waitVisibilityOfElementLocated(detailPageUIElements.detailPageSize);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> elements = elementHelper.findElements(detailPageUIElements.detailPageSize);
        System.out.println(elements.size());
        WebElement selectSize = null;
        for(WebElement element : elements){
            if (!element.getAttribute("class").contains("-disabled")){
                System.out.println("elements : " + element.getAttribute("class"));
                selectSize = element;
            }

        }
        elementHelper.click(selectSize);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        elementHelper.click(detailPageUIElements.detailPageAddToBasket);
        elementHelper.waitVisibilityOfElementLocated(myBasketPageUIElements.myBasketCount);

        if(elementHelper.isDisplayedElement(myBasketPageUIElements.myBasketCount)){
            if(Objects.equals(elementHelper.findElement(myBasketPageUIElements.myBasketCount).getText(), "(1)")){
                Log.info("step -> addProductToBasket");
                return true;
            }
        }
        Log.info("step -> addProductToBasket");
        return false;



    }













}
