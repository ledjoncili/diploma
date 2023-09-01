package qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.driver.Driver;

public class GlobalSteps {

    @Then("^make sure user navigates to (.+?) page$")
    public void makeSureUserNavigatesToProductsPage(String page) {
        String expectedUrlEnding = switch (page) {
            case "products" -> "/inventory.html";
            case "login" -> "https://www.saucedemo.com/";
            case "checkout step 1" -> "/checkout-step-one.html";
            case "checkout step 2" -> "/checkout-step-two.html";
            case "checkout complete" -> "/checkout-complete.html";
            default -> "unknown";
        };

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith(expectedUrlEnding));

    }
}
