package qa.page;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.driver.Driver;

public class DemoCartPage extends Page {

    @FindBy(css = ".panel-title")
    public static WebElement price;

    @FindBy(css = "button.btn-success")
    public static WebElement placeOrderButton;


    public void clickButton(String buttonName) {
        WebElement webElement;
        if (buttonName.equals("Place Order")) {
            webElement = placeOrderButton;
        } else throw new NotFoundException(buttonName + " button not found!");

        Driver.getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }
}
