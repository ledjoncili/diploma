package qa.steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import qa.driver.Driver;
import qa.driver.LocatorType;
import qa.page.ShoppingCartPage;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartSteps {
    private final ShoppingCartPage shoppingCartPage;

    public ShoppingCartSteps() {
        shoppingCartPage = new ShoppingCartPage();
    }

    @Then("^make sure the following products are shown in cart$")
    public void checkProductsInCart(DataTable dataTable) {
        By tableRowBy = By.cssSelector("#tbodyid tr");
        List<String> expectedList = dataTable.asList(String.class);
        Driver.getWait().until(ExpectedConditions.numberOfElementsToBe(tableRowBy, expectedList.size()));
        List<String> actualList = Driver.getDriver().findElements(tableRowBy).stream().map(WebElement::getText).collect(Collectors.toList());

        Assert.assertEquals(expectedList, actualList);
    }


    @Then("^click '(.+?)' button from cart page$")
    public void clickPlaceOrderButtonFromCartPage(String buttonName) {
        shoppingCartPage.clickButton(buttonName);
    }

    @Then("^make sure the following items are shown in the shopping cart$")
    public void makeSureTheFollowingItemsAreShownInTheShoppingCart(DataTable dataTable) {
        List<String> products = dataTable.asList(String.class);
        Assert.assertEquals(products.size(), Driver.getElements(".cart_item", LocatorType.CSS).size());

        Assert.assertEquals(Driver.getElements(".cart_item .inventory_item_name", LocatorType.CSS).stream().map(WebElement::getText).collect(Collectors.toList()), products);
    }

    @Then("^remove '(.+?)' from shopping cart$")
    public void removeSauceLabsBikeLightFromShoppingCart(String productName) {
        String xPath = "//div[@class='inventory_item_name' and text()='" + productName + "']/parent::*/following-sibling::*[2]//button";
        Driver.getElement(xPath, LocatorType.XPATH).click();

        Assert.assertEquals(0, Driver.getElements(".cart_item", LocatorType.CSS).size());
    }
}
