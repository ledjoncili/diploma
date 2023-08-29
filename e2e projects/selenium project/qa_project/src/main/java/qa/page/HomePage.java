package qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.driver.Driver;

/**
 * Home page - list of products
 */
public class HomePage extends Page {

    public static final String USERNAME_ID = "nameofuser";

    @FindBy(id = "signin2")
    public WebElement signUpButton;

    @FindBy(id = "login-button")
    public WebElement logInButton;

    @FindBy(xpath = "//a[@class='nav-link'][text()='Home ']")
    public WebElement homeButton;

    @FindBy(xpath = "//a[@class='nav-link'][text()='Cart']")
    public WebElement cartButton;

    @FindBy(id = USERNAME_ID)
    public static WebElement userName;

    // --------------------------------

    @FindBy(css = "#react-burger-menu-btn")
    public WebElement navMenu;

    @FindBy(css = "#logout_sidebar_link")
    public WebElement logoutButton;

    @FindBy(className = "shopping_cart_link")
    public WebElement shoppingCart;

    public void clickButton(String buttonName) {
        WebElement webElement;
        switch (buttonName) {
            case "Sign up":
                webElement = signUpButton;
                break;
            case "Login":
                webElement = logInButton;
                break;
            case "Home":
                webElement = homeButton;
                break;
            case "Cart":
                webElement = cartButton;
                break;
            case "Menu":
                webElement = navMenu;
                break;
            case "Logout":
                webElement = logoutButton;
                break;
            case "Shopping Cart":
                webElement = shoppingCart;
                break;
            default:
                throw new NotFoundException("Make sure you provided the correct button name!");
        }

        Driver.getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public String getErrorMessage() {
        Driver.getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3[data-test='error']")));
        return Driver.getDriver().findElement(By.cssSelector("h3[data-test='error']")).getText();
    }
}
