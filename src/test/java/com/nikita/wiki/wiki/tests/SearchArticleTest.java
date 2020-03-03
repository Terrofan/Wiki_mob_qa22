package com.nikita.wiki.wiki.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchArticleTest extends TestBase {

    @Test
    public void testSearchArticle(){
        appMan.getSessionHelper().skipWelcomePageIfPresents();
        appMan.getArticleHelper().initSearchArticle();
        appMan.getArticleHelper().typeRequest("Java");
        Assert.assertTrue(appMan.getArticleHelper().isThereResult(10));
        appMan.getArticleHelper().swipeArticlesUp();
    }
}
