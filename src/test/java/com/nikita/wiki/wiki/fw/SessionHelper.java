package com.nikita.wiki.wiki.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SessionHelper extends Helperbase {
    public SessionHelper(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnMenuButton() {
        tap(By.id("org.wikipedia:id/drawer_icon_menu"));
    }

    public void clickOnLogInButton() {
        tap(By.id("org.wikipedia:id/main_drawer_login_button"));
    }

    public void fillLoginForm(String userName, String password) {
        type(By.xpath("//android.widget.EditText[@password='false']"),userName);
        type(By.xpath("//android.widget.EditText[@password='true']"), password);
        driver.hideKeyboard();
    }


    public void confirmLogIn() {
        tap(By.id("org.wikipedia:id/login_button"));
    }

    public boolean isAvatarIconPresent() {
        clickOnMenuButton();
        return isElementPresent(By.id("org.wikipedia:id/main_drawer_account_avatar"));
    }

    public void skipWelcomePageIfPresents() {
        if (isElementPresent(By.id("org.wikipedia:id/fragment_onboarding_skip_button"))) {
            tap(By.id("org.wikipedia:id/fragment_onboarding_skip_button"));
        }
    }

    public void skipSyncReadingListsWindow() {
        tap(By.id("android:id/button2"));
    }
}
