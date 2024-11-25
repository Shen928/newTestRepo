package POM;

import io.cucumber.java.en.But;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SpotPage {

    private WebDriver driver;

//    @Before
//    public void setUp() {
//        driver = DriverManager.getDriver();
//    }

    public SpotPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "limit-order-button")
    WebElement orderType;

    @FindBy(id = "sell-price")
    WebElement sellPriceInput;

    @FindBy(id = "sell-quantity")
    WebElement sellQuantityInput;

    @FindBy(id = "sell-btn")
    WebElement submitSellButton;

    @FindBy(id = "success-message")
    WebElement successMessage;

    @FindBy(id="info-notification")
    WebElement infoNotification;

    @FindBy(css = "[data-test='cancel-all-btn']")
    WebElement cancelAllButton;



    // Locate all order id rows
    @FindBy(css = "[data-test='openOrderId']")
    List<WebElement> openOrderIds;


    @FindBy(id = "buy-price")
    WebElement buyPriceInput;

    @FindBy(id = "buy-quantity")
    WebElement buyQuantityInput;

    @FindBy(id = "buy-btn")
    WebElement submitBuyButton;

    public void selectLimitOrderType() {
        orderType.click();
    }

    public void enterBuyPrice(String price) {
        buyPriceInput.clear();
        buyPriceInput.sendKeys(price);
    }

    public void enterBuyQuantity(String quantity) {
        buyQuantityInput.clear();
        buyQuantityInput.sendKeys(quantity);
    }

    public void enterSellPrice(String price) {
        sellPriceInput.clear();
        sellPriceInput.sendKeys(price);
    }

    public void enterSellQuantity(String quantity) {
        sellQuantityInput.clear();
        sellQuantityInput.sendKeys(quantity);
    }

    public void submitBuyOrder() {
        submitBuyButton.click();
    }

    public void submitSellOrder() {
        submitSellButton.click();
    }

    // Updated method to check if the success message is displayed with WebDriverWait
    public boolean isSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false; // Return false if the message does not appear within 3 seconds
        }
    }

    public String getSuccessMessageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }

    @FindBy(css = "[data-test='cancel-now']")
    WebElement cancelNowButton;

    public void clickCancelAllButton(){
        cancelAllButton.click();
        cancelNowButton.click();


    }

//    public void clickNotification(){
//        infoNotification.click();
//    }

    public boolean areAllOrdersCanceled() {
        return openOrderIds.isEmpty(); // Returns true if no open order IDs are found
    }

    public boolean isInfoNotificationDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        try {
            wait.until(ExpectedConditions.visibilityOf(infoNotification));
            return infoNotification.isDisplayed();
        } catch (Exception e) {
            return false; // Return false if the message does not appear within 3 seconds
        }
    }

    public String getInfoNotificationText() {
        return infoNotification.getText();
    }

}
