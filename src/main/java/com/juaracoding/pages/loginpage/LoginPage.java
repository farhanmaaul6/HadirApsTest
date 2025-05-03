package com.juaracoding.pages.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    private Actions actions;

    @FindBy(id = "email")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div/div[2]/form/button")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1ar04jk']")
    private WebElement dashboardLabel;

    public LoginPage(WebDriver driver) {
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void loginAction(String username, String password) {
        actions.click(usernameField).sendKeys(username)
                .pause(Duration.ofSeconds(1))
                .click(passwordField).sendKeys(password)
                .pause(Duration.ofSeconds(1))
                .build().perform();
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getDashboardLabel() {
        return dashboardLabel.getText();
    }


}
