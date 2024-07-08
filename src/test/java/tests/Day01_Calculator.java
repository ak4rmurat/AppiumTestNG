package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Day01_Calculator {

    AndroidDriver<AndroidElement> androidDriver; // Bu driver android cihazlardaki gerçekleştirmek için kullanılır.
    // IOSDriver<IOSElement> iosDriver; // IOS platformlar üzerinde gerçekleştirmek için kullanılır.

    // AppiumDriver<IOSElement> appiumIOSDriver; // Her iki platformda kullanılır.(ios ve android) Ayırıcı noktası
    //                                           // belirtilen element değeridir. Alttaki de tamamen aynı şekilde çalışır
    // AppiumDriver<AndroidElement> appiumAndroidDriver;


    @Test
    public void deneme1() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Telefon bilgilerini yüklemek için methodları barındıran obje capabilities.

        // deviceName gerekli değildir. Fakat altındaki 3 bölüm android, 11.0 ve Uiautomator2 olması zorunludur.

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\MURAT\\Desktop\\T135_Appium\\Apps\\Calculator_8.4 (503542421)_APKPure.apk");
        /*
        UiAutomator2 varsa bunun 1'ide vardır.Eğer android bir cihazda test yapacaksak bununla alakalı bir
        automationName belirlememiz gerekiyor. Belirlediğimiz automationName eğer ki seçtiğimiz platformVersion
        6.0 ' dan büyükse UiAutomator2 kullanilir, 6.0 'dan küçükse UiAutomator kullanilir.
         */

       androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        // Bu bölüm aslında appium server'da yazan bilgilerin aktarılması için gerekli.Aslında burada ürünü getirip
        // götüren appium server ile android studio arasındaki bağlantı kurulmuş oluyor.Artık yapmak istediğimiz
        // işlemleri appium server android studio'a aktarıyor ve telefon üzerinden yapılması gereken işlemler yapılıyor

        // Böylece artık android driver'in içide doldurulmuş oluyor.

        androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        androidDriver.findElementByAccessibilityId("8").click();
        androidDriver.findElementByAccessibilityId("0").click();
        androidDriver.findElementByAccessibilityId("multiply").click();
        androidDriver.findElementByAccessibilityId("2").click();
        androidDriver.findElementByAccessibilityId("0").click();
        String sonuc = androidDriver.findElementById("com.google.android.calculator:id/result_preview").getText();

        Assert.assertEquals(Integer.parseInt(sonuc), 1600); // sonuc sayısal oldugu için sonucta ınt'a çevrildi.















    }
}
