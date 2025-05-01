package com.juaracoding.pages.importpage.strukturuser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StrukturUserPage {

    @FindBy(xpath = "//p[normalize-space()='Import Struktur User']")
    private WebElement strukturUserTab;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement strukturUserlabel;

    public StrukturUserPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void openStrukturUserTab() {
        strukturUserTab.click();
    }

    public String getStrukturUserLabel() {
        return strukturUserlabel.getText();
    }

}
