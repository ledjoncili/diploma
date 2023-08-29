package qa.page;

import org.openqa.selenium.support.PageFactory;
import qa.driver.Driver;

public class Page {
    public Page() {
        PageFactory.initElements((Driver.getDriver()), this);
    }
}
