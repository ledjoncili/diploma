package qa.page;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.driver.Driver;

/**
 * Checkout page (step one and step two)
 */
public class CheckoutPage extends Page {
    @FindBy(id = "cancel")
    public static WebElement cancelButton;

    @FindBy(id = "continue")
    public static WebElement continueButton;

    @FindBy(id = "finish")
    public static WebElement finishButton;


    public void clickButton(String buttonName) {
        WebElement webElement = switch (buttonName) {
            case "Cancel" -> cancelButton;
            case "Continue" -> continueButton;
            case "Finish" -> finishButton;
            default -> throw new NotFoundException(buttonName + " button not found!");
        };

        Driver.getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }
}
