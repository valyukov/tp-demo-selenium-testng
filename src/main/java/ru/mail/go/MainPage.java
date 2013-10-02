package ru.mail.go;

import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFormElement getSearchFormElement() {
        return new SearchFormElement(driver);
    }
}
