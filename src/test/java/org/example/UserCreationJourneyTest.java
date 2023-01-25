package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserCreationJourneyTest {

    @Test
    void shouldSuccessfullyCreateNewUser() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:3000");

        String title = driver.getTitle();
        assertEquals("OWASP Juice Shop", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement submitButton = driver.findElement(By.xpath("//button[@aria-label='Close Welcome Banner']"));

        submitButton.click();

        try { driver.findElement(By.xpath("//simple-snack-bar/div/button")).click(); } catch (Exception e) {}

        WebElement accountButton = driver.findElement(By.id("navbarAccount"));

        accountButton.click();

        WebElement loginButton = driver.findElement(By.id("navbarLoginButton"));

        loginButton.click();

        assertEquals("http://localhost:3000/#/login", driver.getCurrentUrl());

        WebElement newCustomerLink = driver.findElement(By.id("newCustomerLink"));

        newCustomerLink.click();

        assertEquals("http://localhost:3000/#/register", driver.getCurrentUrl());

        WebElement emailInput = driver.findElement(By.id("emailControl"));

        Integer emailUser = new Random().nextInt(1000000);

        emailInput.sendKeys(emailUser + "@email.com");

        WebElement passwordInput = driver.findElement(By.id("passwordControl"));

        passwordInput.sendKeys("password");

        WebElement repeatPasswordInput = driver.findElement(By.id("repeatPasswordControl"));

        repeatPasswordInput.sendKeys("password");

        WebElement securityQuestionInput = driver.findElement(By.name("securityQuestion"));

        securityQuestionInput.click();

        WebElement securityQuestionList = driver.findElement(By.xpath("//div[@aria-label='Selection list for the security question']"));

        securityQuestionList.findElements(By.tagName("mat-option")).get(1).click();

        WebElement securityAnswerInput = driver.findElement(By.id("securityAnswerControl"));

        securityAnswerInput.sendKeys("answer");

        WebElement registerButton = driver.findElement(By.id("registerButton"));

        registerButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(1)).until(
                ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//simple-snack-bar/span")), "Registration completed successfully. You can now log in.")
        );

        assertEquals("http://localhost:3000/#/login", driver.getCurrentUrl());

        driver.quit();
    }
}
