package com.core.pageobjects;
import com.codeborne.selenide.Selenide;
/**
 * Created by artem on 12.03.17.
 */
public class CalculatorPage extends BaseConfig {

    public CalculatorPage open(){
        Selenide.open("/ru/quotes/converter");
        return this;
    }
}
