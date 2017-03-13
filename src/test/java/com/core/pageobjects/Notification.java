package com.core.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by artem on 12.03.17.
 */
public class Notification {
    private SelenideElement notification;
    public Boolean checkNote(String pathNote){
        Boolean check;
        notification = $(By.xpath(pathNote));

        if(notification.isDisplayed()){
            check=true;
        } else {
            check=false;
        }

    return check;}

    public Boolean checkNote(String locator, String content){
        Boolean checkVisible;
        Boolean checkContent;
        notification = $(locator);
        if(notification.isDisplayed()){
            checkVisible=true;
            if(notification.shouldHave(text(content)).isDisplayed()){
                checkContent=true;
             } else checkContent = false;
        } else {
            checkVisible=false;
        }

        return checkVisible;}
}
