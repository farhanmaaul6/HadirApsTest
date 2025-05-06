package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.laporanpage.LaporanPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LaporanStepTest {
    private WebDriver driver;
    private LaporanPage laporanPage;

    public LaporanStepTest() {
        driver = DriverSingleton.getDriver();
        laporanPage = new LaporanPage(driver);

        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("Admin inputs {string} in the search field")
    public void adminInputsInTheSearchField(String name) throws InterruptedException {
        Thread.sleep(2000);
        laporanPage.searchAction(name);
    }

    @And("Admin clicks the Search button")
    public void adminClicksTheSearchButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanPage.buttonSearch();
    }

    @When("Admin clicks the Reset button")
    public void adminClicksTheResetButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanPage.buttonReset();
    }

    @And("Admin selects start date {string} and end date {string}")
    public void adminSelectsStartDateAndEndDate(String startDate, String endDate) throws InterruptedException {
        Thread.sleep(2000);
        laporanPage.buttonStartDate();
        Thread.sleep(2000);
        laporanPage.earlyDateInput(startDate);
        Thread.sleep(2000);
        laporanPage.continueDateInput(endDate);
        Thread.sleep(2000);
        laporanPage.buttonSaveDate();
    }

    @And("Admin clicks the Filter button")
    public void adminClicksTheFilterButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanPage.buttonFilter();
    }

    @And("Admin inputs unit name {string}")
    public void adminInputsUnitName(String unitName) throws InterruptedException {
        Thread.sleep(2000);
        laporanPage.searchFilterActionValid(unitName);
    }

    @And("Admin clicks the Apply button")
    public void adminClicksTheApplyButton() throws InterruptedException {
        Thread.sleep(2000);
        laporanPage.buttonTerapkanFilter();
    }

    @And("Admin inputs invalid unit name {string}")
    public void adminInputsInvalidUnitName(String unitName) throws InterruptedException {
        Thread.sleep(2000);
        laporanPage.searchFilterActionInvalid(unitName);
    }
}
