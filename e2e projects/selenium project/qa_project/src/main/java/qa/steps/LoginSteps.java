package qa.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.driver.Driver;
import qa.page.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Then("^we type '(.+?)' in the '(.+?)' input field$")
    public void navigateToHomePage(String text, String inputField) {
        loginPage.typeInTheInputField(text, inputField);
    }

    @And("^we click '(.+?)' button from modal$")
    public void clickModalButton(String buttonName) {
        loginPage.clickModalButton(buttonName);
    }

    @Then("^order is successfully placed and the following message is shown$")
    public void checkOrderMessage(DataTable dataTable) {
        Driver.getWait().until(ExpectedConditions.textToBe(By.cssSelector(".showSweetAlert h2"), dataTable.cells().get(0).get(0)));
    }
}
