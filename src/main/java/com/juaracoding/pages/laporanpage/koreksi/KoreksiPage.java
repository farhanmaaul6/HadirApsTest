package com.juaracoding.pages.laporanpage.koreksi;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KoreksiPage {
    @FindBy(xpath = "//p[normalize-space()='Koreksi']")
    private WebElement koreksiTab;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement koreksiLabel;

    @FindBy(xpath = "(//*[@id='__next']//table/tbody/tr/td[10]/div/button[1])[1]")
    private WebElement buttonApprove;

    @FindBy(xpath = "(//*[@id='__next']//table/tbody/tr/td[10]/div/button[2])[1]")
    private WebElement buttonReject;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[1]")
    private WebElement buttonConfirm;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[2]")
    private WebElement buttonCancel;

    @FindBy(xpath = "//*[@id=\"rejectReason\"]")
    private WebElement rejectReason;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div[1]/div/table")
    private WebElement dataEmployee;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div[2]/div/div/p[2]")
    private WebElement invalidDataEmployee;

    public KoreksiPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openKoreksiTab() {
        koreksiTab.click();
    }

    public String getKoreksiLabel() {
        return koreksiLabel.getText();
    }

    public void buttonApprove() {
        buttonApprove.click();
    }

    public void buttonReject() {
        buttonReject.click();
    }

    public void rejectReason(String reason) {
        rejectReason.sendKeys(reason);
    }

    public void buttonConfirm() {
        buttonConfirm.click();
    }

    public void buttonCancel() {
        buttonCancel.click();
    }

    public String getValidateMessage() {
        return buttonConfirm.getAttribute("validationMessage");
    }

    public void getDataEmployee() {
        dataEmployee.getText();
    }

    public String getInvalidDataEmployee() {
        return invalidDataEmployee.getText();
    }
}