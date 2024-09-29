# VRIZE Mobile App Automation using Appium with Java

# Appium-Java-Mobile-Allure-TestNG-Maven
A test automation framework for Mobile applications.

## Author: Gaurav Purwar


#Introduction
The purpose of this document is to demonstrate what is covered as part of LiSTNR Mobile Apps in iOS and Android using:
1. Core Java
2. Selenium-Java
3. TestNG
4. Appium Java-Client
5. Maven
6. Allure test report tool
7. Appium Inspector
8. XCUITest, Android Driver (Android SDK & Xcode based simulators)
9. TestNG Report


## How to run

`appium`

For iOS
`xcodebuild clean build-for-testing test-without-building -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'id=00008101-000144661EF0001E' -allowProvisioningUpdates`

`Run testng.xml`

OR

`mvn clean test -DplatformName=android`

## Functional Test Cases Automated in this framework

Applications  - LiSTNR apps available in AppStore & PlayStore - Android & mobile

**Test cases
Test case 1-3: loginJourneyWithDifferentCredentials 
Test Data: [uses 3 data based credentials from dataProvide]
1.	Launch the App and Continue
2.	Enter Email 
3.  Enter Password
4.  Go to Account Details Page
5.  Validate the Email 
6.  Log Outsubmit button

Results: Passed, Failed, Failed

Test case 4: loginWithValidCredentials 
Data: {hardcoded email id and password data}
1.	Launch the App and Continue
2.	Enter Email 
3.  Enter Password
4.  Go to Account Details Page
5.  Validate the Email 
6.  Log Outsubmit button

Result: Passed

Test case 5: loginWithInvalidEmail
Data: {hardcoded invalid email id and password data}
1.	Launch the App and Continue
2.	Enter Email 
3.  Validate the expected email error alert message

Result: Passed

Test case 6: loginWithInvalidPassword
Data: {hardcoded valid email id and invalid password data}
1.	Launch the App and Continue
2.	Enter Email 
3.  Enter Password
4.  Validate the expected password error alert message

Result: Passed


## Framework Requirements
* Java Development Kit
* Maven
* Selenium 4.3.0
* Appium Java-Client 8.1.1
* org.testng 7.6.1
* allure-testng 2.14.0






## Automation Framework Structure

```
LiSTNRProject
	src.main.java
		Driver
      		Factory
      		Utilities	
	src.test.java
		Android
			TestDefinitions.java
			Tests.java
		mobile
			TestDefinitions.java
			Tests.java
	src.test.resources
		LiSTNR.apk
    		LiSTNR.ipa
	mobile.properties
  	android.properties
  	project.properties
	allure-results
	test-output
		testNG Reports
	pom.xml
	TestNG.xml
		
```




## Test Results
* Test report automatically generated on test-output, allure-results folder after finished the test execution
* Allure Report generation
* * <--run through command line: under project path-->
* * allure serve allure-results 


* TestNG Default Reports
* * /test-output/emailable-report.html


## Screenshots:
/Screenshots folder - all screens are captured for evidence purposes

Feature File: All 12 Test Cases:

![Screen Shot 2022-08-05 at 5 44 35 am](https://user-images.githubusercontent.com/8833241/182939269-bb4b1a71-9d01-4f16-9be5-6a8e9afff566.png)


**Run time Allur report:**
Screen references for localhost and allure report generation
Sample Allure report with pass fail stats:
![Screen Shot 2022-08-04 at 4 40 03 pm](https://user-images.githubusercontent.com/8833241/182939718-a5ec8c66-e25a-47ad-883e-dc72d325ec43.png)
![Screen Shot 2022-08-04 at 4 40 14 pm](https://user-images.githubusercontent.com/8833241/182939734-4cacdc6b-e911-4b0f-af6c-580c5517a9e0.png)


**Command to generate Allure report**
cd directory
allure serve allure-results

Project Folder Structure Screen:

![Screen Shot 2022-08-05 at 5 44 35 am](https://user-images.githubusercontent.com/8833241/182940234-89dc0a1b-f556-4e40-af8c-afbd25fbae1f.png)


**TestNG Reports:**
http://localhost:63342/ListnrProject/test-output/emailable-report.html?_ijt=galphhcmsf0s9gnga0qhf9cgpm&_ij_reload=RELOAD_ON_SAVE

![Screen Shot 2022-08-04 at 4 37 54 pm](https://user-images.githubusercontent.com/8833241/182939963-07067ae7-0ae4-4ba5-8c97-0c59479eda11.png)



{
"platformName": "ios",
"appium:udid": "00008101-000144661EF0001E",
"appium:platformVersion": "17.5",
"appium:xcodeOrgId": "purwar389@gmail.com",
"appium:xcodeSigningId": "iPhone Developer",
"appium:autoAcceptAlerts": true,
"appium:deviceName": "Gaurav iPhone (17.5.1)",
"appium:automationName": "XCuiTest",
"appium:app": "/Users/gaurav_purwar/Documents/Vrize/MobileAutomationBS/src/test/resources/apps/LiSTNR.ipa",
"appium:wdaLaunchTimeout": 50000,
"appium:autoGrantPermissions": true
}

{
"platformName": "Android",
"appium:deviceName": "emulator-5554",
"appium:app": "/Users/gaurav_purwar/Documents/Vrize/MobileAutomationBS/src/test/resources/apps/LiSTNR.apk",
"appium:ensureWebviewsHavePages": true,
"appium:nativeWebScreenshot": true,
"appium:newCommandTimeout": 3600,
"appium:automationName": "UiAutomator2",
"appium:connectHardwareKeyboard": true,
"appium:appPackage": "au.com.podcastoneaustralia",
"appium:appActivity": "au.com.podcastoneaustralia.ui.splash.SplashActivity",
"appium:uiautomator2ServerLaunchTimeout": 60000
}


{
"platformName": "Android",
"appium:deviceName": "emulator-5554",
"browserName": "Chrome",
"appium:automationName": "UiAutomator2",
"appium:chromedriverExecutable": "/Users/gauravpurwar/Documents/GEP-Automation-Suite-Mobile/src/test/resources/executables/chromedriver"
}



{
"platformName": "ios",
"appium:udid": "52A47ACD-6FF0-4153-998E-FDCF51E1CB5C",
"appium:platformVersion": "17.5",
"appium:xcodeOrgId": "purwar389@gmail.com",
"appium:xcodeSigningId": "iPhone Developer",
"appium:autoAcceptAlerts": true,
"appium:deviceName": "iPhone 15 Pro Max Simulator",
"browserName": "safari",
"appium:automationName": "XCuiTest"
}
