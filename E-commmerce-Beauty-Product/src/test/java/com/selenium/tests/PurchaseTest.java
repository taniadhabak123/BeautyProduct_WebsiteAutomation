package com.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.selenium.pages.LoginPage;
import com.selenium.pages.ProductsPage;
import com.selenium.pages.CartPage;

public class PurchaseTest {

    WebDriver driver;

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);

        productsPage = new ProductsPage(driver);

        cartPage = new CartPage(driver);
    }

    @Test
    public void purchaseTest() {

        // Login
        loginPage.enterUsername("standard_user");

        loginPage.enterPassword("secret_sauce");

        loginPage.clickLogin();

        // Verify Login
        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login failed"
        );

        // Add product
        productsPage.addBackpackToCart();

        // Open Cart
        productsPage.clickCart();

        // Get product name
        String productName = cartPage.getProductName();

        // Verify product
        Assert.assertEquals(
                productName,
                "Sauce Labs Backpack",
                "Wrong product in cart"
        );

        System.out.println("Purchase test passed");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}