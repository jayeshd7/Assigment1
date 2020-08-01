package testcases.assigment1;

import objectRepository.assigment1.DashBoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static variables.assigment1.UrlVariables.BASE_URL;
import static variables.assigment1.UserVariables.*;

public class NegativeDashBoardTest {
    BrowserSetting bs = new BrowserSetting();
    WebDriver driver = bs.BrowserSettings();
    DashBoardPage dashBoardPage = new DashBoardPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @BeforeTest
    public void tearUp() {
        driver.get(BASE_URL);
    }


    @Test(priority = 2)
    public void DashBoardTest() {
        clickBuynow(driver);
        clickCheckout(driver);
        clickContinueandCheckout(driver);
        invalidCardNumber(driver);


    }

    private void clickBuynow(WebDriver driver) {
        dashBoardPage.buynowButton().click();
    }

    private void clickCheckout(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-checkout")));
        dashBoardPage.cartCheckOut().click();

    }

    private void clickContinueandCheckout(WebDriver driver) {
        WebElement fr = driver.findElement(By.id("snap-midtrans"));
        driver.switchTo().frame(fr);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button-main-content")));
        dashBoardPage.continueButton().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Credit Card']")));
        dashBoardPage.creditCardPage().click();
        dashBoardPage.creditCardNumber().sendKeys(InVALID_CARD_NUMBER);

    }

    private void invalidCardNumber(WebDriver driver) {

        WebElement invalidCardNumberMessage = driver.findElement(By.xpath("//span[.='Invalid card number']"));
        System.out.println(invalidCardNumberMessage.getText());

    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

}
