package com.nikita.wiki.wiki.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helperbase {
    AppiumDriver driver;
    WebDriverWait wait;

    public Helperbase(AppiumDriver driver) {
        this.driver = driver;
    }


    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void type(By locator, String text){
        if (text != null) {
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void waitForElementAndTap(By locator, int timeOut){
       wait = new WebDriverWait(driver, timeOut);
       wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void hideKeyBoard(){
        driver.hideKeyboard();
    }

    public void swipeUp() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int stopY = (int) (size.height * 0.2);

        action.longPress(PointOption.point(x, startY))
                .moveTo(PointOption.point(x, stopY))
                .release()
                .perform();
    }


}
