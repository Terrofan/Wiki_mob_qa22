package com.nikita.wiki.wiki.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class Helperbase {
    AppiumDriver driver;

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

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void hideKeyBoard(){
        driver.hideKeyboard();
    }


}
