package testcases.assigment1;

import objectRepository.assigment1.StackOverFlowPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

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
        Thread.sleep(2000);
        clickNameSection(driver);
        findAllTagNames(driver);
    }

    private void findAllTagNames(WebDriver driver) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        List<WebElement> allTags = driver.findElements(By.className("post-tag"));

        for(WebElement tags:allTags){
            WebElement tagsValues = driver.findElement(By.xpath("//a[text()='"+tags.getText()+"']/following::div[@class='grid--cell'][1]"));
            String answertag = tagsValues.getText().replaceAll("[^0-9]","");
            int ans = Integer.parseInt(answertag.trim());
            hashMap.put(tags.getText(),ans);
        }

        LinkedHashMap<String, Integer> hm1 = (LinkedHashMap<String, Integer>) sortByValue(hashMap);


        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println("tags Name = " + en.getKey() +
                    ", answer count = " + (en.getValue())  );
        }

    }

    private static Map<String, Integer> sortByValue(HashMap<String, Integer> hashMap) {
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hashMap.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        LinkedHashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;

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
