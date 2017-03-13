package com.core;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by artem on 13.03.17.
 */
@RunWith(Parameterized.class)
public class TestExtendedTableCurrency extends TestCore  {

    {Configuration.browserSize ="1024x768";}
    private static Data data =new Data("dataOfExtendedTable.csv");
    private String headerWidget;
    private String valueOfHeaderWidget;
    private String pathListCodes;
    private String pathVisibleListCodesToConvert;
    private String codeConversionCurrency;
    private String extendTable;
    private String locatorDate;
    private String sendDate;
    private String locatorButton;
    private String resultTable;
    private String rateDown;
    private String valueRateDown;
    private String nameCurrency;
    private String buyCurrency;
    private String sellCurrency;
    private String unit;
    private String rateUp;

    public TestExtendedTableCurrency(
            String headerWidget,
            String valueOfHeaderWidget,
            String pathListCodes,
            String pathVisibleListCodesToConvert,
            String codeConversionCurrency,
            String extendTable,
            String locatorDate,
            String sendDate,
            String locatorButton,
            String resultTable,
            String rateDown,
            String valueRateDown,
            String nameCurrency,
            String buyCurrency,
            String sellCurrency,
            String unit,
            String rateUp
                                )
    {
        this.headerWidget=headerWidget;
        this.valueOfHeaderWidget=valueOfHeaderWidget;
        this.pathListCodes=pathListCodes;
        this.pathVisibleListCodesToConvert=pathVisibleListCodesToConvert;
        this.codeConversionCurrency=codeConversionCurrency;
        this.extendTable=extendTable;
        this.locatorDate=locatorDate;
        this.sendDate=sendDate;
        this.locatorButton=locatorButton;
        this.resultTable=resultTable;
        this.rateDown=rateDown;
        this.valueRateDown=valueRateDown;
        this.nameCurrency=nameCurrency;
        this.buyCurrency=buyCurrency;
        this.sellCurrency=sellCurrency;
        this.unit=unit;
        this.rateUp=rateUp;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        return data.getTestData();
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Title("Тест расширенной таблицы курсов")
    @Description("Содержит 6 шагов")

    public void TestExtendedTable() throws InterruptedException {
        openPage();
        inputCodeCurrencyToConvert(1, codeConversionCurrency, pathListCodes, pathVisibleListCodesToConvert);
        selectExtendTable();
        selectDate();
        getCurrency();
        displayedExtendTable();
    }

    @Step("Открытие калькулятора иностранных валют")
    public void openPage() {
        calculator.open();
        header.expected(headerWidget,valueOfHeaderWidget);
    }
    @Step("Выбор кода валюты конвертирования")
    public void inputCodeCurrencyToConvert(int numberListCurrency, String codeCurrency, String pathListCodes, String pathVisibleListCodes) {
        code.setCode(pathListCodes, numberListCurrency);
        code.checkCode(pathVisibleListCodes,codeCurrency);
    }
    @Step("Выбор расширенной таблицы курсов")
    public void selectExtendTable() {
        link.click(extendTable,100);
    }
    @Step("Установка даты")
    public void selectDate() {
        date.setDate(locatorDate,sendDate);
    }
    @Step("Получение курса иностранной валюты, за указанную дату")
    public void getCurrency(){
        button.click(locatorButton,100);
    }
    @Step("Проверка всех значений в таблице")
    public void displayedExtendTable() throws InterruptedException {
        result.display(resultTable).expected(nameCurrency, codeConversionCurrency, unit, buyCurrency, valueRateDown, sellCurrency, rateUp);
    }
}
