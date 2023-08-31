package test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
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
    public void setUpClass(ITestContext context) {
        Driver.start(DriverOption.FIREFOX);
        super.setUpClass(context);
    }

    @AfterClass(alwaysRun = true)
    @Override
    public void tearDownClass() {
        Driver.quit();
        super.tearDownClass();
    }
}
