package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.ImportPage;
import com.juaracoding.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

public class AbsenSteps {
    private WebDriver driver;
    private ImportPage importPage;
    private LoginPage loginPage;

    public AbsenSteps() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        importPage = new ImportPage(driver);

        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("Admin is on the dashboard page for Absen")
    public void adminIsOnTheDashboardPageForAbsen() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getDashboardLabel();
    }

    @When("Admin navigates to Import > Absen")
    public void adminNavigatesToImportAbsen() throws InterruptedException {
        Thread.sleep(2000);
        importPage.openImportMenu();
        Thread.sleep(2000);
        importPage.openAbsenTab();
        String actual = importPage.getAbsenLabel();
        String expected = "Import Absen";
        Assert.assertEquals(actual,expected);
    }

    @And("Admin clicks download template for Absen")
    public void adminClicksDownloadTemplateForAbsen() throws InterruptedException {
        Thread.sleep(2000);
        importPage.buttonDownload();
    }

    @Then("Template for Absen should be downloaded")
    public void templateForAbsenShouldBeDownloaded() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Template for absen should be downloaded");
    }

    @And("Admin uploads valid absen template file")
    public void adminUploadsValidAbsenTemplateFile() throws InterruptedException {
        String fileValidPath = "C:\\Users\\Balbo\\Downloads\\DATA_STATUS_USER_VALID.xlsx";
        File validFile = new File(fileValidPath);
        Thread.sleep(2000);
        importPage.buttonChooseFile().sendKeys(validFile.getAbsolutePath());
        Thread.sleep(5000);
        importPage.buttonImport();
    }

    @Then("Absen should be imported successfully")
    public void absenShouldBeImportedSuccesfully() throws InterruptedException {
        Thread.sleep(2000);
        importPage.popUp();
    }

    //negative
    @And("Admin clicks import without choose a file")
    public void adminClicksImportWithoutChooseAFile() throws InterruptedException {
        Thread.sleep(2000);
        importPage.buttonImport();
    }

    @Then("Error message should be shown for missing file in Absen")
    public void errorMessageShouldBeShownForMissingFileInAbsen() throws InterruptedException {
        Thread.sleep(2000);
        String actual = importPage.getValidateMessage();
        String expected = "Please select a file.";
        Assert.assertEquals(actual, expected);
    }

    @When("Admin uploads incorrect Absen template file")
    public void adminUploadsIncorrectAbsenTemplateFile() throws InterruptedException {
        String fileInvalidPath = "C:\\Users\\Balbo\\Downloads\\DATA_STATUS_USER_INVALID.xlsx";
        File invalidFile = new File(fileInvalidPath);
        Thread.sleep(2000);
        importPage.buttonChooseFile().sendKeys(invalidFile.getAbsolutePath());
        Thread.sleep(2000);
        importPage.buttonImport();
    }

    @Then("Error message should be show for invalid format in Absen")
    public void errorMessageShouldBeShowForInvalidFormatInAbsen() throws InterruptedException {
        Thread.sleep(2000);
        importPage.popUp();
    }

    @When("Admin uploads non-Excel file for Absen")
    public void adminUploadsNonExcelFileForAbsen() throws InterruptedException {
        String fileErrorPath = "C:\\Users\\Balbo\\Downloads\\DATA_STATUS_USER.pdf";
        File errorFile = new File(fileErrorPath);
        Thread.sleep(2000);
        importPage.buttonChooseFile().sendKeys(errorFile.getAbsolutePath());
        Thread.sleep(2000);
        importPage.buttonImport();
    }

    @Then("Error message should be show for file type in Absen")
    public void errorMessageShouldBeShowForFileTypeInAbsen() throws InterruptedException {
        Thread.sleep(2000);
        importPage.getHelperText();
    }
}
