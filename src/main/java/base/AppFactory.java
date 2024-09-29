package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * @author gauravpurwar
 * @date 04 Aug2022
 * Class is to launch iOS and Android Apps
 */
public class AppFactory {

    public static AppiumDriver driver;
    public static DesiredCapabilities caps;
    static Properties prop = new Properties();
    public static void androidLaunchApp() throws MalformedURLException {

        try {
            prop.load(new FileInputStream("utils/android.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        caps = new DesiredCapabilities();
        caps.setCapability("platformName",prop.getProperty("platformName"));
        caps.setCapability("appium:deviceName",prop.getProperty("deviceName"));
        caps.setCapability("appium:app",System.getProperty("user.dir") + "/src/test/resources/apps/" + prop.getProperty("app"));
        caps.setCapability("appium:automationName", "UiAutomator2"); // Add this line
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:nativeWebScreenshot", true);
        caps.setCapability("appium:newCommandTimeout", 3600);
        caps.setCapability("appium:connectHardwareKeyboard", true);
        caps.setCapability("appPackage", "au.com.podcastoneaustralia");
        caps.setCapability("appActivity", "au.com.podcastoneaustralia.ui.splash.SplashActivity");
        caps.setCapability("appium:uiautomator2ServerLaunchTimeout", 60000);
        caps.setCapability("autoGrantPermissions", true); // Automatically grant permissions


        URL remoteUrl = new URL(prop.getProperty("appiumHost"));

        driver = new AndroidDriver(remoteUrl, caps);
        System.out.println("Launched successfully!");
        AppDriver.setDriver(driver);
        System.out.println("Android Driver is set!");
    }

    public static void iOSLaunchApp() throws MalformedURLException {


        try {
            prop.load(new FileInputStream("utils/iOS.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        caps = new DesiredCapabilities();
        caps.setCapability("platformName",prop.getProperty("platformName"));
        caps.setCapability("appium:deviceName",prop.getProperty("deviceName"));
        caps.setCapability("appium:app",System.getProperty("user.dir") + "/src/test/resources/apps/" + prop.getProperty("app"));
        caps.setCapability("appium:automationName", AutomationName.IOS_XCUI_TEST);
        caps.setCapability("appium:platformVersion",prop.getProperty("platformVersion"));
        caps.setCapability("appium:udid",prop.getProperty("udid"));
        caps.setCapability("appium:wdaLaunchTimeout", 50000);
        caps.setCapability("commandTimeouts", "12000");//.app
        caps.setCapability("xcodeOrgId", "purwar389@gmail.com");
        caps.setCapability("xcodeSigningId","iPhone Developer");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("autoAcceptAlerts", true);


        URL remoteUrl = new URL(prop.getProperty("appiumHost"));

        driver = new IOSDriver(remoteUrl,caps);
        System.out.println("Launched successfully!");
        AppDriver.setDriver(driver);
        System.out.println("iOS driver is set");

    }

    public static void closeApp(){
        driver.quit();
    }

}