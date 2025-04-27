package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportPage {
    @FindBy(xpath = "//p[normalize-space()='Import']")
    private WebElement importMenu;

    @FindBy(xpath = "//p[normalize-space()='Import Status Aktif']")
    private WebElement statusAktifTab;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement statusAktifLabel;

    @FindBy(xpath = "//p[normalize-space()='Import Struktur User']")
    private WebElement strukturUserTab;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement strukturUserlabel;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf'][normalize-space()='Import Cuti']")
    private WebElement cutiTab;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement cutiLabel;

    @FindBy(xpath = "//p[normalize-space()='Import Absen']")
    private WebElement absenTab;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement absenLabel;

    @FindBy(xpath = "//button[normalize-space()='Download Template']")
    private WebElement buttonDownload;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonImport;

    @FindBy(xpath = "//input[@id='selfie']")
    private WebElement buttonChooseFile;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement popUp;

    @FindBy(xpath = "//p[@id='selfie-helper-text']")
    private WebElement helperText;

    public ImportPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openImportMenu() {
        importMenu.click();
    }

    public void openStatusAktifTab() {
        statusAktifTab.click();
    }

    public String getStatusAktifLabel() {
        return statusAktifLabel.getText();
    }

    public void openStrukturUserTab() {
        strukturUserTab.click();
    }

    public String getStrukturUserLabel() {
        return strukturUserlabel.getText();
    }

    public void openCutiTab() {
        cutiTab.click();
    }

    public String getCutiLabel() {
        return cutiLabel.getText();
    }

    public void openAbsenTab() {
        absenTab.click();
    }

    public String getAbsenLabel() {
        return absenLabel.getText();
    }

    public void buttonDownload() {
        buttonDownload.click();
    }

    public WebElement buttonChooseFile() {
        return buttonChooseFile;
    }

    public void buttonImport() {
        buttonImport.click();
    }

    public void popUp() {
        popUp.getText();
    }

    public void getHelperText() {
        helperText.getText();
    }
}