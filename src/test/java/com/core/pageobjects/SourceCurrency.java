package com.core.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by artem on 12.03.17.
 */
public class SourceCurrency {
    private SelenideElement sourceCurrency;
    public SourceCurrency setSource(String pathSource){
        sourceCurrency=$(By.xpath(pathSource));
        sourceCurrency.click();
        return this;
    }
}
