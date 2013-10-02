package ru.mail.go;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFormElement {
    private WebDriver driver;

    public SearchFormElement(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFormElement enterText(String query) {
        driver.findElement(By.id("q")).sendKeys(query);
        return this;
    }

    public ResultPage clickGoButton() {
        driver.findElement(By.cssSelector(".js-is-not-scrollable"));
        return new ResultPage(driver);
    }

    public ResultPage search(String query) {
        this.enterText(query);
        this.clickGoButton();
        return new ResultPage(driver);
    }


    public SearchFormElement cleanButton() {
        driver.findElement(By.id("go-form__qclear"));
        return this;
    }

    public String getSuggests() {
        return driver.findElement(By.className("go-suggests__items")).getText();
    }
}
