package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyConverter;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class Day04_AllCurrencyConventer {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    AllCurrencyConverter page = new AllCurrencyConverter();

    @Test
    public void allCurrencyTest() throws InterruptedException, IOException {

        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));
        // uygulamanin acildigi dogrulanir
        Assert.assertTrue(driver.findElementByXPath("//*[@text='CURRENCY CONVERTER']").isDisplayed());
        // cevirmek istedigimiz para birimi zloty olarak secilir
        ReusableMethods.tiklamaMethodu(438,340,500);
        ReusableMethods.scrollWithUiScrollableAndClick("PLN");
        // cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.tiklamaMethodu(499,492,500);
        ReusableMethods.scrollWithUiScrollableAndClick("TRY");
        page.dort.click();
        page.iki.click();
        for (int i = 0; i < 2; i++) {
            page.sifir.click();
        }
        /*
        File screenShot = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot,new File("screenshot.jpg"));

        Bu locate alma yöntemi en basit olan ve dinamik olmayan yöntemdir.
        Ekran goruntusunu alarak oldugu gibi projenin icerisine ekler.
         */


        // cevrilen tutar screenShot olarak kaydedilir
        ReusableMethods.getScreenshot("tutar");
        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        String sonuc = page.sonuc.getText();
        // kullaniciya sms olarak bildirilir
        driver.sendSMS("55555555555", "Çevirmek istediginiz tutar = " + sonuc + " TL");

    }
}
