package com.juaracoding.pages.importpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportPage {
    @FindBy(xpath = "//p[normalize-space()='Import']")
    private WebElement importMenu;

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

    public void buttonDownload() {
        buttonDownload.click();
    }

    public WebElement buttonChooseFile() {
        return buttonChooseFile;
    }

    public String getValidateMessage() {
        return buttonChooseFile.getAttribute("validationMessage");
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