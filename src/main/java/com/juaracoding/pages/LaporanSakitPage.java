package com.juaracoding.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaporanSakitPage {

    @FindBy(xpath = "//p[normalize-space()='Laporan']")
    private WebElement laporanMenu;

    @FindBy(xpath = "//p[normalize-space()='Sakit']")
    private WebElement sakitTab;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/header/div/p")
    private WebElement sakitLabel;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-7 MuiGrid-grid-lg-8 css-kw2xn2']//div[1]//div[1]//div[1]//button[1]//*[name()='svg']")
    private WebElement startDate;

    @FindBy(xpath = "//input[@placeholder='Early']")
    private WebElement earlyDate;

    @FindBy(xpath = "//input[@placeholder='Continuous']")
    private WebElement continueDate;

    @FindBy(xpath = "//body//div[@id='__next']//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3 css-1h77wgb']//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3 css-1h77wgb']//div[2]//div[1]//div[1]//button[1]//*[name()='svg']")
    private WebElement endDate;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[2]/button[2]")
    private WebElement saveDateButton; //button[@type='submit']

    @FindBy(xpath = "//button[normalize-space()='cancel']")
    private WebElement buttonCancelDate;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement buttonReset;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium css-1k0lhp1']//*[name()='svg']")
    private WebElement buttonFilter;

    @FindBy(xpath = "//*[@id=\"job_departement\"]")
    private WebElement searchBarFilter;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium css-1k0lhp1']//*[name()='svg']")
    private WebElement buttonTerapkan;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium css-1k0lhp1']//*[name()='svg']")
    private WebElement buttonBatalFilter;

    @FindBy(xpath = "//tbody/tr[1]/td[5]/h6[1]/div[1]/div[1]/a[1]")
    private WebElement buttonViewSurat;

    @FindBy(xpath = "//tbody/tr[1]/td[5]/h6[1]/div[1]/div[1]/a[2]")
    private WebElement buttonDownloadSurat;

    @FindBy(xpath = "//div[@id='mui-28']")
    private WebElement comboBoxUnit;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div/div[3]/button[3]")
    private WebElement buttonNextPage;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    private WebElement dataEmployee;


    public LaporanSakitPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickMenuLaporan() {
        laporanMenu.click();
    }

    public void clickMenuSakit() {
        sakitTab.click();
    }

    public void setSearchBar(String nama) {
        searchBar.sendKeys(nama);
    }

    public String getSakitLabel () {
        return sakitLabel.getText();
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
        buttonTerapkan.click();
    }

    public void buttonBatalFilter() {
        buttonBatalFilter.click();
    }


    public void buttonCancel() {
        buttonCancelDate.click();
    }


    public void getDataEmployee() {
        dataEmployee.getText();
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
        continueDate.sendKeys(Keys.CONTROL + "a");
        continueDate.sendKeys(Keys.BACK_SPACE);
        continueDate.sendKeys(dateTerm);
    }

    public void buttonCancelDate() {
        buttonCancelDate.click();
    }

    public void buttonSaveDate() {
        saveDateButton.click();
    }

    public void goToNextPage() {
        buttonNextPage.click();
    }

    public void clickViewSurat() {
        buttonViewSurat.click();
    }

    public void pilihUnit(String unitValue) {
        comboBoxUnit.sendKeys(unitValue);
    }

    public String getErrorMessage() {
        return "Data tidak ditemukan";
    }

    // Klik tombol unduh surat sakit
    public void clickDownloadSuratSakit() {
       buttonDownloadSurat.click();
    }
}
