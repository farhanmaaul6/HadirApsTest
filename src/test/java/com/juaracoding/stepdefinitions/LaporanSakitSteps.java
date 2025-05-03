package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.LaporanSakitPage;
import com.juaracoding.pages.loginpage.LoginPage;
import io.cucumber.java.en.*;
import io.cucumber.java.sl.In;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class LaporanSakitSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private LaporanSakitPage laporanSakitPage;

    public LaporanSakitSteps () {

        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        laporanSakitPage = new LaporanSakitPage(driver);

        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // ini kan buat loginnya
    @Given("Admin is logged in and on to the dashboard for Laporan Sakit")
    public void adminIsOnTheDashboardForLaporanSakit() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getDashboardLabel();
    }

    // buat klik menu laporan, dan sub menu sakit
    @When("User navigates to Laporan Sakit Page")
    public void adminNavigatesToLaporanSakitPage() throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.clickMenuLaporan();
        Thread.sleep(2000);
        laporanSakitPage.clickMenuSakit();
        String actual = laporanSakitPage.getSakitLabel();
        String expected = "Sakit";
        Assert.assertEquals(actual, expected);
    }

    @And("Admin inputs {string} in the search name field")
    public void adminInputsInTheSearchNameField (String searchTerm) throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.searchAction(searchTerm);
    }

    // ini input tanggal awal sama tanggal akhir yaa
    @And("Admin input start date sakit {string} and end date {string}")
    public void adminInputStartDateSakitAndEndDate(String date0, String date1) throws InterruptedException {
      Thread.sleep(2000);
      laporanSakitPage.buttonStartDate();
      Thread.sleep(2000);
      laporanSakitPage.earlyDateInput(date0);
      Thread.sleep(2000);
      laporanSakitPage.continueDateInput(date1);
      Thread.sleep(2000);
      laporanSakitPage.buttonSaveDate();
    }

    @And("Admin click search button sakit")
    public void adminClickSearchButtonSakit() throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.buttonSearch();
    }

    @Then("Sick leave reports data should be displayed based on name and date range")
    public void userShouldSeeReportForDates() throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.getDataEmployee();
    }

    @When("Admin clicks filter department button")
    public void adminClicksFilterDepartmentButton () throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.buttonFilter();
    }

    @And("Admin inputs unit name {string} for filter department")
    public void adminInputsUnitNameForFilterDepartment (String unitTerm) throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.searchFilterAction(unitTerm);
    }

    @And("Admin clicks the Apply filter departement button")
    public void adminClicksTheApplyFilterDepartementButton () throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.buttonTerapkanFilter();
    }

    @Then("Laporan Sakit data should be displayed only from selected units department")
    public void laporanSakitDataShouldBeDisplayedOnlyFromSelectedUnits () throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.getDataEmployee();
    }

    @And("Admin clicks view and download surat sakit")
    public void adminClicksViewAndDownloadSuratSakit () throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.clickViewSurat();
        Thread.sleep(2000);
        laporanSakitPage.getSakitLabel();
        Thread.sleep(2000);
        laporanSakitPage.clickDownloadSuratSakit();
    }

    @Then("Admin can see the downloaded file")
    public void adminClickDownloadSuratSakit () throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.clickDownloadSuratSakit();
    }

    @And("Admin clicks on the Reset Button")
    public void adminClicksOnTheResetButton () throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.buttonReset();
    }

    @Then("All filters should be default data")
    public void allFiltersShouldBeDefaultData() throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.getDataEmployee();
    }

    //Negative
    @And("Admin clicks the Search button without entering any filter departement")
    public void adminClicksTheSearchButtonWithoutEnteringAnyFilterDepartment() throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.buttonSearch();
    }

    @Then("No laporan sakit data should be displayed or an alert message should appear")
    public void noLaporanSakitShouldBeDisplayedOrAnAlertMessageShouldAppear() throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.getDataEmployee();
    }

    @And("Admin inputs invalid employee name {string}")
    public void adminInputsInvalidEmployeeName(String unitTerm) throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.searchAction(unitTerm);
    }

    @Then("No laporan sakit data should be displayed or an alert should appear")
    public void noLaporanSakitShouldBeDisplayedOrAnAlertShouldAppear() throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.getDataEmployee();
    }


    @Then("User should see the report for name {string}")
    public void userShouldSeeTheReportForName(String name) throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.searchAction(name);
    }

    @Then("Sick leave reports data should be displayed based on name")
    public void sickLeaveReportsDataShouldBeDisplayedBasedOnName() throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.getDataEmployee();
    }

    @Then("Sick leave reports data should be displayed based on department")
    public void sickLeaveReportsDataShouldBeDisplayedBasedOnDepartment() throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.getDataEmployee();
    }

    @And("Admin click on next page")
    public void adminClickOnNextPage() throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.goToNextPage();
    }

    @And("Admin clicks on unit combobox")
    public void adminClicksOnUnitCombobox() throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.pilihUnit("5");

    }

    @And("the admin enters the department name \\{string} in the search bar")
    public void theAdminEntersTheDepartmentNameStringInTheSearchBar(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        laporanSakitPage.searchFilterAction(arg0);
    }
}
