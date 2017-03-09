import com.codeborne.selenide.Condition;
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

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by artem on 09.03.17.
 */
@RunWith(Parameterized.class)
public class TestSelectRegion {
    private String link;
    private String headerWidget;
    private String subject;
    private String pathSubject;

    public TestSelectRegion(String link,String headerWidget, String subject,String pathSubject ){
        this.link=link;
        this.headerWidget=headerWidget;
        this.subject=subject;
        this.pathSubject=pathSubject;

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
        open(link);

    }
    @Step("Открываем список регионов РФ")
    public void openListOfSubjects(){

    }
    @Step("В поле поиска вводим название региона РФ")
    public void sendInput(){

    }

    @Step("Проверяем всплывает ли подсказка")
    public void checkNote(){

    }

    @Step("Выбор нужного региона")
    public void selectSubject(){

    }

    @Step("Проверяем появление региона на странице")
    public void checkSubjectOnPage(){

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
