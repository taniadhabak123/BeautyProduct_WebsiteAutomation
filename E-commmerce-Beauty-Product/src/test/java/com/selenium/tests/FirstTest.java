package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void openBrowser() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://kiwla.com/");

        driver.findElement(By.name("email")).sendKeys("ankita@gmail.com");

        driver.findElement(By.name("pass")).sendKeys("ankita123");

        driver.findElement(By.partialLinkText("Sign in")).click();

        driver.navigate().back();

        driver.findElement(By.partialLinkText("Sign in")).click();

        System.out.println(driver.getTitle());

        driver.quit();
    }
}
