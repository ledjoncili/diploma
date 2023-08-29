package test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import qa.driver.Driver;
import qa.driver.DriverOption;

@CucumberOptions(
        features = "src/test/java/feature",
        glue = "qa.steps",
        tags = "@Demo"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    @Override
    public void setUpClass() throws Exception {
        Driver.start(DriverOption.CHROME);
        super.setUpClass();
    }

    @AfterClass(alwaysRun = true)
    @Override
    public void tearDownClass() throws Exception {
        Driver.quit();
        super.tearDownClass();
    }
}
