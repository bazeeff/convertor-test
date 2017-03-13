package com.core.pageobjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
/**
 * Created by artem on 12.03.17.
 */
public class CodeCurrency {

    private SelenideElement listCodes;
    private SelenideElement codeSelected;

    public CodeCurrency setCode(String pathListCurrency, int numberListCurrency){
        listCodes =  $$(By.xpath(pathListCurrency)).get(numberListCurrency);
        listCodes.click();
    return this;}

    public CodeCurrency checkCode(String visibleListCode, String codeCurrency){
        codeSelected=$(By.xpath(visibleListCode));
       // if(codeSelected.toString().contains(codeCurrency)){
            codeSelected.click();
        //}
    return this;}


}
