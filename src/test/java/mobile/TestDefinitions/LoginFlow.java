package mobile.TestDefinitions;

import base.AppDriver;
import base.Utils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginFlow {

    private String platformName;

    Utils u = new Utils();

    // Locators
    private By continueBtn;
    private By email;
    private By loginOrSignupHeader;
    private By loginOrSignupBtn;
    private By password;
    private By header;
    private By profile;
    private By accountDetails;
    private By backToProfile;
    private By logout;
//    public LoginFlow(){
//        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
//    }

    public LoginFlow(String platformName){
        this.platformName = platformName;
        initLocators();
    }

    public String getPlatformName() {
        return platformName;
    }

    // Initialize locators based on platform
    private void initLocators() {
        if ("iOS".equalsIgnoreCase(platformName)) {
            email = By.xpath("//*[contains(@label, \"What's your email\") or contains(@name, \"What's your email\")]");
            continueBtn = By.xpath("//XCUIElementTypeButton[contains(@label, 'Continue') or contains(@name, 'Continue')]");
            loginOrSignupBtn = By.xpath("//XCUIElementTypeButton[contains(@label, 'Sign up or log in') or contains(@name, 'Sign up or log in')]");
            loginOrSignupHeader = By.xpath("//XCUIElementTypeStaticText[contains(@label, 'Sign up or log in') or contains(@name, 'Sign up or log in')]");
            password = By.id("PASSWORD_TEXTFIELD_IOS");
            header = By.id("HEADER_IOS");
            profile = By.id("ic_profile_ios");
            accountDetails = By.id("Account_Details_IOS");
            backToProfile = By.id("ic_arrow_left_ios");
            logout = By.id("LOGOUT_IOS");
        } else if ("Android".equalsIgnoreCase(platformName)) {
            email = By.id("au.com.podcastoneaustralia:id/emailEditText");
            continueBtn = By.id("au.com.podcastoneaustralia:id/continueButton");
            loginOrSignupHeader = By.id("au.com.podcastoneaustralia:id/namePasswordTextView");
            password = By.id("au.com.podcastoneaustralia:id/passwordForLogin");
            header = By.name("HEADER");
            profile = By.id("au.com.podcastoneaustralia:id/profileImage");
            accountDetails = By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView");
            backToProfile = By.className("android.widget.ImageView");
            logout = By.id("au.com.podcastoneaustralia:id/buttonTitleTextView");
        }
    }


    public String loginToLogout(String emailVal, String passwordVal) throws Exception {
        String getNamePasswordHeaderName;
        u.implicitWait();
        if ("iOS".equalsIgnoreCase(platformName)) {
            u.clickElement(loginOrSignupBtn, "'Sign up or log in' Button");
        }
        u.enterVal(email, "Email Address", emailVal);
        getNamePasswordHeaderName = AppDriver.getDriver().findElement(loginOrSignupHeader).getText();
        return getNamePasswordHeaderName;
    }
    

}

