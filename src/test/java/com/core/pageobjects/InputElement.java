package com.core.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by artem on 12.03.17.
 */
public class InputElement {

    private SelenideElement input;

    public InputElement setValue(String xpathCurrency, String valueCurrency) {
        input =$(By.xpath(xpathCurrency));
        input.clear();
        input.sendKeys(valueCurrency);
        return this;}

    public InputElement setValue(String locator, String value, String time) {
        input =$(locator);
        input.clear();
        input.sendKeys(value);
        sleep(Long.parseLong(time));
        return this;}
}
