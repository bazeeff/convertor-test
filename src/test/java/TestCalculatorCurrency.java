
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

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by artem on 05.03.17.
 */
@RunWith(Parameterized.class)
public class TestCalculatorCurrency {

    private String link;
    private String headerWidget;
    private String valueOfHeaderWidget;
    private String inputWidget;
    private String buttonWidget;
    private String resultWidget;

    public TestCalculatorCurrency(String link, String headerWidget, String valueOfHeaderWidget, String inputWidget, String buttonWidget, String resultWidget ){
        this.link=link;
        this.headerWidget=headerWidget;
        this.valueOfHeaderWidget=valueOfHeaderWidget;
        this.inputWidget=inputWidget;
        this.buttonWidget=buttonWidget;
        this.resultWidget=resultWidget;
    }



    @Test
    @Severity(SeverityLevel.NORMAL)
    @Title("Калькулятор иностранных валют")
    @Description("Содержит 4 шага")
    public void TestCalculator() {
        openCalculator();
        inputCurrency();
        getValueConversion();
        checkValueCurrency();
    }
    @Step("Step '{1}': Open conversion currency")
    public void openCalculator(){
        open(link);
        $(headerWidget).shouldHave(Condition.text(valueOfHeaderWidget));
    }

    @Step("Step '{2}': Input value of currency")
    public void inputCurrency(){
        WebElement input = $(By.xpath(inputWidget));
        input.click();
        input.clear();
        input.sendKeys("7");
    }


    @Step("Step '{3}': Get value currency of process conversion")
    public void getValueConversion(){
        WebElement button = $(By.xpath(buttonWidget));

        button.click();

    }

    @Step("Step '{4}': Check  value for value of standard value")
    public void checkValueCurrency(){
        WebElement result = $(By.xpath(resultWidget));
        result.equals("0,12");

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

