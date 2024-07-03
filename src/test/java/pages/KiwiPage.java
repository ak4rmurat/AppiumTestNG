package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPage {


    public KiwiPage(){
        PageFactory.initElements((WebDriver)Driver.getAndroidDriver(),this);
    }


    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement continueAsButton;

    @FindBy(xpath = "//*[@text='Return']")
    public WebElement returnButton;

    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement kalkisEditText;

    @FindBy(xpath = "(//*[@class='android.view.View'])[8]")
    public WebElement kalkisVarisSehriButton;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement choseButton;

    @FindBy(xpath = "//*[@text='To:']")
    public WebElement toButton;

    @FindBy(xpath = "//*[@text='Departure:']")
    public WebElement departureButton;

    @FindBy(xpath = "//*[@text='Set date']")
    public WebElement setDateButton;

    @FindBy(xpath = "(//*[@text='Search'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@text='Best']")
    public WebElement bestButton;

    @FindBy(xpath = "//*[@text='Cheapest']")
    public WebElement cheapestButton;

    @FindBy(xpath = "//*[@text='Stops']")
    public WebElement stopsButton;

    @FindBy(xpath = "//*[@text='Nonstop']")
    public WebElement nonStopButton;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[11]")
    public WebElement enUcuzBiletFiyati;



}
