package qa.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import qa.driver.Driver;
import qa.driver.LocatorType;
import qa.page.CheckoutPage;

public class CheckoutSteps {

    private final CheckoutPage checkoutPage;

    public CheckoutSteps() {
        checkoutPage = new CheckoutPage();
    }

    @And("click {string} button from checkout page")
    public void clickCancelButtonFromCheckoutPage(String buttonName) {
        checkoutPage.clickButton(buttonName);
    }

    @And("type {string} in {string} input field")
    public void typeInZipPostalCodeInputField(String text, String inputField) {
        WebElement input = Driver.getElement("input[placeholder='" + inputField + "']", LocatorType.CSS);
        input.sendKeys(text);

        Assert.assertEquals(input.getAttribute("value"), text);
    }

    @And("check the following message is shown")
    public void checkTheFollowingMessageIsShown(DataTable dataTable) {
        Assert.assertEquals(Driver.getElement(".complete-header", LocatorType.CSS).getText(), "Thank you for your order!");
    }
}
