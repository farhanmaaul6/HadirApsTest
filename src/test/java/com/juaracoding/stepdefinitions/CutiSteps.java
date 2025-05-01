package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.importpage.cuti.CutiPage;
import com.juaracoding.pages.importpage.ImportPage;
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

public class CutiSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private ImportPage importPage;
    private CutiPage cutiPage;

    public CutiSteps(){
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        importPage = new ImportPage(driver);
        cutiPage = new CutiPage(driver);

        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("Admin is on the dashboard for Cuti")
    public void adminIsOnTheDashboardForStatusAktif() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getDashboardLabel();
    }

    @When("Admin navigates to Import > Cuti")
    public void adminNavigatesToImportCuTi() throws InterruptedException {
        Thread.sleep(2000);
        cutiPage.openCutiTab();
        String actual = cutiPage.getCutiLabel();
        String expected = "Import Cuti";
        Assert.assertEquals(actual,expected);
    }

    @And("Admin clicks Download Template Cuti")
    public void adminClicksDownloadTemplateCuti() throws  InterruptedException {
        Thread.sleep(2000);
        importPage.buttonDownload();
    }

    @Then("Template for Cuti should be downloaded")
    public void templateForCutiShouldBeDownloaded() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Template for Cuti should be Downloaded");
    }

    @When("Admin uploads valid cuti template files")
    public void adminUploadsValidCutiTemplateFiles() throws InterruptedException {
        String fileValidPath = "C:\\Users\\Balbo\\Downloads\\DataTest\\Data_Cuti_VALID.xlsx";
        File validFile = new File(fileValidPath);
        Thread.sleep(2000);
        cutiPage.buttonChooseFileCuti().sendKeys(validFile.getAbsolutePath());
        Thread.sleep(5000);
        importPage.buttonImport();
    }

    @Then("Cuti data should be imported successfully")
    public void cutiDataShouldBeImportedSuccesfully() throws InterruptedException{
        Thread.sleep(2000);
        importPage.popUp();
    }

    //negative
    @And("Admin clicks Import without select a file")
    public void adminClicksImportWithoutSelectAFile() throws InterruptedException{
        Thread.sleep(2000);
        importPage.buttonImport();
    }

    @Then("Error Message should be show for missing file in cuti")
    public void errorMessageShouldBeShowForMissingFileInCuti() throws InterruptedException {
        Thread.sleep(2000);
        String actual = cutiPage.getValidateMessageCuti();
        String expected = "Please select a file.";
        Assert.assertEquals(actual, expected);
    }

    @When("Admin uploads incorrect Cuti template file")
    public void adminUploadsIncorrectCutiTemplateFile() throws InterruptedException {
        String fileInvalidPath = "C:\\Users\\Balbo\\Downloads\\DataTest\\Data_Cuti_INVALID.xlsx";
        File invalidFile = new File(fileInvalidPath);
        Thread.sleep(2000);
        cutiPage.buttonChooseFileCuti().sendKeys(invalidFile.getAbsolutePath());
        Thread.sleep(2000);
        importPage.buttonImport();
    }

    @Then("Error message should be show for invalid format in Cuti")
    public void errorMessageShouldBeShowForInvalidFormatInCuti() throws InterruptedException {
        Thread.sleep(2000);
        importPage.popUp();
    }

    @When("Admin uploads non-excel file for cuti")
    public void adminUploadsNonExcelFileForCuti() throws InterruptedException {
        String fileErrorPath = "C:\\Users\\Balbo\\Downloads\\DataTest\\Data_Cuti_VALID.pdf";
        File errorFile = new File(fileErrorPath);
        Thread.sleep(2000);
        cutiPage.buttonChooseFileCuti().sendKeys(errorFile.getAbsolutePath());
        Thread.sleep(2000);
        importPage.buttonImport();
    }

    @Then("Error message should be show for file type in cuti")
    public void errorMessageShouldBeShowForFileTypeInCuti() throws InterruptedException {
        Thread.sleep(2000);
        cutiPage.getHelperTextCuti();
    }
}
