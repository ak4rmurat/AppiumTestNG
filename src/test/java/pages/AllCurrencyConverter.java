package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AllCurrencyConverter {

    public AllCurrencyConverter(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b1")
    public WebElement bir;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b4")
    public WebElement dort;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b2")
    public WebElement iki;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b0")
    public WebElement sifir;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB")
    public WebElement sonuc;


}
