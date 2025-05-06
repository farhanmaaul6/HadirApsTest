package com.juaracoding.pages.laporanpage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SakitPage {
    private Actions actions;

    @FindBy(xpath = "//p[normalize-space()='Sakit']")
    private WebElement sakitTab;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/header/div/p")
    private WebElement sakitLabel;

    @FindBy(xpath = "//tbody/tr[1]/td[5]/h6[1]/div[1]/div[1]/a[1]")
    private WebElement buttonViewSurat;

    @FindBy(xpath = "//tbody/tr[1]/td[5]/h6[1]/div[1]/div[1]/a[2]")
    private WebElement buttonDownloadSurat;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div")
    private WebElement photoSakit;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[1]/div/table")
    private WebElement dataEmployee;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div/p[2]")
    private WebElement invalidDataEmployee;

    public SakitPage(WebDriver driver) {
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickMenuSakit() {
        sakitTab.click();
    }

    public String getSakitLabel () {
        return sakitLabel.getText();
    }

    public void clickViewSurat() {
        actions.click(buttonViewSurat)
                .pause(Duration.ofSeconds(3))
                .sendKeys(Keys.ESCAPE).build().perform();
    }

    public void clickDownloadSuratSakit() {
        buttonDownloadSurat.click();
    }

    public void getDataEmployee() {
        dataEmployee.getText();
    }

    public String getInvalidDataEmployee() {
        return invalidDataEmployee.getText();
    }
}
