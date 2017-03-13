package com.core.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by artem on 12.03.17.
 */
public class Button {
    private SelenideElement button;
    public Button click(String buttonWidget){
        button=$(By.xpath(buttonWidget));
        button.click();
        return this;
    }
    public Button click(String locatorButton, long time ){
        button=$(locatorButton);
        sleep(time);
        button.click();
        return this;
    }
}
