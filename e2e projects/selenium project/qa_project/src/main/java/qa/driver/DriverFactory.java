package qa.driver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverFactory {

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String GECKO_DRIVER = "webdriver.gecko.driver";
    private static final String CHROME = "src/main/resources/driver/macos/chromedriver";
    private static final String FIREFOX = "src/main/resources/driver/macos/geckodriver";

    public static WebDriver getDriver(final DriverOption driverOption){
        switch (driverOption){
            case CHROME:
                initChrome();
                ChromeDriverService service = new ChromeDriverService.Builder()
                    .withLogFile(new File("src/target/"))
                    .build();
                return new ChromeDriver(service);
            case FIREFOX:
                initFirefox();
                return new FirefoxDriver();
            case IE:
                return new InternetExplorerDriver();
            default:
                return new ChromeDriver();
        }
    }

    private static void initChrome(){
        System.setProperty(CHROME_DRIVER, CHROME);
    }

    private static void initFirefox(){
        System.setProperty(GECKO_DRIVER, FIREFOX);
    }
}
