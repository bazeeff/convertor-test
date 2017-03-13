package com.core.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by artem on 12.03.17.
 */
public class Link {
    private SelenideElement link;
    public Link click(String locator){
        link=$(locator);
        link.click();
    return this;}

    public Link click(String locator, long time){
        link=$(By.xpath(locator));
        sleep(time);
        link.click();
        return this;}
}
