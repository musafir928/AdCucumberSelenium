package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class nav {
    @When("the user navigates to {string} {string}")
    public void theUserNavigatesTo(String tab, String item) {
        new DashboardPage().navigateToModule(tab, item);
    }

    @Then("default page number should be {int}")
    public void defaultPageNumberShouldBe(Integer number) throws InterruptedException {
        System.out.println("me here!!!!!!!");
        Thread.sleep(4000);
        ContactsPage contactsPage = new ContactsPage();
        Integer actualNumber = Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));
        Assert.assertEquals(number, actualNumber);
    }
}
