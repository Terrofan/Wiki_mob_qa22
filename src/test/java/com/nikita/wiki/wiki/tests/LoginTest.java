package com.nikita.wiki.wiki.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void logInTest() {
        appMan.getSessionHelper().skipWelcomePageIfPresents();
        appMan.getSessionHelper().clickOnMenuButton();
        appMan.getSessionHelper().clickOnLogInButton();
        appMan.getSessionHelper().fillLoginForm("Terrofan", "5457den5457");
        appMan.getSessionHelper().confirmLogIn();
        appMan.getSessionHelper().skipTurnOnReadingSync();
        Assert.assertTrue(appMan.getSessionHelper().isAvatarIconPresent());
    }
}
