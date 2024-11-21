package StepDefinitions;

import CommonClasses.DriverManager;
import POM.LoginPage;
import POM.MarketPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginSteps {
    LoginPage login;

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @Given("user is on login")
    public void user_is_on_login() {
        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver and set implicit wait
//        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://localhost:5173/signIn");

        // Initialize loginPage object using Page Factory
        login = new LoginPage(driver);
    }

    @When("user enter valid {string} and {string}")
    public void user_enter_valid_email_and_pw(String email, String password) {
        // Enter email and password
        login.enterEmail(email);
        login.enterPassword(password);
    }

    @Then("clicks on Login Button")
    public void clicks_on_login_button() {
        // Click the login button
        login.clickLoginButton();
    }

    @And("user is navigate to market page")
    public void user_is_navigate_to_market_page() {
        // Assert that the market page is loaded by checking the label
        MarketPage marketLoad = new MarketPage(driver);
        marketLoad.is_load_market_page();
    }
}
