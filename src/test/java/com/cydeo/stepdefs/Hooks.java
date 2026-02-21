package com.cydeo.stepdefs;

import com.cydeo.utils.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.cydeo.utils.Driver.getDriver;

public class Hooks {
    //pre and post condition

    @Before
    public void setupMethod(){
        System.out.println("--------Before method is executed.");
    }

    @After
    public void tearDownMethod(Scenario scenario){

        byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());

        System.out.println("--------After method is executed.");
        getDriver().quit();
    }
    @BeforeStep
    public void setupStep(){
        System.out.println("--------Before step is executed. ---------");
    }
    @AfterStep
    public void tearDownStep(){
        System.out.println("--------After step is executed. ---------");
    }

}

