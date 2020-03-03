package com.nikita.wiki.wiki.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private AppiumDriver driver;
    ArticleHelper articleHelper;
    Helperbase helperbase;
    SessionHelper sessionHelper;



    public void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "qa22home");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/sh_ni/Documents/GitHub/Wiki_mob_qa22/src/test/resources/apk/org.wikipedia.apk");
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        helperbase = new Helperbase(driver);
        articleHelper = new ArticleHelper(driver);
        sessionHelper = new SessionHelper(driver);
    }

    public void stop() throws InterruptedException {
        getHelperbase().pause(5000);
        driver.quit();
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public Helperbase getHelperbase() {
        return helperbase;
    }

    public ArticleHelper getArticleHelper() {
        return articleHelper;
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}
