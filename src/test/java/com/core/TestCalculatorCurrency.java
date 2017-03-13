package com.core;
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by artem on 05.03.17.
 * Modified by artem on 08.03.17
 * Modified by artem on 12.03.17
 * Modified by artem on 13.03.17
 */
@RunWith(Parameterized.class)
public class TestCalculatorCurrency extends TestCore implements TestCoreInterface{
    {Configuration.browserSize ="1366x768";}
    private static Data data =new Data("dataOfConversionCurrency.csv");
    private String headerWidget;
    private String valueOfHeaderWidget;
    private String pathListCodes;
    private String pathVisibleListCodes;
    private String pathVisibleListCodesToConvert;
    private String valueCurrency;
    private String codeCurrency;
    private String codeConversionCurrency;
    private String pathSourceCode;
    private String pathDestinationCode;
    private String pathNote;
    private String inputWidget;
    private String buttonWidget;
    private String resultWidget;
    private String valueConversion;

    public TestCalculatorCurrency(
            String headerWidget,
            String valueOfHeaderWidget,
            String pathListCodes,
            String pathVisibleListCodes,
            String pathVisibleListCodesToConvert,
            String valueCurrency,
            String codeCurrency,
            String codeConversionCurrency,
            String pathSourceCode,
            String pathDestinationCode,
            String pathNote,
            String inputWidget,
            String buttonWidget,
            String resultWidget,
            String valueConversion)
    {
        this.headerWidget=headerWidget;
        this.valueOfHeaderWidget=valueOfHeaderWidget;
        this.pathListCodes=pathListCodes;
        this.pathVisibleListCodes=pathVisibleListCodes;
        this.pathVisibleListCodesToConvert=pathVisibleListCodesToConvert;
        this.valueCurrency=valueCurrency;
        this.codeCurrency= codeCurrency;
        this.codeConversionCurrency=codeConversionCurrency;
        this.pathSourceCode=pathSourceCode;
        this.pathDestinationCode=pathDestinationCode;
        this.pathNote=pathNote;
        this.inputWidget=inputWidget;
        this.buttonWidget=buttonWidget;
        this.resultWidget=resultWidget;
        this.valueConversion = valueConversion;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        return data.getTestData();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Title("Тест конвертации валют")
    @Description("Содержит 9 шагов")
    public void TestCalculator() throws InterruptedException {
        openPage();
        inputCurrency(valueCurrency);
        inputCodeCurrency(0, codeCurrency, pathListCodes, pathVisibleListCodes);
        inputCodeCurrencyToConvert(1, codeConversionCurrency, pathListCodes, pathVisibleListCodesToConvert);
        selectSourceCode();
        selectDestinationCode();
        checkNote();
        getValueConversion();
        checkValueCurrency();
    }

    @Step("Открытие калькулятора иностранных валют")
    public void openPage(){
        calculator.open();
        header.expected(headerWidget,valueOfHeaderWidget);
    }

    @Step("Ввод значения количества валюты клиента")
    public void inputCurrency(String inputCurrency){
        inputElement.setValue(inputWidget, inputCurrency);
    }

    @Step("Выбор кода валюты клиента")
    public void inputCodeCurrency(int numberListCurrency, String codeCurrency,String pathListCodes, String pathVisibleListCodes) {
        code.setCode(pathListCodes, numberListCurrency);
        code.checkCode(pathVisibleListCodes,codeCurrency);
    }

    @Step("Выбор кода валюты для конвертирования")
    public void inputCodeCurrencyToConvert(int numberListCurrency, String codeCurrency,String pathListCodes, String pathVisibleListCodes) {
        code.setCode(pathListCodes, numberListCurrency);
        code.checkCode(pathVisibleListCodes,codeCurrency);
    }

    @Step("Выбор источника валюты")
    public   void selectSourceCode (){
        sourceCurrency.setSource(pathSourceCode);
    }

    @Step("Выбор способа получения валюты")
    public  void selectDestinationCode (){
        sourceCurrency.setSource(pathDestinationCode);
    }

    @Step("Проверка наличия уведомления об обмене наличной валюты")
    public void checkNote(){
        notification.checkNote(pathNote);
    }

    @Step("Получение значения количества валюты клиента")
    public void getValueConversion(){
        buttonGetConversion.click(buttonWidget);
    }

    @Step("Проверка количества валюты, получаемое клиентом")
    public void checkValueCurrency() throws InterruptedException {
        result.display(resultWidget).expected(valueConversion);
    }

}

