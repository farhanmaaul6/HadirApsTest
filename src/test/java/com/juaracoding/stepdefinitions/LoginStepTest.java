package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.loginpage.LoginPage;
import com.juaracoding.utils.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("Admin is on the login page")
    public void setLoginPage() {
        driver = DriverSingleton.getDriver();
        driver.get(Browser.URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
    }

    @When("Admin enters email {string} and password {string}")
    public void adminEntersEmailAndPassword(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        loginPage.loginAction(username, password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        loginPage.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Then("Admin should be redirected to the dashboard")
    public void adminShouldBeRedirectedToTheDashboard() throws InterruptedException {
        Thread.sleep(2000);
        String actual = loginPage.getDashboardLabel();
        String expected = "Dashboard Menu";
        Assert.assertEquals(actual, expected);
    }
}
