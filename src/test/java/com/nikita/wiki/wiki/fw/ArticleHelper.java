package com.nikita.wiki.wiki.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

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

    public boolean isThereResult() {
        return isElementPresent(By.id("page_list_item_container"));
    }
}
