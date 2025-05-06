package com.juaracoding.pages.laporanpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LemburPage {
    @FindBy(xpath = "//p[normalize-space()='Lembur']")
    WebElement lemburTab;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    WebElement lemburLabel;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[15]/button")
    WebElement buttonAksi;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[2]")
    WebElement buttonUbahData;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[1]")
    WebElement buttonCancelUbahData;

    @FindBy(xpath = "//button[normalize-space()='Export']")
    WebElement buttonExport;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/table")
    private WebElement dataEmployee;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[3]/div/div/p[2]")
    private WebElement invalidDataEmployee;

    public LemburPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickLemburTab() {
        lemburTab.click();
    }

    public String getLemburLabel() {
        return lemburLabel.getText();
    }

    public void clickButtonAksi() {
        buttonAksi.click();
    }

    public void clickButtonUbahData() {
        buttonUbahData.click();
    }

    public void clickButtonCancelUbahData() {
        buttonCancelUbahData.click();
    }

    public void clickButtonExport() {
        buttonExport.click();
    }

    public void getDataEmployee() {
        dataEmployee.getText();
    }

    public String getInvalidDataEmployee() {
        return invalidDataEmployee.getText();
    }
}
