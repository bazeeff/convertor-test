package com.core;

import com.codeborne.selenide.Configuration;
import com.core.pageobjects.*;

/**
 * Created by artem on 12.03.17.
 */
public abstract class TestCore  {
    {
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://sberbank.ru";
        Configuration.timeout = 8000;

    }

    protected CalculatorPage calculator= new CalculatorPage();
    protected Header header = new Header();
    protected InputElement inputElement = new InputElement();
    protected CodeCurrency code = new CodeCurrency();
    protected SourceCurrency sourceCurrency = new SourceCurrency();
    protected Notification notification = new Notification();
    protected Button buttonGetConversion = new Button();
    protected Button button = new Button();
    protected ResultWidget result = new ResultWidget();
    protected Link link = new Link();
    protected ModalWindow window = new ModalWindow();
    protected Date date = new Date();

}
