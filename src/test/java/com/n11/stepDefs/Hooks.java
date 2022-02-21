package com.n11.stepDefs;

import com.n11.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before("not @api")
    public void setUp(){
//        Driver.getDriver().manage().window().setPosition(new Point(990,0));
        Driver.getDriver().manage().window().maximize();
    }

    @After("not @api")
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
//        Driver.quitDriver();
    }



}
