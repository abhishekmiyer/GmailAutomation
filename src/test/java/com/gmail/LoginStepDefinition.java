package com.gmail;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class LoginStepDefinition  {
    WebDriver driver;

    @Given("I am on the Gmail login page")
    public void iAmOnTheGmailLoginPage() throws InterruptedException {
        // Setup WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\iyerl\\IdeaProjects\\GmailAutomation\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.google.com");
        Thread.sleep(3000);
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        // Enter valid credentials
        driver.findElement(By.id("identifierId")).sendKeys("iyerlakerfan");
        driver.findElement(By.id("identifierNext")).click();
        // Wait for password input to appear
        // This is just a placeholder, you might need a proper wait mechanism
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.name("password")).sendKeys("sparkypeanuts50");
        driver.findElement(By.id("passwordNext")).click();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        // Add assertions for successful login
        // For example, you can check if a specific element exists on the logged-in page
        boolean isLoggedIn = driver.findElement(By.id("gb")).isDisplayed();
        assert(isLoggedIn);
        driver.quit();
    }
}
