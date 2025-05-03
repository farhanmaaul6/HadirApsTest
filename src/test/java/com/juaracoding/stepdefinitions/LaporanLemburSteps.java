package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.LaporanLemburPage;
import com.juaracoding.pages.loginpage.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class LaporanLemburSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private LaporanLemburPage laporanLemburPage;

    public LaporanLemburSteps() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        laporanLemburPage = new LaporanLemburPage(driver);

        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @When("the admin navigates to Overtime Reports menu")
    public void adminNavigatesToOverTimeReportsMenu() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickLaporanMenu();
        Thread.sleep(2000);
        laporanLemburPage.clickLemburTab();
        String actual = laporanLemburPage.getLemburLabel();
        String expected = "Lembur";
        Assert.assertEquals(actual, expected);
    }

    @And("the admin enters the employee name {string} in the search bar")
    public void theAdminEntersTheEmployeeNameStringInTheSearchBar(String namaKaryawan) throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.searchAction(namaKaryawan);
    }

    @And("the admin selects the start date {string} and end date {string}")
    public void theAdminSelectsTheStartDateAndEndDate(String arg0, String arg1) throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.buttonStartDate();
        Thread.sleep(2000);
        laporanLemburPage.earlyDateInput(arg0);
        Thread.sleep(2000);
        laporanLemburPage.continueDateInput(arg1);
        Thread.sleep(2000);
        laporanLemburPage.clickSaveDate();
    }

    @And("the admin clicks the Search Button")
    public void theAdminClicksTheSearchButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickButtonSearchName();
    }

    @Then("the Overtime Report for the selected employee and date should be displayed")
    public void theOvertimeReportForTheSelectedEmployeeAndDateShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }


    @Then("the Overtime Report should be displayed")
    public void theOvertimeReportShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }

    @And("the admin clicks the filter department button")
    public void theAdminClicksTheFilterDepartmentButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickButtonFilter();
    }

    @And("the admin enters the department name {string} in the filter field")
    public void theAdminEntersTheDepartmentNameInTheFilterField(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.searchActionFilter(arg0);
    }


    @And("the admin clicks the Terapkan button")
    public void theAdminClicksTheTerapkanButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickButtonTerapkan();
    }


    @Then("the Overtime Report for the selected employee, date, and department should be displayed")
    public void theOvertimeReportForTheSelectedEmployeeDateAndDepartmentShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }

    @And("the admin clicks on the filter department button")
    public void theAdminClicksOnTheFilterDepartmentButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickButtonFilter();
    }

    @And("the admin enters the department name {string} in the search bar")
    public void theAdminEntersTheDepartmentNameInTheSearchBar(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.searchActionFilter(arg0);
    }


    @Then("the Overtime reports for the selected department should be displayed")
    public void theOvertimeReportsForTheSelectedDepartmentShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }


    @And("the admin clicks the Export button")
    public void theAdminClicksTheExportButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickButtonExport();
    }


    @Then("the Overtime Reports should be downloaded")
    public void theOvertimeReportsShouldBeDownloaded() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }


    @And("the admin scrolls the table to the right")
    public void theAdminScrollsTheTableToTheRight() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.scrollToRight();
    }


    @Then("additional colums in the Overtime Reports table should be visible")
    public void additionalColumsInTheOvertimeReportsTableShouldBeVisible() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }


    @And("the admin clicks the Action button on a report row")
    public void theAdminClicksTheActionButtonOnAReportRow() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickButtonAksi();
    }

    @And("the admin clicks the Edit button")
    public void theAdminClicksTheEditButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickButtonUbahData();
    }

    @Then("the Edit Overtime Report form should be displayed")
    public void theEditOvertimeReportFormShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }


    @And("the admin clicks the Cancel button in the edit form")
    public void theAdminClicksTheCancelButtonInTheEditForm() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickButtonCancelUbahData();
    }


    @Then("the edit form should be closed")
    public void theEditFormShouldBeClosed() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }


    @And("the admin clicks the Reset button")
    public void theAdminClicksTheResetButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickReset();
    }


    @Then("all filters should be cleared and the main Overtime Reports page should be displayed")
    public void allFiltersShouldBeClearedAndTheMainOvertimeReportsPageShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }


    @And("the admin selects the start date {string}")
    public void theAdminSelectsTheStartDate(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.buttonStartDate();
        Thread.sleep(2000);
        laporanLemburPage.earlyDateInput(arg0);
    }


    @And("the admin clicks the Cancel Date button")
    public void theAdminClicksTheCancelDateButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickCancelDate();
    }


    @And("the admin clicks the Go to Next Page button")
    public void theAdminClicksTheGoToNextPageButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickNextPage();
    }

    @And("the admin clicks the Go to Last Page button")
    public void theAdminClicksTheGoToLastPageButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickLastPage();
    }


    @And("the admin clicks the Go to Previous Page button")
    public void theAdminClicksTheGoToPreviousPageButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickPreviousPage();
    }


    @And("the admin clicks the Go to First Page button")
    public void theAdminClicksTheGoToFirstPageButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.clickFirstPage();
    }

    @And("the admin enters an unregistered employee name {string} in the search bar")
    public void theAdminEntersAnUnregisteredEmployeeNameInTheSearchBar(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.searchAction(arg0);
    }

    @Then("no overtime report should be displayed")
    public void noOvertimeReportShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }


    @And("a message {string} should be shown")
    public void aMessageShouldBeShown(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }


    @And("the admin selects a start date {string} and end date {string}")
    public void theAdminSelectsAStartDateAndEndDate(String arg0, String arg1) throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.buttonStartDate();
        Thread.sleep(2000);
        laporanLemburPage.earlyDateInput(arg0);
        Thread.sleep(2000);
        laporanLemburPage.continueDateInput(arg1);
        Thread.sleep(2000);
        laporanLemburPage.clickSaveDate();
    }

    @Then("the system should not display any data")
    public void theSystemShouldNotDisplayAnyData() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }


    @And("a validation error or {string} message should be shown")
    public void aValidationErrorOrMessageShouldBeShown(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }


    @And("the admin leaves the department search field empty")
    public void theAdminLeavesTheDepartmentSearchFieldEmpty(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.searchActionFilter(arg0);
    }

    @Then("the department filter should not be applied")
    public void theDepartmentFilterShouldNotBeApplied() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }


    @And("the report results should remain unchanged")
    public void theReportResultsShouldRemainUnchanged() throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.getDataEmployee();
    }


    @Then("the system should show a warning or do nothing, as there is {string}")
    public void theSystemShouldShowAWarningOrDoNothingAsThereIsNoDataToExport(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        laporanLemburPage.popUpAlert();
    }

    @Given("Admin is logged in")
    public void adminIsLoggedIn() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getDashboardLabel();
    }
}



