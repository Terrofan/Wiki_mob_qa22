package com.nikita.wiki.wiki.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaveArticleTest extends TestBase{
    @Test
    public void testSaveArticle(){
        String textExample = "tel aviv";
        int numberOfSavedArticlesInListBefore;
        int numberOfSavedArticlesInListAfter;

        appMan.getSessionHelper().skipWelcomePageIfPresents();
        appMan.getArticleHelper().goToMyListsTab();

        numberOfSavedArticlesInListBefore = appMan.getArticleHelper().getCountOfSavedArticlesInDefaultList();

        appMan.getArticleHelper().backToExploreTab();
        appMan.getArticleHelper().initSearchArticle();
        appMan.getArticleHelper().typeRequest(textExample);
        appMan.getArticleHelper().selectArticle();
        appMan.getArticleHelper().clickBookMarkButtonFromArticle();
        appMan.getArticleHelper().skipAddArticlesToListMessage();
        appMan.getArticleHelper().selectSaveToDefaultList();
        appMan.getArticleHelper().clickBackButton();
        appMan.getSessionHelper().skipSyncReadingListsWindow();
        appMan.getArticleHelper().goToMyListsTab();

        numberOfSavedArticlesInListAfter = appMan.getArticleHelper().getCountOfSavedArticlesInDefaultList();

        Assert.assertEquals(numberOfSavedArticlesInListAfter, numberOfSavedArticlesInListBefore + 1);
        appMan.getArticleHelper().selectSavedList();
    }
}
