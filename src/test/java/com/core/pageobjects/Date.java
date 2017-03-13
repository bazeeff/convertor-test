package com.core.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by artem on 13.03.17.
 */
public class Date {

    SelenideElement date;

    public Date setDate(String locatorDate, String sendDate){
        date=$(By.className(locatorDate));
        date.click();
        date.clear();
        date.sendKeys(sendDate);
        date.pressEscape();
    return this;}
}
