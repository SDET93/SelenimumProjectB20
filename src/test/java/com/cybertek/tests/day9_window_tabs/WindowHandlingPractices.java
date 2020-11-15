package com.cybertek.tests.day9_window_tabs;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlingPractices {
   /*
    TC5 # : Window Handle practice
    1. Create a new class called: WindowHandlePractice
    2. Create new test and make set ups
    3. Go to : http://practice.cybertekschool.com/windows
    4. Assert: Title is “Practice”
    5. Click to: “Click Here” text
    6. Switch to new Window.
    7. Assert: Title is “New Window”
     */

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @Test
    public void p5_handling_windows() {

        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equals("Practice"));
        System.out.println("actualTitle = " + actualTitle);

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);

        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("mainWindowHandle = " + mainWindowHandle);

        //Set allows only unique values.
        Set<String> windowHandles = driver.getWindowHandles();

        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current title= " + driver.getTitle());
        }
        //Getting the current title, and comparing with expected title.
        Assert.assertTrue(driver.getTitle().equals("New Window"));

        BrowserUtils.wait(2);
        driver.close(); //driver close will close the current focused window/tab

        //If I want to switch back to main page, to continue with some other actions:
        driver.switchTo().window(mainWindowHandle);

        //driver.quit will close all of the tabs that are opened in that session together
        driver.quit();

    }

    @Test
    public void p6_handling_more_than_two_windows() {
        //TC-6 : Window Handle practice
        // 1.Create new test and make set ups
        // 2.Go to : https://www.amazon.com
        // 3.Copy paste the lines from below into your class
        // 4.Create a logic to switch to the tab where Etsy.com is open
        // 5.Assert: Title contains “Etsy”

        driver.get("https://www.amazon.com");

        //THIS LINE IS BASICALLY:   We are downcasting our driver type to JavaScriptExecutor
        //The only thing this line is doing is using javascript executor -> opening new tabs with given links
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        Set<String> windowHandles = driver.getWindowHandles();
        for(String each:windowHandles){
            driver.switchTo().window(each);
            System.out.println("Current page title: "+driver.getTitle());

            if(driver.getCurrentUrl().contains("etsy")){
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }


    }


}
