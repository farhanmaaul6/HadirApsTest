package com.juaracoding.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaporanLemburPage {

    @FindBy(xpath = "//p[normalize-space()='Laporan']")
    WebElement laporanMenu;

    @FindBy(xpath = "//p[normalize-space()='Lembur']")
    WebElement lemburTab;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    WebElement lemburLabel;

    @FindBy(xpath = "//input[@id='search']")
    WebElement searchBarName;

    @FindBy(xpath = "//*[@id=\"search\"]")
    WebElement buttonSearchName;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-7 MuiGrid-grid-lg-8 css-kw2xn2']//div[1]//div[1]//div[1]//button[1]//*[name()='svg']")
    WebElement startDate;

    @FindBy(xpath = "//body//div[@id='__next']//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3 css-1h77wgb']//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3 css-1h77wgb']//div[2]//div[1]//div[1]//button[1]//*[name()='svg']//*[name()='g']//*[name()='line' and contains(@x1,'3')]")
    WebElement endDate;

    @FindBy(xpath = "//input[@placeholder='Early']")
    WebElement earlyDate;

    @FindBy(xpath = "//input[@placeholder='Continuous']")
    WebElement continuousDate;

    @FindBy(xpath = "//button[normalize-space()='save']")
    WebElement buttonSaveDate;

    @FindBy(xpath = "//button[normalize-space()='cancel']")
    WebElement buttonCancelDate;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement buttonReset;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[2]/div/button[1]")
    WebElement buttonFilter;

    @FindBy(xpath = "//*[@id=\"job_departement\"]")
    WebElement searchBarFilter;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[2]")
    WebElement buttonTerapkan;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[1]")
    WebElement buttonCancelTerapkan;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/table/tbody")
    WebElement dataEmployee;

    @FindBy(xpath = "//button[normalize-space()='Export']")
    WebElement buttonExport;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[3]/div/div/div[2]")
    WebElement buttonComboBox;

    @FindBy(xpath = "//button[@title='Go to next page']//*[name()='svg']")
    WebElement buttonGoToNextPage;

    @FindBy(xpath = "//button[@title='Go to last page']//*[name()='svg']")
    WebElement buttonGoToLastPage;

    @FindBy(xpath = "//button[@title='Go to previous page']//*[name()='svg']")
    WebElement buttonGoToPreviousPage;

    @FindBy(xpath = "//button[@title='Go to first page']//*[name()='svg']")
    WebElement buttonGoToFirstPage;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div")
    WebElement scrollBarToRight;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[15]/button")
    WebElement buttonAksi;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[2]")
    WebElement buttonUbahData;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[1]")
    WebElement buttonCancelUbahData;

    @FindBy(xpath = "//div[@class='MuiSnackbarContent-message css-1w0ym84']")
    WebElement popUpAlert;

    public LaporanLemburPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void popUpAlert () {
        popUpAlert.getText();
    }

    public void clickLaporanMenu() {
        laporanMenu.click();
    }

    public void clickLemburTab() {
        lemburTab.click();
    }

    public String getLemburLabel() {
        return lemburLabel.getText();
    }

    public void searchAction(String namaKaryawan) {
        searchBarName.sendKeys(namaKaryawan);
    }

    public void clickButtonSearchName() {
        buttonSearchName.click();
    }

    public void buttonStartDate() {
        startDate.click();
    }

    public void buttonEndDate() {
        endDate.click();
    }

    public void earlyDateInput(String dateTerm){
        earlyDate.sendKeys(Keys.CONTROL + "a");
        earlyDate.sendKeys(Keys.BACK_SPACE);
        earlyDate.sendKeys(dateTerm);
    }

    public void continueDateInput(String dateTerm){
        continuousDate.sendKeys(Keys.CONTROL + "a");
        continuousDate.sendKeys(Keys.BACK_SPACE);
        continuousDate.sendKeys(dateTerm);
    }

    public void clickSaveDate() {
        buttonSaveDate.click();
    }

    public void clickCancelDate() {
        buttonCancelDate.click();
    }

    public void clickReset() {
        buttonReset.click();
    }

    public void clickButtonFilter() {
        buttonFilter.click();
    }

    public void searchActionFilter(String namaDepartment) {
        searchBarFilter.sendKeys(namaDepartment);
    }

    public void clickButtonTerapkan() {
        buttonTerapkan.click();
    }

    public void clickCancelButtonTerapkan() {
        buttonCancelTerapkan.click();
    }

    public void getDataEmployee() {
        dataEmployee.getText();
    }

    public void clickButtonExport() {
        buttonExport.click();
    }

    public void clickButtonComboBox() {
        buttonComboBox.click();
    }

    public void clickNextPage() {
        buttonGoToNextPage.click();
    }

    public void clickLastPage() {
        buttonGoToLastPage.click();
    }

    public void clickPreviousPage() {
        buttonGoToPreviousPage.click();
    }

    public void clickFirstPage() {
        buttonGoToFirstPage.click();
    }

    public void scrollToRight() {
        JavascriptExecutor js = (JavascriptExecutor) scrollBarToRight;
        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", scrollBarToRight);
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

}
