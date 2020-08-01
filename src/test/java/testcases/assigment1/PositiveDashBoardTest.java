package testcases.assigment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import objectRepository.assigment1.DashBoardPage;

import java.util.concurrent.TimeUnit;

import static variables.assigment1.UrlVariables.*;
import static variables.assigment1.UserVariables.*;

public class PositiveDashBoardTest {
    BrowserSetting bs = new BrowserSetting();
    WebDriver driver = bs.BrowserSettings();
    DashBoardPage dashBoardPage = new DashBoardPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @BeforeTest
    public void tearUp() {

        driver.get(BASE_URL);
        Reporter.log("URL Invoked.");
    }


    @Test(groups = "Positive")
    public void DashBoardTest(){
        clickBuynow(driver);
        clickCheckout(driver);
        clickContinueandCheckout(driver);
        paymentProcessing(driver);
        successfullMessage(driver);

    }

    private void clickBuynow(WebDriver driver) {
        dashBoardPage.buynowButton().click();
    }

	private void clickCheckout(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-checkout")));
		dashBoardPage.cartCheckOut().click();

	}
    private void clickContinueandCheckout(WebDriver driver){
        WebElement fr = driver.findElement(By.id("snap-midtrans"));
        driver.switchTo().frame(fr);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button-main-content")));
        dashBoardPage.continueButton().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Credit Card']")));
        dashBoardPage.creditCardPage().click();
        dashBoardPage.creditCardNumber().sendKeys(CARD_NUMBER);
        dashBoardPage.creditCardDate().sendKeys(EXPIRY_DATE);
        dashBoardPage.creditCardCvv().sendKeys(CVV);
        dashBoardPage.payNowButton().click();
    }

    private void paymentProcessing(WebDriver driver) {
        WebElement paymentFrame = driver.findElement(By.xpath("//iframe[contains(@src,'https://api.sandbox.veritrans.co.id/v2/token/rba/redirect/')]"));
        driver.switchTo().frame(paymentFrame);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.id("PaRes"))));
        dashBoardPage.enterPassword().sendKeys(BANK_OTP);
        dashBoardPage.okButton().click();

    }
    private void successfullMessage(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().defaultContent();
        String actual = dashBoardPage.successMessage().getText();
        Assert.assertEquals("Thank you for your purchase.\n" +
                "Get a nice sleep.",actual);

    }
     @AfterTest
    public void tearDown() {
         Reporter.log("shut Down the Browser");
         driver.close();
    }

}
