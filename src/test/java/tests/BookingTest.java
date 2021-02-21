package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        glue = "steps",
        tags = " @run",  // mvn clean test -Dcucumber.filter.tags="@run"
        plugin = { "pretty", "html:target/cucumber.html",
                "json:target/cucumber.json"}
)

public class BookingTest extends AbstractTestNGCucumberTests {
}
