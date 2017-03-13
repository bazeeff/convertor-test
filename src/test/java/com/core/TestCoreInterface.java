package com.core;

/**
 * Created by artem on 13.03.17.
 */
public interface TestCoreInterface {
    public void openPage();
    public void inputCurrency(String inputCurrency);
    public void inputCodeCurrency(int numberListCurrency, String codeCurrency,String pathListCodes, String pathVisibleListCodes);
    public void inputCodeCurrencyToConvert(int numberListCurrency, String codeCurrency,String pathListCodes, String pathVisibleListCodes);
    public void selectSourceCode ();
    public  void selectDestinationCode();
    public void checkNote();
    public void getValueConversion();
    public void checkValueCurrency() throws InterruptedException;
}
