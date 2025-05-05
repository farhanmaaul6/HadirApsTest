package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.importpage.ImportPage;
import com.juaracoding.pages.importpage.statusaktif.StatusAktifPage;
import com.juaracoding.pages.loginpage.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

public class StatusAktifSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private ImportPage importPage;
    private StatusAktifPage statusAktifPage;


    public StatusAktifSteps() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        importPage = new ImportPage(driver);
        statusAktifPage = new StatusAktifPage(driver);

        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("Admin is on the dashboard for Status Aktif")
    public void adminIsOnTheDashboardForStatusAktif() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getDashboardLabel();
    }

    @When("Admin navigates to Import > Status Aktif")
    public void adminNavigateToImportStatusAktif() throws InterruptedException {
        Thread.sleep(2000);
        statusAktifPage.openStatusAktifTab();
        String actual = statusAktifPage.getStatusAktifLabel();
        String expected = "Import Status Aktif";
        Assert.assertEquals(actual, expected);
    }

    @And("Admin clicks Download Template Status Aktif")
    public void adminClicksDownloadTemplate() throws InterruptedException {
        Thread.sleep(2000);
        importPage.buttonDownload();
    }

    @Then("Template for Status Aktif should be downloaded")
    public void templateForStatusAktifShouldBeDownloaded() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Template for Status Aktif should be downloaded");
    }

    @When("Admin uploads valid status aktif template file")
    public void adminUploadsValidStatusAktifTemplateFile() throws InterruptedException {
        String fileValidPath = "src/test/resources/DataTest/DATA_STATUS_USER_VALID.xlsx";
        File validFile = new File(fileValidPath);
        Thread.sleep(2000);
        importPage.buttonChooseFile().sendKeys(validFile.getAbsolutePath());
        Thread.sleep(5000);
        importPage.buttonImport();
    }

    @Then("Status aktif data should be imported successfully")
    public void statusAktifDataShouldBeImportedSuccesfully() throws InterruptedException {
        Thread.sleep(2000);
        importPage.popUp();
    }

    //Negative
    @And("Admin clicks Import without choosing a file")
    public void adminClicksImportWithoutChoosingFile() throws InterruptedException {
        Thread.sleep(2000);
        importPage.buttonImport();
    }

    @Then("Error message should be shown for missing file in the Status Aktif")
    public void errorMessageShouldBeShownForMissingFile() throws InterruptedException {
        Thread.sleep(2000);
        String actual = importPage.getValidateMessage();
        String expected = "Please select a file.";
        Assert.assertEquals(actual, expected);
    }

    @When("Admin uploads incorrect status aktif template file")
    public void adminUploadsIncorrectStatusAktifTemplateFile() throws InterruptedException {
        String fileInvalidPath = "src/test/resources/DataTest/DATA_STATUS_USER_INVALID.xlsx";
        File invalidFile = new File(fileInvalidPath);
        Thread.sleep(2000);
        importPage.buttonChooseFile().sendKeys(invalidFile.getAbsolutePath());
        Thread.sleep(2000);
        importPage.buttonImport();
    }

    @Then("Error message should be shown for invalid format in Status Aktif")
    public void errorMessageShouldBeShownForInvalidFormat() throws InterruptedException {
        Thread.sleep(2000);
        importPage.popUp();
    }

    @When("Admin uploads non-Excel file for status aktif")
    public void adminUploadsNonExcelFileForStatusAktif() throws InterruptedException {
        String fileErrorPath = "src/test/resources/DataTest/DATA_STATUS_USER.pdf";
        File errorFile = new File(fileErrorPath);
        Thread.sleep(2000);
        importPage.buttonChooseFile().sendKeys(errorFile.getAbsolutePath());
        Thread.sleep(2000);
        importPage.buttonImport();
    }

    @Then("Error message should be shown for file type in Status Aktif")
    public void errorMessageShouldBeShownForFileType() throws InterruptedException {
        Thread.sleep(2000);
        importPage.getHelperText();
    }
}
