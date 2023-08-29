package qa.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import qa.driver.Driver;
import qa.driver.LocatorType;
import qa.global.GlobalVariables;
import qa.page.HomePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeSteps {
    private final HomePage homePage;

    public HomeSteps() {
        homePage = new HomePage();
    }

    @Given("^the homepage is opened$")
    public void navigateToHomePage() {
        Driver.go(GlobalVariables.DEMO_APP_URL);
    }

    @And("^click '(.+?)' button$")
    public void clickButton(String buttonName) {
        homePage.clickButton(buttonName);
    }

    @Then("^user '(.+?)' is successfully logged in$")
    public void userIsSuccessfullyLoggedIn(String username) {
        Driver.getWait().until(ExpectedConditions.textToBe(By.id(HomePage.USERNAME_ID), "Welcome " + username));
    }

    @Then("^we click '(.+?)' from product catalog$")
    public void clickProductFromCatalog(String productName) {
        By productBy = By.xpath("//h4[@class='card-title']/a[text()='" + productName + "']");
        Driver.getDriver().findElement(productBy).click();
    }

    @Then("^make sure an error message with the following text is shown$")
    public void checkErrorMessage(DataTable dataTable) {
        Assert.assertEquals(homePage.getErrorMessage(), dataTable.raw().get(0).get(0));
    }

    @Then("^click product with name '(.+?)'$")
    public void clickProductWithName(String productName) {
        String xPath = "//div[@class='inventory_item_name'][text()='" + productName + "']";
        Driver.getElement(xPath, LocatorType.XPATH).click();
        Assert.assertTrue(Driver.getCurrentUrl().endsWith("inventory-item.html?id=4"));
    }

    @And("^select '(.+?)' from filter dropdown$")
    public void selectOptionFromFilters(String option) {
        // Locate the dropdown element
        var dropdownElement = Driver.getElement(".product_sort_container", LocatorType.CSS);

        // Create a Select object from the dropdown element
        Select dropdownSelect = new Select(dropdownElement);

        // Select "Price (low to high)" option by value
        dropdownSelect.selectByVisibleText(option);

        // Get the selected option's value
        WebElement selectedOption = Driver.getElement(".active_option", LocatorType.CSS);
        String selectedValue = selectedOption.getText();

        // Check if the selected value is as expected
        Assert.assertEquals(selectedValue, option);
    }

    @Then("^make sure the products are sorted by '(.+?)'$")
    public void checkProductsSorting(String selectedOption) {
        List<WebElement> priceElements = Driver.getElements(".inventory_item_price", LocatorType.CSS);
        List<Float> prices = new ArrayList<>();

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "");
            float price = Float.parseFloat(priceText);
            prices.add(price);
        }

        List<Float> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        // Compare the prices with the sorted prices
        Assert.assertEquals(prices, sortedPrices);
    }

    @And("^Add to Cart product '(.+?)'$")
    public void addProductToCart(String productName) {
        String btnId = "add-to-cart-" + productName.toLowerCase().replace(" ", "-");
        WebElement element = Driver.getElement(btnId, LocatorType.ID);
        element.click();

        Assert.assertThrows(StaleElementReferenceException.class, element::isDisplayed);
        Assert.assertTrue(Driver.getElement(btnId.replace("add-to-cart", "remove"), LocatorType.ID).isDisplayed());

    }

    @Then("^shopping cart number is '(.+?)'$")
    public void shoppingCartNumberIs(String quantity) {
        WebElement quantityEl = Driver.getElement(".shopping_cart_badge", LocatorType.CSS);
        Assert.assertEquals(quantityEl.getText(), quantity);
    }
}
