package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page(){
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }
    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @Then("the user should be able to login")
    public void theUserShouldBeAbleToLogin() {
        Assert.assertEquals("Dashboards", Driver.get().getTitle());
    }

    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_information() {
        System.out.println("I'm on login page");
    }
}
