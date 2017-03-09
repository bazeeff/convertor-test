import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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
 * Created by artem on 09.03.17.
 */
@RunWith(Parameterized.class)
public class TestSelectRegion {
    private String link;
    private String headerWidget;
    private String valueOfHeaderWidget;
/*    private String subject;
    private String pathSubject;*/

    public TestSelectRegion(String link,String headerWidget, String valueOfHeaderWidget/*, String subject,String pathSubject */){
        this.link=link;
        this.headerWidget=headerWidget;
        this.valueOfHeaderWidget=valueOfHeaderWidget;
/*        this.subject=subject;
        this.pathSubject=pathSubject;*/

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Title("Калькулятор иностранных валют-тест выбора региона РФ")
    @Description("Содержит n шагов")
    public void TestSelectSubject(){
        openCalculator();
        openListOfSubjects();
        sendInput();
        checkNote();
        selectSubject();
        checkSubjectOnPage();
    }

    @Step("Открываем Калькулятор валют")
    public void openCalculator(){
        SelenideElement header = $(headerWidget);
        open(link);
        header.shouldHave(Condition.text(valueOfHeaderWidget));

    }
    @Step("Открываем список регионов РФ")
    public void openListOfSubjects(){
        $("span.region-list__name").click();
        $("div.kit-modal-content.kit-modal-content_view_window.kit-modal-content_orientation_portrait").isDisplayed();
    }
    @Step("В поле поиска вводим название региона РФ")
    public void sendInput(){
    $("input.kit-input__control").click();
        $("input.kit-input__control").sendKeys("Ростов");

    }

    @Step("Проверяем всплывает ли подсказка")
    public void checkNote(){
        $("span.region-search-box__option").shouldHave(Condition.text("Ростовская область"));
    }

    @Step("Выбор нужного региона")
    public void selectSubject(){
        $("span.region-search-box__option").click();
    }

    @Step("Проверяем появление региона на странице")
    public void checkSubjectOnPage(){
        sleep(5000);
        $("span.region-list__name").isDisplayed();
        $("span.region-list__name").shouldHave(Condition.text("Ростовская область"));
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        return getTestData("subjectsRussianFederation.csv");
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
