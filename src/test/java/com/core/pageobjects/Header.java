package com.core.pageobjects;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
/**
 * Created by artem on 12.03.17.
 */
public class Header {

    private SelenideElement header;

    public Header expected (String headerWidget, String valueOfHeaderWidget){
        header=$(headerWidget);
        header.shouldHave(Condition.text(valueOfHeaderWidget));
    return  this;
    }
}
