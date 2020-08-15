package objectRepository.assigment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StackOverFlowPage {
    WebDriver driver;

    public StackOverFlowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = (".left-sidebar-toggle"))
    WebElement sideBarToggle;

    @FindBy(id= ("nav-tags"))
    WebElement tags;

    @FindBy(xpath = ("//a[contains(.,'Name')]"))
    WebElement nameSection;

    @FindBy(className = ("post-tag"))
    WebElement tagName;



    public WebElement sideBarToggle() {
        return sideBarToggle;
    }
    public WebElement tagSection(){
        return tags;
    }
    public WebElement nameSection(){
        return nameSection;
    }
    public WebElement tagNames(){
        return tagName;
    }
}
