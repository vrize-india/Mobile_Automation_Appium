package mobile.Tests;


import base.AppFactory;
import mobile.TestDefinitions.LoginFlow;
import org.testng.Assert;
import org.testng.annotations.*;


import java.net.MalformedURLException;
import java.util.Map;

/**
 * @author gauravpurwar
 * Platform iOS
 * Various test cases for login journey
 * 4 test cases
 */
public class LoginTests {

    LoginFlow lf;
    private String platformName;

    @Parameters({"platformName"})
    @BeforeMethod
    public void Setup(String platformName) throws MalformedURLException {
        this.platformName = platformName;
        if(platformName.equalsIgnoreCase("ios")) {
            AppFactory.iOSLaunchApp();
        } else if (platformName.equalsIgnoreCase("android")) {
            AppFactory.androidLaunchApp();
        }

        lf = new LoginFlow(platformName);
    }

    /**
     *    Providing different credentials to validate positive and negative test cases - data driven
     */
    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"gaurav@vrize.com", "test123"}};
    }


    /**
     *
     * @param emailVal
     * @param passwordVal
     * @throws Exception
     */
    @Test(dataProvider = "data-provider", enabled = true, priority = 2)
    public void loginJourneyWithDifferentCredentials(String emailVal, String passwordVal) {
        String actualHeaderName;
        Map<String, String> expectedHeaders = Map.of(
                "android", "Login or Sign up",
                "ios", "Sign up or log in"
        );
        String expectedHeaderName = expectedHeaders.getOrDefault(platformName.toLowerCase(), "Unknown Platform");
        try {
            actualHeaderName = lf.loginToLogout(emailVal, passwordVal);
            Assert.assertEquals(actualHeaderName, expectedHeaderName, "Header Name didn't match!");
            System.out.println("Test Passed!");
        } catch (Exception e) {
            Assert.fail("Test Failed: Error: Invalid Header! " + e.getMessage());
        }
    }



//    /**
//     * The test is to verify the login Journey with valid email address and password
//     * @throws Exception
//     */
//    @Test(enabled = false, priority = 3)
//    public void loginWithValidCredentials() throws Exception {
//
//      try{
//          String emailVal = "purwar389@gmail.com";
//        String password = "test123";
//
//        String actualEmail = lf.loginToLogout(emailVal,password);
//        Assert.assertEquals(actualEmail, emailVal, "Email Address didn't match!");
//        System.out.println("Test Passed!");
//    } catch (Exception e) {
//        Assert.fail("Test Failed : Error : Invalid Credentials! "+e.getMessage());
//    }
//
//    }
//
//    /**
//     * The test is to verify the valid error for incorrect email address
//     * @throws Exception
//     */
//    @Test (enabled = false, priority = 3)
//    public void loginWithInvalidEmail() throws InterruptedException {
//
//        String emailVal = "invalid";
//
//        String errMsg = lf.enterInvalidEmailDuringLogin(emailVal);
//        Assert.assertEquals(errMsg, "Please enter a valid email address", "Error Message didn't match!");
//        System.out.println("Test Passed!");
//
//    }
//
//    /**
//     * The test is to verify the valid error for incorrect password
//     * @throws Exception
//     */
//    @Test (enabled = false, priority = 4)
//    public void loginWithInvalidPassword() throws InterruptedException {
//
//        String emailVal = "purwar389@gmail.com";
//        String passwordVal = "Invalid";
//
//
//        String errMsg = lf.enterInvalidPasswordDuringLogin(emailVal,passwordVal);
//        Assert.assertEquals(errMsg, "Your password is invalid or the email address does not have an account. Please try again", "Error Message didn't match!");
//        System.out.println("Test Passed!");
//
//    }


    @AfterMethod
    public void tearDown(){
        AppFactory.closeApp();
    }



}
