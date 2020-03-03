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

    public void selectArticle() {
        tap(By.xpath("//android.widget.TextView[@text='Tel Aviv']"));
    }

    public void clickBookMarkButtonFromArticle() {
        tap(By.id("org.wikipedia:id/article_menu_bookmark"));
    }

    public void skipAddArticlesToListMessage() {
        if(isElementPresent(By.id("org.wikipedia:id/onboarding_button"))){
            tap(By.id("org.wikipedia:id/onboarding_button"));
        }
    }

    public void selectSavedList() {
        tap(By.id("org.wikipedia:id/reading_list_list"));
    }

    public void goToMyListsTab() {
        tap(By.xpath("//*[@content-desc='My lists']"));
    }

    public void clickBackButton() {
        tap(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
    }

    public void selectSaveToDefaultList() {
        tap(By.id("org.wikipedia:id/list_of_lists"));
    }

    public int getCountOfSavedArticlesInDefaultList() {
        String listStatDesc = driver.findElement(By.id("org.wikipedia:id/item_reading_list_statistical_description")).getText();
        int savedArticlesInList = Integer.parseInt(listStatDesc.split(" ")[0]);
        return savedArticlesInList;
    }

    public void backToExploreTab() {
        tap(By.xpath("//*[@content-desc='Explore']"));
    }
}
