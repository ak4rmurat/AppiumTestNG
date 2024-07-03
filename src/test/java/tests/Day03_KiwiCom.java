package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;
import utilities.ReusableMethods;


public class Day03_KiwiCom {


    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    KiwiPage page = new KiwiPage();


    @Test
    public void kiwiTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Driver.getAndroidDriver();
        // uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(Driver.getAndroidDriver().findElementByXPath("//*[@text='Sign in to customize your experience']").isDisplayed());
        // misafir olarak devam et e tiklanir
        page.continueAsButton.click();
        Thread.sleep(1500);
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        TouchAction action = new TouchAction<>(driver);
        for (int i = 0; i < 3; i++) {
            action.press(PointOption.point(537,1695)).release().perform();
            Thread.sleep(1000);
        }
        Thread.sleep(1500);
        // Trip type,one way olarak secilir
        page.returnButton.click();
        driver.findElementByXPath("//*[@index='2']").click();
        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        driver.findElementByXPath("//*[@text='From:']").click();
        Thread.sleep(1500);
        //1017,136
        ReusableMethods.tiklamaMethodu(1017,136,1000);
        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        // page.kalkisEditText.sendKeys("istanbul");
        // driver.getKeyboard().pressKey("istanbul");
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("istanbul");
        }else {
            page.kalkisEditText.sendKeys("Samsun");
        }
        Thread.sleep(1000);
        page.kalkisVarisSehriButton.click();
        page.choseButton.click();
        page.toButton.click();
        driver.getKeyboard().sendKeys("London");
        Thread.sleep(1000);
        page.kalkisVarisSehriButton.click();
        page.choseButton.click();
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        // gidis tarihi haziran ayinin 21 i olarak secilir ve set date e tiklanir
        //829,1116
        page.departureButton.click();
        Thread.sleep(2000);
        ReusableMethods.tiklamaMethodu(829,1116,1000);
        page.setDateButton.click();

        // search butonuna tiklanir
        page.searchButton.click();
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        page.bestButton.click();
        page.cheapestButton.click();
        page.stopsButton.click();
        page.nonStopButton.click();
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir.
        Thread.sleep(1500);
        String fiyat = page.enUcuzBiletFiyati.getText();
        driver.sendSMS("05555555555", "Kiwi uygulamasindaki en uzun bilet fiyati = " + fiyat);
    }
}
