package qa.driver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Driver {

    private static WebDriver webDriver;

    private static WebDriverWait wait;

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void start(final DriverOption driverOption) {
        webDriver = DriverFactory.getDriver(driverOption);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public static void quit() {
        webDriver.quit();
    }

    public static void close() {
        webDriver.close();
    }

    public static void go(final String url) {
        webDriver.get(url);
    }


    public static WebElement getElement(final String identifier, final LocatorType locator) {
        switch (locator) {
            case ID:
                return webDriver.findElement(By.id(identifier));
            case XPATH:
                return webDriver.findElement(By.xpath(identifier));
            case CSS:
                return webDriver.findElement(By.cssSelector(identifier));
            case NAME:
                return webDriver.findElement(By.name(identifier));
            case LINK_TEXT:
                return webDriver.findElement(By.linkText(identifier));
            case CLASS:
                return webDriver.findElement(By.className(identifier));
            default:
                return webDriver.findElement(By.xpath(identifier));
        }
    }


    public static List<WebElement> getElements(final String identifier, final LocatorType locator) {
        switch (locator) {
            case ID:
                return webDriver.findElements(By.id(identifier));
            case XPATH:
                return webDriver.findElements(By.xpath(identifier));
            case CSS:
                return webDriver.findElements(By.cssSelector(identifier));
            case NAME:
                return webDriver.findElements(By.name(identifier));
            case LINK_TEXT:
                return webDriver.findElements(By.linkText(identifier));
            case CLASS:
                return webDriver.findElements(By.className(identifier));
            default:
                return webDriver.findElements(By.xpath(identifier));
        }
    }

    public static String getTitle() {
        return webDriver.getTitle();
    }

    public static String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public static String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        return webDriver.switchTo().alert().getText();
    }

    public static void acceptAlert() {
        webDriver.switchTo().alert().accept();
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
    }

}
