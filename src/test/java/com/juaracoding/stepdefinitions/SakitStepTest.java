package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.LaporanPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.SakitPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class SakitStepTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private LaporanPage laporanPage;
    private SakitPage sakitPage;

    public SakitStepTest() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        laporanPage = new LaporanPage(driver);
        sakitPage = new SakitPage(driver);

        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("Admin is logged in and on the dashboard for Laporan Sakit")
    public void adminIsOnTheDashboardForLaporanSakit() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getDashboardLabel();
    }

    @When("Admin navigates to the Sick report page")
    public void adminNavigatesToTheSickReportPage() throws InterruptedException {
        Thread.sleep(2000);
        laporanPage.openLaporanMenu();
        Thread.sleep(2000);
        sakitPage.clickMenuSakit();
        String actual = sakitPage.getSakitLabel();
        String expected = "Sakit";
        Assert.assertEquals(actual, expected);
    }

    @Then("Sick report data should be shown by employee name")
    public void sickReportDataShouldBeShownByEmployeeName() throws InterruptedException {
        Thread.sleep(2000);
        sakitPage.getDataEmployee();
    }

    @Then("Sick report data should be shown by date")
    public void sickReportDataShouldBeShownByDate() throws InterruptedException {
        Thread.sleep(2000);
        sakitPage.getDataEmployee();
    }

    @Then("Sick report data should be shown by name and date")
    public void sickReportDataShouldBeShownByNameAndDate() throws InterruptedException {
        Thread.sleep(2000);
        sakitPage.getDataEmployee();
    }

    @Then("Sick report data should be shown by unit name")
    public void sickReportDataShouldBeShownByUnitName() throws InterruptedException {
        Thread.sleep(2000);
        sakitPage.getDataEmployee();
    }

    @When("Admin clicks the View button on a sick report")
    public void adminClicksTheViewButtonOnASickReport() throws InterruptedException {
        Thread.sleep(2000);
        sakitPage.clickViewSurat();
        Thread.sleep(2000);
    }

    @Then("Sick evidence has been displayed and closed")
    public void sickEvidenceHasBeenDisplayedAndClosed() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Sick evidence has been displayed and closed");
    }

    @When("Admin clicks the Download button on a sick report")
    public void adminClicksTheDownloadButtonOnASickReport() throws InterruptedException {
        Thread.sleep(2000);
        sakitPage.clickDownloadSuratSakit();
    }

    @Then("Sick evidence file should be downloaded")
    public void sickEvidenceFileShouldBeDownloaded() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Sick evidence file should be downloaded");
    }

    @Then("No sick report data should be displayed")
    public void noSickReportDataShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        String actual = sakitPage.getInvalidDataEmployee();
        String expected = "0-0 of 0";
        Assert.assertEquals(actual, expected);
    }
}
