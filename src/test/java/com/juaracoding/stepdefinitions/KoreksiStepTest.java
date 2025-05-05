package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.KoreksiPage;
import com.juaracoding.pages.LaporanPage;
import com.juaracoding.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class KoreksiStepTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private LaporanPage laporanPage;
    private KoreksiPage koreksiPage;

    public KoreksiStepTest() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        laporanPage = new LaporanPage(driver);
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
        laporanPage.openLaporanMenu();
        Thread.sleep(2000);
        koreksiPage.openKoreksiTab();
        String actual = koreksiPage.getKoreksiLabel();
        String expected = "Koreksi";
        Assert.assertEquals(actual,expected);
    }

    @Then("Correction report data should be shown by employee name")
    public void correctionReportDataShouldBeShownByEmployeeName() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    @Then("The correction data within the selected date range is displayed")
    public void theCorrectionDataWithinTheSelectedDateRangeIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    @Then("The correction data filtered by name and date is displayed")
    public void theCorrectionDataFilteredByNameAndDateIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    @Then("The correction data related to the unit name is displayed")
    public void theCorrectionDataRelatedToTheUnitNameIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    @When("Admin clicks the Approve button for the first correction")
    public void adminClicksTheApproveButtonForTheFirstCorrection() throws InterruptedException {
        Thread.sleep(2000);
        laporanPage.goToNextPage();
        Thread.sleep(2000);
        koreksiPage.buttonApprove();
    }

    @And("Admin clicks the Confirm button")
    public void adminClicksTheConfirmButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonConfirm();
    }

    @Then("A success popup should appear")
    public void aSuccessPopupShouldAppear() throws InterruptedException {
        Thread.sleep(2000);
        laporanPage.popUpUpdate();
    }

    @When("Admin clicks the Reject button for the first correction")
    public void adminClicksTheRejectButtonForTheFirstCorrection() throws InterruptedException {
        Thread.sleep(2000);
        laporanPage.goToNextPage();
        Thread.sleep(2000);
        koreksiPage.buttonReject();
    }

    @And("Admin inputs rejection reason {string}")
    public void adminInputsRejectionReason(String reason) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.rejectReason(reason);
    }

    @And("Admin clicks the Submit rejection button")
    public void adminClicksTheSubmitRejectionButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonConfirm();
    }

    //Negative
    @Then("No correction data should be displayed")
    public void noCorrectionDataShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        String actual = koreksiPage.getInvalidDataEmployee();
        String expected = "0-0 of 0";
        Assert.assertEquals(actual, expected);
    }

    @And("Admin clicks the Submit rejection button without reason")
    public void adminClicksTheSubmitRejectionButtonWithoutReason() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonConfirm();
    }

    @Then("A validation error should appear indicating reason is required")
    public void aValidationErrorShouldAppearIndicatingReasonIsRequired() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getValidateMessage();
        Thread.sleep(2000);
    }
}