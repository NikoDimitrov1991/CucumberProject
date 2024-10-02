package utils;

import pageObjects.PageObjectManager;


public class TestContextSetup {
    public TestBase testBase;
    public String landingPageProductName;
    public PageObjectManager pageObjectManager;
    public GenericUtils genericUtils;


    public TestContextSetup() {
     testBase = new TestBase();
     pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
     genericUtils = new GenericUtils(testBase.WebDriverManager());
    }
}
