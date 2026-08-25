package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By product = By.id("item_4_title_link");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get product name
    public String getProductName() {
        return driver.findElement(product).getText();
    }
}