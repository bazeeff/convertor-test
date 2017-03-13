package com.core.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by artem on 12.03.17.
 */
public class ModalWindow {
    private SelenideElement window;

    public boolean displayed(String locator){
        window=$(locator);
        window.isDisplayed();
    return true;}
}
