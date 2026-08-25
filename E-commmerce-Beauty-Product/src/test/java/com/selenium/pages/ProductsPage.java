package com.selenium.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    By backpack = By.id("search_query");

    By cart = By.className("form-input");

    // Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Add product
    public void addBackpackToCart() {
        driver.findElement(backpack).click();
    }

    // Open cart
    public void clickCart() {
        driver.findElement(cart).click();
    }
}