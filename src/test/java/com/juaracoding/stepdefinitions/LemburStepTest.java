package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.laporanpage.LaporanPage;
import com.juaracoding.pages.laporanpage.lembur.LemburPage;
import com.juaracoding.pages.loginpage.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class LemburStepTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private LaporanPage laporanPage;
    private LemburPage lemburPage;

    public LemburStepTest() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        laporanPage = new LaporanPage(driver);
        lemburPage = new LemburPage(driver);

        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("Admin is logged in and on the dashboard for Laporan Lembur")
    public void adminIsOnTheDashboardForLaporanLembur() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getDashboardLabel();
    }

    @When("Admin navigates to the Overtime report page")
    public void adminNavigatesToTheOvertimeReportPage() throws InterruptedException {
        Thread.sleep(2000);
        laporanPage.openLaporanMenu();
        Thread.sleep(2000);
        lemburPage.clickLemburTab();
        String actual = lemburPage.getLemburLabel();
        String expected = "Lembur";
        Assert.assertEquals(actual, expected);
    }

    @Then("Overtime report data should be shown by employee name")
    public void overtimeReportDataShouldBeShownByEmployeeName() throws InterruptedException {
        Thread.sleep(2000);
        lemburPage.getDataEmployee();
    }

    @Then("Overtime report data should be shown by date")
    public void overtimeReportDataShouldBeShownByDate() throws InterruptedException {
        Thread.sleep(2000);
        lemburPage.getDataEmployee();
    }

    @Then("Overtime report data should be shown by name and date")
    public void overtimeReportDataShouldBeShownByNameAndDate() throws InterruptedException {
        Thread.sleep(2000);
        lemburPage.getDataEmployee();
    }

    @Then("Overtime report data should be shown by unit name")
    public void overtimeReportDataShouldBeShownByUnitName() throws InterruptedException {
        Thread.sleep(2000);
        lemburPage.getDataEmployee();
    }

    @When("Admin clicks the Export button")
    public void adminClicksTheExportButton() throws InterruptedException {
        Thread.sleep(2000);
        lemburPage.clickButtonExport();
    }

    @Then("Overtime report file should be downloaded")
    public void overtimeReportFileShouldBeDownloaded() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Overtime report file should be downloaded");
    }

    @When("Admin clicks the Action button")
    public void adminClicksTheActionButton() throws InterruptedException {
        Thread.sleep(2000);
        lemburPage.clickButtonAksi();
    }

    @And("Admin clicks the Edit Supervisor button")
    public void adminClicksTheEditSupervisorButton() throws InterruptedException {
        Thread.sleep(2000);
        lemburPage.clickButtonUbahData();
    }

    @Then("Supervisor information should be updated")
    public void supervisorInformationShouldBeUpdated() throws InterruptedException {
        Thread.sleep(2000);
        lemburPage.getDataEmployee();
    }

    //Negative
    @Then("No overtime report data should be displayed")
    public void noOvertimeReportDataShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        try {
            String text = lemburPage.getInvalidDataEmployee();
            Assert.assertFalse(text.isEmpty(), "0-0 of 0");
        } catch (Exception e) {
            System.out.println("500 | Internal Server Error.");
        }
    }

    @Then("Export file should not be generated")
    public void exportFileShouldNotBeGenerated() {
        laporanPage.popUpUpdate();
    }
}
