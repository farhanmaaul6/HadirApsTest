package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.importpage.ImportPage;
import com.juaracoding.pages.importpage.StrukturUserPage;
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

public class StrukturUserSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private ImportPage importPage;
    private StrukturUserPage strukturUserPage;

    public StrukturUserSteps() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        importPage = new ImportPage(driver);
        strukturUserPage = new StrukturUserPage(driver);

        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("Admin is on the dashboard for Struktur User")
    public void adminIsOnTheDashboardForStrukturUser() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getDashboardLabel();
    }

    @When("Admin navigates to Import > Struktur User")
    public void adminNavigateToImportStrukturUser() throws InterruptedException {
        Thread.sleep(200);
        strukturUserPage.openStrukturUserTab();
        String actual = strukturUserPage.getStrukturUserLabel();
        String expected = "Import Struktur User";
        Assert.assertEquals(actual, expected);
    }

    @And("Admin clicks Download Template Struktur User")
    public void adminClicksDownloadTemplate() throws InterruptedException {
        Thread.sleep(1000);
        importPage.buttonDownload();
    }

    @Then("Template for Struktur User should be downloaded")
    public void templateForStrukturUserShouldBeDownloaded() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Template for Status Aktif should be downloaded");
    }

    @When("Admin uploads valid struktur user template file")
    public void adminUploadsValidStrukturUserTemplateFile() throws InterruptedException {
        String fileValidPath = "src/test/resources/DataTest/DATA_STRUKTUR_USER_VALID.xlsx";
        File validFile = new File(fileValidPath);
        Thread.sleep(2000);
        importPage.buttonChooseFile().sendKeys(validFile.getAbsolutePath());
        Thread.sleep(5000);
        importPage.buttonImport();
    }

    @Then("Struktur user data should be imported successfully")
    public void strukturUserDataShouldBeImportedSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        importPage.popUp();
    }

    //Negative
    @And("Admin clicks Import Struktur User without choosing a file")
    public void adminClicksImportWithoutChoosingFile() throws InterruptedException {
        Thread.sleep(2000);
        importPage.buttonImport();
    }

    @Then("Error message should be shown for missing file in the Struktur User")
    public void errorMessageShouldBeShownForMissingFile() throws InterruptedException {
        Thread.sleep(2000);
        String actual = importPage.getValidateMessage();
        String expected = "Please select a file.";
        Assert.assertEquals(actual, expected);
    }

    @When("Admin uploads incorrect struktur user template file")
    public void adminUploadsIncorrectStrukturUserTemplateFile() throws InterruptedException {
        String fileInvalidPath = "src/test/resources/DataTest/DATA_STRUKTUR_USER_INVALID.xlsx";
        File invalidFile = new File(fileInvalidPath);
        Thread.sleep(2000);
        importPage.buttonChooseFile().sendKeys(invalidFile.getAbsolutePath());
        Thread.sleep(2000);
        importPage.buttonImport();
    }

    @Then("Error message should be shown for invalid format in Struktur User")
    public void errorMessageShouldBeShownForInvalidFormat() throws InterruptedException {
        Thread.sleep(2000);
        importPage.popUp();
    }

    @When("Admin uploads non-Excel file for struktur user")
    public void adminUploadsNonExcelFileForStrukturUser() throws InterruptedException {
        String fileErrorPath = "src/test/resources/DataTest/DATA_STRUKTUR_USER.pdf";
        File errorFile = new File(fileErrorPath);
        Thread.sleep(2000);
        importPage.buttonChooseFile().sendKeys(errorFile.getAbsolutePath());
        Thread.sleep(2000);
        importPage.buttonImport();
    }

    @Then("Error message should be shown for file type in Struktur User")
    public void errorMessageShouldBeShownForFileType() throws InterruptedException {
        Thread.sleep(2000);
        importPage.getHelperText();
    }
}
