package ru.mail.go;

import org.openqa.selenium.WebDriver;

public class ResultPage {

    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFormElement getSearchFormElement() {
        return new SearchFormElement(driver);
    }


    public String getTitle() {
        return driver.getTitle();
    }
}
