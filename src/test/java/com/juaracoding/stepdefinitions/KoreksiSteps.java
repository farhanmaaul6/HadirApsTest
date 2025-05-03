package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.laporanpage.koreksi.KoreksiPage;
import com.juaracoding.pages.loginpage.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class KoreksiSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private KoreksiPage koreksiPage;

    public KoreksiSteps() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        koreksiPage = new KoreksiPage(driver);

        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("Admin is logged in and on the dashboard for Laporan Koreksi")
    public void adminIsOnTheDashboardForStrukturUser() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getDashboardLabel();
    }

    @When("Admin navigates to Correction Report")
    public void adminNavigatesToCorrectionReport() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.openLaporanMenu();
        Thread.sleep(2000);
        koreksiPage.openKoreksiTab();
        String actual = koreksiPage.getKoreksiLabel();
        String expected = "Koreksi";
        Assert.assertEquals(actual,expected);
    }

    @And("Admin inputs {string} in the search field")
    public void adminInputsInTheSearchField(String searchTerm) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.searchAction(searchTerm);
    }

    @And("Admin selects start date {string} and end date {string}")
    public void adminSelectsStartDateAndEndDate(String date0, String date1) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonStartDate();
        Thread.sleep(2000);
        koreksiPage.earlyDateInput(date0);
        Thread.sleep(2000);
        koreksiPage.continueDateInput(date1);
        Thread.sleep(2000);
        koreksiPage.buttonSaveDate();
    }

    @And("Admin clicks the Search button")
    public void adminClicksTheSearchButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonSearch();
    }

    @Then("Correction data should be displayed based on the name and date range")
    public void correctionDataShouldBeDisplayedBasedOnTheNameAndDateRange() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    @When("Admin clicks the Filter button")
    public void adminClicksTheFilterButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonFilter();
    }

    @And("Admin inputs unit name {string}")
    public void adminInputsUnitName(String unitTerm) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.searchFilterAction(unitTerm);
    }

    @And("Admin clicks the Apply filter button")
    public void adminClicksTheApplyFilterButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonTerapkanFilter();
    }

    @Then("Correction data should be displayed only from the selected unit")
    public void correctionDataShouldBeDisplayedOnlyFromTheSelectedUnit() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    @When("Admin clicks the Approve button for the first correction")
    public void adminClicksTheApproveButtonForTheFirstCorrection() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.goToNextPage();
        Thread.sleep(2000);
        koreksiPage.buttonApprove();
    }

    @And("Admin clicks the Confirm button")
    public void adminClicksTheConfirmButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonConfirm();
    }

    @Then("A success popup should appear with message {string}")
    public void aSuccessPopupShouldAppearWithMessage(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.popUpUpdate();
    }

    @When("Admin clicks the Reject button for the first correction")
    public void adminClicksTheRejectButtonForTheFirstCorrection() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.goToNextPage();
        Thread.sleep(2000);
        koreksiPage.buttonReject();
    }

    @And("Admin inputs rejection reason {string}")
    public void adminInputsRejectionReason(String reasonTerm) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.rejectReason(reasonTerm);
    }

    @And("Admin clicks the Submit rejection button")
    public void adminClicksTheSubmitRejectionButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonConfirm();
    }

    @When("Admin clicks the Reset button")
    public void adminClicksTheResetButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonReset();
    }

    @Then("All filters should be cleared and default data should be displayed")
    public void allFiltersShouldBeClearedAndDefaultDataShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    //Negative
    @And("Admin clicks the Search button without entering any filter")
    public void adminClicksTheSearchButtonWithoutEnteringAnyFilter() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonSearch();
    }

    @Then("No correction data should be displayed or an alert message should appear")
    public void noCorrectionDataShouldBeDisplayedOrAnAlertMessageShouldAppear() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    @And("Admin inputs invalid unit name {string}")
    public void adminInputsInvalidUnitName(String unitTerm) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.searchFilterAction(unitTerm);
    }

    @Then("No correction data should be displayed or an alert should appear")
    public void noCorrectionDataShouldBeDisplayedOrAnAlertShouldAppear() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    @And("Admin clicks the Submit rejection button without reason")
    public void adminClicksTheSubmitRejectionButtonWithoutReason() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonConfirm();
    }

    @Then("An alert popup should appear with message {string}")
    public void anAlertPopupShouldAppearWithMessage(String arg0) {
        koreksiPage.getValidateMessage();
    }
}
