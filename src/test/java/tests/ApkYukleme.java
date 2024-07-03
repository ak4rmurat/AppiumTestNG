package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ApkYukleme {
    AndroidDriver<AndroidElement> androidDriver;

    @Test
    public void yukleme() throws MalformedURLException {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            // Telefon bilgilerini yüklemek için methodları barındıran obje capabilities.

            // deviceName gerekli değildir. Fakat altındaki 3 bölüm android, 11.0 ve Uiautomator2 olması zorunludur.

            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\MURAT\\Desktop\\T135_Appium\\Apps\\all-currency-converter-3-9-0 (1).apk");
            androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }
}
