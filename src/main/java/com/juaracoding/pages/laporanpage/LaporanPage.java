package com.juaracoding.pages.laporanpage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LaporanPage {
    private WebDriver driver;

    @FindBy(xpath = "//p[normalize-space()='Laporan']")
    private WebElement laporanMenu;

    @FindBy(xpath = "//*[@id=\"search\"]")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"job_departement\"]")
    private WebElement searchBarFilter;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div")
    private WebElement popUpUpdate;
                     //*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[2]/div/button[3]
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[2]/div/button[3]")
    private WebElement buttonSearch;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[2]/div/button[2]")
    private WebElement buttonReset;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[2]/div/button[1]")
    private WebElement buttonFilter;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[2]")
    private WebElement buttonTerapkanFilter;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[1]")
    private WebElement buttonBatalFilter;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[2]/div[1]/div/div/button")
    private WebElement buttonStartDate;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[2]/div[2]/div/div/button")
    private WebElement buttonEndDate;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[1]/div[1]/div/span[1]/input")
    private WebElement earlyDate;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[1]/div[1]/div/span[2]/input")
    private WebElement continueDate;

    @FindBy(xpath = "//button[normalize-space()='save']")
    private WebElement buttonSaveDate;

    @FindBy(xpath = "//button[normalize-space()='cancel']")
    private WebElement buttonCancelDate;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div[2]/div/div/div[3]/button[3]")
    private  WebElement buttonNextPage;

    public LaporanPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLaporanMenu() {
        laporanMenu.click();
    }

    public void searchAction(String searchTerm) {
        searchBar.sendKeys(searchTerm);
    }

    public void searchFilterActionValid(String searchTerm) throws InterruptedException {
        searchBarFilter.sendKeys(Keys.CONTROL + "a");
        searchBarFilter.sendKeys(Keys.BACK_SPACE);
        searchBarFilter.sendKeys(searchTerm);

        Thread.sleep(1000);

        List<WebElement> options;
        options = By.xpath("//li[contains(@class,'MuiAutocomplete-option')]").findElements((SearchContext) driver);

        if (!options.isEmpty()) {
            for (WebElement option : options) {
                if (option.getText().toLowerCase().contains(searchTerm.toLowerCase())) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
                    return;
                }
            }
            throw new RuntimeException("Expected valid option but no matching found.");
        } else {
            throw new RuntimeException("No options found for valid unit.");
        }
    }

    public void searchFilterActionInvalid(String searchTerm) throws InterruptedException {
        searchBarFilter.sendKeys(searchTerm);

        Thread.sleep(1000);

        List<WebElement> options;
        options = By.xpath("//li[contains(@class,'MuiAutocomplete-option')]").findElements((SearchContext) driver);

        if (options.isEmpty()) {
            searchBarFilter.sendKeys(Keys.ESCAPE);
        } else {
            throw new RuntimeException("Expected no results but some options appeared.");
        }
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
}
