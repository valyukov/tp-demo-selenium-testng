package ru.mail.go.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.mail.go.MainPage;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.net.MalformedURLException;
import java.net.URL;

public class SuggestTests {

    private WebDriver driver;

    @BeforeMethod
    @Parameters({"browser", "hub", "url"})
    public void setUp(String browser, String hub, String url) throws MalformedURLException {
        if (browser.toLowerCase().equals("chrome"))
            this.driver = new RemoteWebDriver(new URL(hub), DesiredCapabilities.chrome());
        else if (browser.toLowerCase().equals("firefox"))
            this.driver = new RemoteWebDriver(new URL(hub), DesiredCapabilities.firefox());
        else
            throw new NotImplementedException();
        this.driver.manage().window().maximize();
        this.driver.get(url);
    }

    @Test
    public void simpleSuggestTest() {
        String suggests = new MainPage(this.driver).getSearchFormElement().enterText("в").getSuggests();
        Assert.assertTrue(suggests.contains("вконтакте"));
    }

    @AfterMethod
    public void tearDown() {
        this.driver.close();
    }
}
