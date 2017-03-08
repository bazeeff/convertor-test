import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by artem on 05.03.17.
 * Modified by artem on 08.03.17
 */
@RunWith(Parameterized.class)
public class TestCalculatorCurrency {
    private String link;
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

    public TestCalculatorCurrency(String link,
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
                                  String resultWidget ){
        this.link=link;
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
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Title("Калькулятор иностранных валют")
    @Description("Содержит 9 шагов")
    public void TestCalculator() throws InterruptedException {
        openCalculator();
        inputCurrency(valueCurrency);
        inputCodeCurrency(0, codeCurrency, pathListCodes, pathVisibleListCodes);
        inputCodeCurrencyToConvert(1, codeConversionCurrency, pathListCodes, pathVisibleListCodesToConvert);
        selectSourceCode();
        selectDestinationCode();
        checkNote();
        getValueConversion();
        checkValueCurrency();
    }

    @Step("Открываем Калькулятор валют")
    public void openCalculator(){
        open(link);
        $(headerWidget).shouldHave(Condition.text(valueOfHeaderWidget));
    }

    @Step("Вводим значение количества валюты клиента")
    public void inputCurrency(String inputCurrency){
        WebElement input = $(By.xpath(inputWidget));
        input.click();
        input.clear();
        input.sendKeys(inputCurrency);
    }

    @Step("Выбираем код валюты клиента")
    public void inputCodeCurrency(int numberListCurrency, String codeCurrency,String pathListCodes, String pathVisibleListCodes) {
        WebElement listCodes =  $$(By.xpath(pathListCodes)).get(numberListCurrency);
        listCodes.click();
        WebElement codeIsSelected = $(By.xpath(pathVisibleListCodes));
        //         if(codeIsSelected.getText().equals(codeCurrency)){
        $(codeIsSelected).click();
        //         }
    }
    @Step("Выбираем код валюты для конвертирования")
    public void inputCodeCurrencyToConvert(int numberListCurrency, String codeCurrency,String pathListCodes, String pathVisibleListCodes) {
        WebElement listCodes =  $$(By.xpath(pathListCodes)).get(numberListCurrency);
        listCodes.click();
        WebElement codeIsSelected = $(By.xpath(pathVisibleListCodes));
        //         if(codeIsSelected.getText().equals(codeCurrency)){
        $(codeIsSelected).click();
        //         }
    }

    @Step("Выбираем источник валюты клиента")
    public  void selectSourceCode (){
        WebElement selectSource = $(By.xpath(pathSourceCode));
        selectSource.click();
    }

    @Step("Выбираем способ получения валюты")
    public  void selectDestinationCode (){
        WebElement selectDestination = $(By.xpath(pathDestinationCode));
        selectDestination.click();
    }


    @Step("Проверяем наличие уведомления об обмене наличной валюты")
    public boolean checkNote(){
        Boolean check;
        WebElement notification = $(By.xpath(pathNote));
        if(notification.isDisplayed()){
            check=true;
        } else {
            check=false;
        }
        return check;
    }

    @Step("Получаем значение количества валюты клиента")
    public void getValueConversion(){
        WebElement button = $(By.xpath(buttonWidget));
        button.click();
    }

    @Step("Проверяем значение количества валюты, которую получит клиент")
    public void checkValueCurrency() throws InterruptedException {
        WebElement result = $(By.xpath(resultWidget));
        result.getText().equals("5,60");
    }


    @Parameters
    public static Collection testData() throws IOException {
        return getTestData("dataOfConversionCurrency.csv");
    }

    public static Collection<String[]> getTestData(String fileName)
            throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String record;
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        while ((record = file.readLine()) != null) {
            String fields[] = record.split(",");
            records.add(fields);
        }
        file.close();
        return records;
    }

}

