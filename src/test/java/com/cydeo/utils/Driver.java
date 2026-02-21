package com.cydeo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if( driver == null){

            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType){
                case "chrome":
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

            }
        }

        return driver;
    }
}

