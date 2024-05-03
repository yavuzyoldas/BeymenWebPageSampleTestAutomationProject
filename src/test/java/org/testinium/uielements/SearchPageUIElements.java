package org.testinium.uielements;

import org.openqa.selenium.By;

public class SearchPageUIElements {

    public By searchPageSearchBar = new By.ByCssSelector("input[placeholder='Ürün, Marka Arayın']");
    public By searchPageSearchBarCleanButton = By.className("-hasButton");
    public By searchPageSearchBarSecond = new By.ById("o-searchSuggestion__input");
    public By searchPageChooseProduct = new By.ByClassName("m-productCard__desc");



}
