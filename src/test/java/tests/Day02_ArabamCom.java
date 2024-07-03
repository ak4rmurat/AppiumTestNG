package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Day02_ArabamCom {

    AndroidDriver<AndroidElement> androidDriver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        // capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\MURAT\\Desktop\\T135_Appium\\Apps\\arabam.com_5.1.6_Apkpure.apk");
        capabilities.setCapability("appPackage","com.dogan.arabam");
        /*
        appPackage çalışacak olduğunuz app bilgisini (TC No) girdikten sonra o uygulamayı baslatır.
        Fakat!!!! uygulamayı baştan yüklemeniz gerekmektedir. EĞER uygulama yüklü değilse uygulamayı başlatmaz
         */

        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");

        /*
        AppActivity uygulamanın hangi sayfasından başlamasını istiyorsanız uygulamanın activity değerini girerek
        uygulamayı o sayfadana başlatabilirsiniz.
         */
        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test01() throws InterruptedException {

        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(androidDriver.isAppInstalled("com.dogan.arabam"));

        // uygulaminin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(androidDriver.findElementByXPath("//*[@text='Alırken, satarken kullanırken']").isDisplayed());

        // alt menuden ilan ara butonuna tiklanir
        androidDriver.findElementByXPath("//*[@text='İlan Ara']").click();

        // kategori olarak otomobil secilir
        androidDriver.findElementByXPath("//*[@text='Otomobil']").click();
        // arac olarak Volkswagen secilir
        Thread.sleep(2000);

        TouchAction action = new TouchAction<>(androidDriver);
        action.press(PointOption.point(538,1825))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                                .moveTo(PointOption.point(538,565))
                                        .release()
                                                .perform();

        androidDriver.findElementByXPath("//*[@text='Volkswagen']").click();
        // arac markasi olarak passat secilir

        androidDriver.findElementByXPath("//*[@text='Passat']").click();
        // 1.4 TSI BlueMotion secilir

        androidDriver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        // Paket secimi yapilir(comfortline)
        androidDriver.findElementByXPath("//*[@text='Comfortline']").click();
        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        androidDriver.findElementByXPath("//*[@text='Sıralama']").click();
        androidDriver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();
        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
        String aracFiyati = androidDriver.findElementByXPath("(//*[@index='3'])[3]").getText();
        aracFiyati = aracFiyati.replaceAll("\\D","" );
        Assert.assertTrue(Integer.parseInt(aracFiyati)>500000);


    }

    @Test
    public void test02(){

    }

}
