package com.cydeo.utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BrowserUtils {
    public static void sleep(int seconds){


        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }

    public static void switchtowindow(WebDriver driver, String expectedTitle, String expectedUrl){
        Set<String> handles = driver.getWindowHandles();


        for (String handle : handles) {

            driver.switchTo().window(handle);
            System.out.println("URL" + driver.getCurrentUrl());


            if (driver.getCurrentUrl().contains(expectedUrl)){
                break;
            }
        }

        String actualTitle = driver.getTitle();
        String expectedInTitle = expectedTitle;

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    public static void veryfyTitle(WebDriver driver, String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    public static void veryfyTitleContains(WebDriver driver, String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}

