package com.app.demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoreActions {
    private WebDriver driver;

    public CoreActions(WebDriver driver) {
        this.driver = driver;
    }

    public void type(WebElement element, String data) {
        WaitForElementToVisible(element);
        element.clear();
        element.sendKeys(data);
    }

    public void click(WebElement element) {
        WaitForElementToClick(element);
        element.click();
    }

    public void WaitForElementToClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WaiTime.MEDIUM_WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void WaitForElementToVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WaiTime.MEDIUM_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getText(WebElement element)
    {
        WaitForElementToVisible(element);
        return element.getText().trim();
    }

}
