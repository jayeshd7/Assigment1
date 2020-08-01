package objectRepository.assigment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashBoardPage {

    WebDriver driver;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = (".buy"))
    WebElement buynow;

    @FindBy(css = (".cart-checkout"))
	WebElement checkout;

    @FindBy(css = (".button-main-content"))
    WebElement continueButton;

    @FindBy(xpath = "//div[.='Credit Card']")
    WebElement CCPage;

    @FindBy(name = "cardnumber")
    WebElement CCNumber;

    @FindBy(css = "[placeholder='MM / YY']")
    WebElement CCDate;

    @FindBy(css = "[placeholder='123']")
    WebElement CCCvv;

    @FindBy(css = ".button-main-content")
    WebElement PayNow;

    @FindBy(id = "PaRes")
    WebElement password;

    @FindBy(name = "ok")
    WebElement okButton;

    @FindBy(css =".trans-status")
    WebElement success;

    public WebElement buynowButton() {
        return buynow;
    }

    public  WebElement cartCheckOut(){
    	return checkout;
	}

	public WebElement continueButton(){
        return continueButton;
    }

    public  WebElement creditCardPage(){
        return CCPage;
    }

    public  WebElement creditCardNumber(){
        return CCNumber;
    }
    public  WebElement creditCardDate(){
        return CCDate;
    }
    public  WebElement creditCardCvv(){
        return CCCvv;
    }
    public  WebElement payNowButton(){
        return PayNow;
    }
    public WebElement enterPassword(){
        return password;
    }

    public WebElement okButton(){
        return okButton;
    }

    public WebElement successMessage(){
        return success;
    }

}
