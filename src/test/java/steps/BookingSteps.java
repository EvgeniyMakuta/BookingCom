package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BookingSteps {
    String city;
    String RATING_LOCATOR = "//*[contains(text(), '%s')][contains(@class, 'sr-hotel__name')]/ancestor::*[contains(@class, 'sr_item_content')]" +
            "//*[@class='bui-review-score__badge']";

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

    @Given("User is looking for {string} city")
    public void userIsLookingForCity(String city) {
        this.city = city;
    }

    @When("User does search")
    public void userDoesSearch() {
        Configuration.clickViaJs = true;
        open("https://www.booking.com/");
        $(By.id("ss")).sendKeys(city);
        $(".sb-searchbox__button").click();
    }

    @Then("Hotel {string} should be on the first page")
    public void hotelShouldBeOnTheFirstPage(String hotel) {
        assertThat($$(".sr-hotel__name").texts(), hasItem(hotel));
    }

    @And("Rating of the hotel {string} is {string}")
    public void ratingOfTheHotelIs(String expectedHotel, String expectedRating) {
        String actualRating = $(By.xpath(String.format(RATING_LOCATOR, expectedHotel))).getText();
        assertEquals(expectedRating, actualRating);
    }
}
