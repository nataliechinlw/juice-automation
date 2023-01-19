package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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

        WebElement accountButton = driver.findElement(By.id("navbarAccount"));

        accountButton.click();

        WebElement loginButton = driver.findElement(By.id("navbarLoginButton"));

        loginButton.click();

        assertEquals("http://localhost:3000/#/login", driver.getCurrentUrl());

        driver.quit();
    }
}
