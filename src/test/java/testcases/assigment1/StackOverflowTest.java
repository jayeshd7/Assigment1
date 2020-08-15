package testcases.assigment1;

import objectRepository.assigment1.StackOverFlowPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static variables.assigment1.UrlVariables.BASE_URL;

public class StackOverflowTest {

    BrowserSetting bs = new BrowserSetting();
    WebDriver driver =  bs.BrowserSettings();
    StackOverFlowPage stackOverFlowPage = new StackOverFlowPage(driver);

    @BeforeTest
    public void tearUp() {

        driver.get(BASE_URL);
        Reporter.log("URL Invoked.");
    }


    @Test(priority = 1)
    public void StackOverflowDashboard() throws InterruptedException {
        clickSideByToggle(driver);
        clickTagsSection(driver);
        clickNameSection(driver);
        Thread.sleep(5000);
        findAllTagNames(driver);



        System.out.println("Here End..");

    }

    private void findAllTagNames(WebDriver driver) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        List<WebElement> allTags = driver.findElements(By.className("post-tag"));

        for(WebElement tags:allTags){
            System.out.println(tags.getText());
            WebElement tagsValues = driver.findElement(By.xpath("//a[text()='"+tags.getText()+"']/following::div[@class='grid--cell'][1]"));
            String answertag = tagsValues.getText().replaceAll("[^0-9]","");
            System.out.println(answertag);
            int ans = Integer.parseInt(answertag.trim());
            hashMap.put(tags.getText(),ans);
        }

        System.out.println(hashMap.size());
        hashMap.entrySet();


        }


    private void clickNameSection(WebDriver driver) {
        stackOverFlowPage.nameSection().click();
    }

    private void clickTagsSection(WebDriver driver) {
        stackOverFlowPage.tagSection().click();
    }

    private void clickSideByToggle(WebDriver driver) {
        stackOverFlowPage.sideBarToggle().click();
    }

    @AfterTest
    public void tearDown() {
        Reporter.log("shut Down the Browser");
        driver.close();
    }



}
