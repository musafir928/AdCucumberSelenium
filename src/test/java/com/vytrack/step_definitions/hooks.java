package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class hooks {

    @Before
    public void start(){
        System.out.println("\tthis is the START");
    }

    @Before("@navigation") // custom hooks related with tags in scenario
    public void startNav(){
        System.out.println("\tthis is the START of Nav");
    }

    @After
    public void down(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenShot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "failed scenario");
        }
        Driver.closeDriver();
    }
}
