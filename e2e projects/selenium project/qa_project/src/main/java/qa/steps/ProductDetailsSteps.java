package qa.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import qa.driver.Driver;
import qa.driver.LocatorType;
import qa.page.ProductDetailsPage;

public class ProductDetailsSteps {
    private final ProductDetailsPage productDetailsPage;

    public ProductDetailsSteps() {
        productDetailsPage = new ProductDetailsPage();
    }

    @Then("^make sure the following details are shown$")
    public void makeSureTheFollowingDetailsAreShown(DataTable dataTable) {
        Driver.getWait().until(ExpectedConditions.visibilityOf(ProductDetailsPage.productTitle));
        String expectedTitle = dataTable.raw().get(0).get(0);
        String expectedPrice = dataTable.raw().get(1).get(0);
        String expectedDescriptionHeader = dataTable.raw().get(2).get(0);
        String expectedDescriptionBody = dataTable.raw().get(3).get(0);


        Assert.assertEquals(ProductDetailsPage.productTitle.getText(), expectedTitle);
        Assert.assertEquals(ProductDetailsPage.productPrice.getText(), expectedPrice);
        Assert.assertEquals(ProductDetailsPage.productDescriptionHeader.getText(), expectedDescriptionHeader);
        Assert.assertEquals(ProductDetailsPage.productDescriptionBody.getText(), expectedDescriptionBody);
    }

    @And("^click '(.+?)' button from product details page$")
    public void clickButton(String buttonName) {
        productDetailsPage.clickButton(buttonName);
    }

    @Then("^make sure product '(.+?)' is '(.+?)'$")
    public void makeSureProductNameIsSauceLabsBackpack(String property, String expectedValue) {
        String cssSelector;

        switch (property) {
            case "name":
                cssSelector = ".inventory_details_name";
                break;
            case "details":
                cssSelector = ".inventory_details_desc";
                break;
            case "price":
                cssSelector = ".inventory_details_price";
                break;
            default:
                cssSelector = null;
        }

        if (cssSelector != null) {
            var actualText = Driver.getElement(cssSelector, LocatorType.CSS).getText();
            Assert.assertEquals(actualText, expectedValue);
        }

    }
}
