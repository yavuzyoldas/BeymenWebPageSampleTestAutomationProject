package org.example.uielements;

import org.openqa.selenium.By;

public class MyBasketPageUIElements {

    public By myBasketPageElement = By.xpath("//a[@title='Sepetim']//*[name()='svg']");
    public By myBasketPagePrice = By.className("m-orderSummary__value");
    public By myBasketNumber = By.id("quantitySelect0-key-0");
    public By myBasketClean = By.id("removeCartItemBtn0-key-0");
    public By myBasketEmptyInfo = By.className("m-empty__messageTitle");
    public By myBasketCount = By.className("o-header__userInfo--count");





}
