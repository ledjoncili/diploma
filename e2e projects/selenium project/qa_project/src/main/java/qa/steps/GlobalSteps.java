package qa.steps;

import cucumber.api.java.en.Then;
import org.testng.Assert;
import qa.driver.Driver;

public class GlobalSteps {

    @Then("^make sure user navigates to (.+?) page$")
    public void makeSureUserNavigatesToProductsPage(String page) {
        String expectedUrlEnding;

        if (page.equals("products")) {
            expectedUrlEnding = "/inventory.html";
        } else if (page.equals("login")) {
            expectedUrlEnding = "https://www.saucedemo.com/";
        } else {
            expectedUrlEnding = "unknown";
        }

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith(expectedUrlEnding));

    }
}
