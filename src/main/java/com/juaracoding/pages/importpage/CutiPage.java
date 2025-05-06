package com.juaracoding.pages.importpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CutiPage {

    @FindBy(xpath = "//p[normalize-space()='Import Cuti']")
    private WebElement cutiTab;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement cutiLabel;

    @FindBy(xpath = "//input[@id='file_excel']")
    private WebElement buttonChooseFileCuti;

    @FindBy(xpath = "//p[@id='file_excel-helper-text']")
    private WebElement helperTextCuti;

    public CutiPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void openCutiTab() {
        cutiTab.click();
    }

    public String getCutiLabel() {
        return cutiLabel.getText();
    }

    public WebElement buttonChooseFileCuti() {
        return buttonChooseFileCuti;
    }

    public String getValidateMessageCuti() {
        return buttonChooseFileCuti.getAttribute("validationMessage");
    }

    public void getHelperTextCuti() {
        helperTextCuti.getText();
    }

}
