package com.core.pageobjects;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by artem on 12.03.17.
 */
public class ResultWidget {

    private SelenideElement result;

    public ResultWidget display(String resultWidget){
        result=$(By.xpath(resultWidget));

        return this;
    }

    public boolean expected(String valueConvertion){
        result.shouldHave(Condition.text(valueConvertion));
    return true;}

    public boolean expected(String nameCurrency, String codeConversionCurrency, String unit, String buyCurrency, String valueRateDown, String sellCurrency, String rateUp){

        result.shouldHave(Condition.text(nameCurrency));
        result.shouldHave(Condition.text(codeConversionCurrency));
        result.shouldHave(Condition.text(unit));
        result.shouldHave(Condition.text(buyCurrency));
        result.shouldHave(Condition.text(valueRateDown));
        result.shouldHave(Condition.text(sellCurrency));
        result.shouldHave(Condition.text(rateUp));
        return true;}
}
