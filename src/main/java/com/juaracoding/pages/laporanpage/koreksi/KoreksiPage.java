package com.juaracoding.pages.laporanpage.koreksi;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KoreksiPage {
    @FindBy(xpath = "//p[normalize-space()='Laporan']")
    private WebElement laporanMenu;

    @FindBy(xpath = "//p[normalize-space()='Koreksi']")
    private WebElement koreksiTab;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement koreksiLabel;

    @FindBy(xpath = "//input[@placeholder='Start Date']")
    private WebElement startDate;

    @FindBy(xpath = "//input[@placeholder='End Date']")
    private WebElement endDate;

    @FindBy(xpath = "//*[@id=\"search\"]")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"job_departement\"]")
    private WebElement searchBarFilter;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div")
    private WebElement popUpUpdate;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement buttonReset;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[2]/div/button[1]")
    private WebElement buttonFilter;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[2]")
    private WebElement buttonTerapkanFilter;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[1]")
    private WebElement buttonBatalFilter;

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

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div[1]/div/table/tbody")
    private WebElement dataEmployee;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[2]/div[1]/div/div/button")
    private WebElement buttonStartDate;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[1]/div[1]/div/span[1]/input")
    private WebElement earlyDate;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[1]/div[1]/div/span[2]/input")
    private WebElement continueDate;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[2]/div[2]/div/div/button")
    private WebElement buttonEndDate;

    @FindBy(xpath = "//button[normalize-space()='cancel']")
    private WebElement buttonCancelDate;

    @FindBy(xpath = "//button[normalize-space()='save']")
    private WebElement buttonSaveDate;

    @FindBy(xpath = "//button[@title='Go to next page']//*[name()='svg']")
    private  WebElement buttonNextPage;

    public KoreksiPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openLaporanMenu() {
        laporanMenu.click();
    }

    public void openKoreksiTab() {
        koreksiTab.click();
    }

    public String getKoreksiLabel() {
        return koreksiLabel.getText();
    }

    public void searchAction(String searchTerm) {
        searchBar.sendKeys(searchTerm);
    }

    public void searchFilterAction(String searchTerm) {
        searchBarFilter.sendKeys(searchTerm);
    }

    public void startDate(String start) {
        startDate.sendKeys(start);
    }

    public void endDate(String end) {
        endDate.sendKeys(end);
    }

    public void popUpUpdate() {
        popUpUpdate.getText();
    }

    public void buttonSearch() {
        buttonSearch.click();
    }

    public void buttonReset() {
        buttonReset.click();
    }

    public void buttonFilter() {
        buttonFilter.click();
    }

    public void buttonTerapkanFilter() {
        buttonTerapkanFilter.click();
    }

    public void buttonBatalFilter() {
        buttonBatalFilter.click();
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


    public void getDataEmployee() {
        dataEmployee.getText();
    }

    public void buttonStartDate() {
        buttonStartDate.click();
    }

    public void buttonEndDate() {
        buttonEndDate.click();
    }

    public void earlyDateInput(String dateTerm){
        earlyDate.sendKeys(Keys.CONTROL + "a");
        earlyDate.sendKeys(Keys.BACK_SPACE);
        earlyDate.sendKeys(dateTerm);
    }

    public void continueDateInput(String dateTerm){
        continueDate.sendKeys(Keys.CONTROL + "a");
        continueDate.sendKeys(Keys.BACK_SPACE);
        continueDate.sendKeys(dateTerm);
    }

    public void buttonCancelDate() {
        buttonCancelDate.click();
    }

    public void buttonSaveDate() {
        buttonSaveDate.click();
    }

    public void goToNextPage() {
        buttonNextPage.click();
    }

    public String getValidateMessage() {
        return buttonConfirm.getAttribute("validationMessage");
    }
}