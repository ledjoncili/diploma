package qa.page;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.driver.Driver;

/**
 * Login in page
 */
public class LoginPage extends Page{

    @FindBy(id = "user-name")
    public WebElement usernameInputField;

    @FindBy(id = "password")
    public WebElement passwordInputField;

    @FindBy(css = "#signInModal button.btn.btn-primary")
    public WebElement signUpButton;

    @FindBy(css = ".show button.btn-primary")
    public WebElement logInButton;

    @FindBy(css = ".show button.btn-primary")
    public WebElement purchaseButton;

    @FindBy(id = "name")
    public WebElement nameInputField;

    @FindBy(id = "country")
    public WebElement countryInputField;

    @FindBy(id = "city")
    public WebElement cityInputField;

    @FindBy(id = "card")
    public WebElement cardInputField;

    @FindBy(id = "month")
    public WebElement monthInputField;

    @FindBy(id = "year")
    public WebElement yearInputField;


    public void typeInTheInputField(String text, String inputField) {
        switch (inputField) {
            case "Username":
                usernameInputField.sendKeys(text);
                break;
            case "Password":
                passwordInputField.sendKeys(text);
                break;
            case "Name":
                nameInputField.sendKeys(text);
                break;
            case "Country":
                countryInputField.sendKeys(text);
                break;
            case "City":
                cityInputField.sendKeys(text);
                break;
            case "Credit card":
                cardInputField.sendKeys(text);
                break;
            case "Month":
                monthInputField.sendKeys(text);
                break;
            case "Year":
                yearInputField.sendKeys(text);
                break;
            default:
                throw new NotFoundException(inputField + " Input field not found!");
        }
    }

    public void clickModalButton(String buttonName) {
        WebElement webElement;
        switch (buttonName) {
            case "Sign up":
                webElement = signUpButton;
                break;
            case "Log in":
                webElement = logInButton;
                break;
            case "Purchase":
                webElement = purchaseButton;
                break;
            default:
                throw new NotFoundException(buttonName + " button not found!");
        }

        Driver.getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }
}
