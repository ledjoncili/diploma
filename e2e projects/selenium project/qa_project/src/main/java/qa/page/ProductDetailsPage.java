package qa.page;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.driver.Driver;

/**
 * Product Details page
 */
public class ProductDetailsPage extends Page {

    @FindBy(css = ".btn-success")
    public static WebElement addToCartButton;

    @FindBy(css = ".name")
    public static WebElement productTitle;

    @FindBy(css = ".price-container")
    public static WebElement productPrice;

    @FindBy(css = "#more-information strong")
    public static WebElement productDescriptionHeader;

    @FindBy(css = "#more-information p")
    public static WebElement productDescriptionBody;

    @FindBy(css = ".inventory_details_back_button")
    public static WebElement backToProductsButon;

    public void clickButton(String buttonName) {
        WebElement webElement;
        if (buttonName.equals("Add to cart")) {
            webElement = addToCartButton;
        } else if (buttonName.equals("Back to products")) {
            webElement = backToProductsButon;
        } else throw new NotFoundException(buttonName + ": not fund in DemoProductDetailsPage");

        Driver.getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }
}
