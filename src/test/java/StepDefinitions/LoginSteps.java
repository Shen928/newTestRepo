package StepDefinitions;

import BaseClasses.Base;
import CommonClasses.DriverManager;
import POM.LoginPage;
import POM.MarketPage;
import com.aventstack.extentreports.Status;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class LoginSteps extends Base {
    LoginPage login;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
       //test = extent.createTest("Login Test"); // Start a test case
    }

    @Given("user is on login")
    public void user_is_on_login() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://localhost:5173/signIn");

        login = new LoginPage(driver);
        logReport("Spot Limit Feature", Status.INFO, "clicks on Login Button", false);
    }

    @When("user enter valid {string} and {string}")
    public void user_enter_valid_email_and_pw(String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);

    }

    @Then("clicks on Login Button")
    public void clicks_on_login_button() {
        login.clickLoginButton();
        logReport("Spot Limit Feature", Status.PASS, "clicks on Login Button", false);
    }

    @And("user is navigate to market page")
    public void user_is_navigate_to_market_page() {
        MarketPage marketLoad = new MarketPage(driver);

        if (marketLoad.is_load_market_page()) {
//            hardPause(2);
            logReport("Spot Limit Feature", Status.PASS, "User navigated to login page", true);
            logReport("Spot Limit Cancelled Feature", Status.PASS, "User navigated to login page", true);
        } else {
            logReport("Spot Limit Feature", Status.PASS, "User failed to navigate login page", true);
            logReport("Spot Limit Cancelled Feature", Status.PASS, "User failed to navigate login page", true);
        }
    }
}