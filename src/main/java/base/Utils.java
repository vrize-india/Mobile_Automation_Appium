package base;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.appium.java_client.*;

public class Utils {

    private final WebDriver driver;

    public Utils() {
        this.driver = AppDriver.getDriver(); // Store the driver instance
    }

    public void waitForEl(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForEl(WebElement ele) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ele));
    }

    public void clickElement(By locator, String val) {
        waitForEl(locator);
        driver.findElement(locator).click();
        System.out.println(val + " button is clicked!");
    }

    public void enterVal(By locator, String fieldName, String val) {
        waitForEl(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(val);
        System.out.println(fieldName + " Field is entered with value " + val + "");
    }

    public void clickElement(WebElement ele, String val) {
        waitForEl(ele);
        ele.click();
        System.out.println(ele + " button is clicked!");
    }

    public void enterVal(WebElement ele, String fieldName, String val) {
        waitForEl(ele);
        ele.sendKeys(val);
        System.out.println(fieldName + " Field is entered with value " + val + "");
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
