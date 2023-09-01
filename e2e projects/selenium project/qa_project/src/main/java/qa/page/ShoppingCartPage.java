package qa.page;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.driver.Driver;

/**
 * Shopping cart page
 */
public class ShoppingCartPage extends Page {

    @FindBy(id = "continue-shopping")
    public static WebElement continueShopping;

    @FindBy(id = "checkout")
    public static WebElement checkoutButton;

    public void clickButton(String buttonName) {
        WebElement webElement;
        if (buttonName.equals("Continue Shopping")) {
            webElement = continueShopping;
        } else if (buttonName.equals("Checkout")) {
            webElement = checkoutButton;
        } else throw new NotFoundException(buttonName + " button not found!");

        Driver.getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }
}
