package com.nikita.wiki.wiki.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticleHelper extends Helperbase{

    public ArticleHelper(AppiumDriver driver) {
        super(driver);
    }

    public void initSearchArticle() {
        tap(By.id("search_container"));

    }

    public void typeRequest(String text){
        type(By.id("search_src_text"), text);

    }

    public boolean isThereResult(int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.id("org.wikipedia:id/search_results_list")));
        return isElementPresent(By.id("org.wikipedia:id/search_results_list"));
    }

    public void swipeArticlesUp() {
        hideKeyBoard();
        swipeUp();
    }
}
