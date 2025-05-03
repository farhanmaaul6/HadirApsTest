package com.juaracoding.pages.importpage.absen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbsenPage {

    @FindBy(xpath = "//p[normalize-space()='Import Absen']")
    private WebElement absenTab;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement absenLabel;

    public AbsenPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openAbsenTab() {
        absenTab.click();
    }

    public String getAbsenLabel() {
        return absenLabel.getText();
    }

}
