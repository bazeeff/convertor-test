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
 * Created by artem on 09.03.17.
 */
@RunWith(Parameterized.class)
public class TestSelectRegion extends TestCore{
    {Configuration.browserSize ="1366x768";}
    private static Data data =new Data("subjectsRussianFederation.csv");
    private String linkChangeRegion;
    private String headerWidget;
    private String valueOfHeaderWidget;
    private String windowSubject;
    private String inputSubject;
    private String partSubject;
    private String time;
    private String locatorNotification;
    private String subject;


    public TestSelectRegion(String headerWidget,
                            String valueOfHeaderWidget,
                            String linkChangeRegion,
                            String windowSubject,
                            String inputSubject,
                            String partSubject,
                            String time,
                            String locatorNotification,
                            String subject)
    {

        this.headerWidget=headerWidget;
        this.valueOfHeaderWidget=valueOfHeaderWidget;
        this.linkChangeRegion=linkChangeRegion;
        this.windowSubject=windowSubject;
        this.inputSubject=inputSubject;
        this.partSubject=partSubject;
        this.time=time;
        this.locatorNotification=locatorNotification;
        this.subject=subject;

    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        return data.getTestData();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Title("Тест выбора региона РФ")
    @Description("Содержит 6 шагов")
    public void TestSelectSubject() throws InterruptedException {
        openPage();
        openListOfSubjects();
        sendInput();
        checkNote();
        selectSubject();
        checkSubjectOnPage();
    }

    @Step("Открытие калькулятор валют")
    public void openPage(){
        calculator.open();
        header.expected(headerWidget,valueOfHeaderWidget);

    }
    @Step("Открытие списка субъектов РФ")
    public void openListOfSubjects(){
        link.click(linkChangeRegion);
         window.displayed(windowSubject);
    }
    @Step("Ввод части названия региона в поисковом поле")
    public void sendInput(){
        inputElement.setValue(inputSubject, partSubject, time);
    }

    @Step("Проверка подсказки выбора субъекта РФ")
    public void checkNote(){
        notification.checkNote(locatorNotification, subject);
    }

    @Step("Выбор нужного региона")
    public void selectSubject()
    {
        link.click(locatorNotification);
    }

    @Step("Проверка выбранного региона на странице")
    public void checkSubjectOnPage() throws InterruptedException {
        notification.checkNote(locatorNotification, subject);
    }

}
