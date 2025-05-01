package com.juaracoding.pages.laporanpage.koreksi;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KoreksiPage {
    @FindBy(xpath = "//p[normalize-space()='Laporan']")
    private WebElement laporanMenu;

    @FindBy(xpath = "//p[normalize-space()='Koreksi']")
    private WebElement koreksiTab;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchBar;
}
