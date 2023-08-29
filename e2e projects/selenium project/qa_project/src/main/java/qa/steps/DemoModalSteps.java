package qa.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.driver.Driver;
import qa.page.DemoModalPage;

public class DemoModalSteps {
    private final DemoModalPage demoModalPage;

    public DemoModalSteps() {
        demoModalPage = new DemoModalPage();
    }

    @Then("^we type '(.+?)' in the '(.+?)' input field$")
    public void navigateToHomePage(String text, String inputField) {
        demoModalPage.typeInTheInputField(text, inputField);
    }

    @And("^we click '(.+?)' button from modal$")
    public void clickModalButton(String buttonName) {
        demoModalPage.clickModalButton(buttonName);
    }

    @Then("^order is successfully placed and the following message is shown$")
    public void checkOrderMessage(DataTable dataTable) {
        Driver.getWait().until(ExpectedConditions.textToBe(By.cssSelector(".showSweetAlert h2"), dataTable.raw().get(0).get(0)));
    }
}