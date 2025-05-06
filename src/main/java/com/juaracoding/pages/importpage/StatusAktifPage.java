package com.juaracoding.pages.importpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatusAktifPage {

    @FindBy(xpath = "//p[normalize-space()='Import Status Aktif']")
    private WebElement statusAktifTab;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement statusAktifLabel;

    public StatusAktifPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void openStatusAktifTab() {
        statusAktifTab.click();
    }

    public String getStatusAktifLabel() {
        return statusAktifLabel.getText();
    }


}
