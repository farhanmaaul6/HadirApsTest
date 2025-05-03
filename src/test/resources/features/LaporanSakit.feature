Feature: Laporan Sakit

  Background:
    Given Admin is logged in and on to the dashboard for Laporan Sakit

  @auth @eben
  Scenario: Search sick leave reports by employee name and date range
    When User navigates to Laporan Sakit Page
    And Admin inputs "Hadir SQA Testing 1" in the search name field
    And Admin click search button sakit
    And Admin input start date sakit "Feb 1, 2025" and end date "Feb 28, 2025"
    And Admin click search button sakit
    Then Sick leave reports data should be displayed based on name and date range
    And Admin clicks on the Reset Button
    Then All filters should be default data

  @auth @eben
  Scenario: Search sick leave reports by employee name and reset filter
    When User navigates to Laporan Sakit Page
    And Admin inputs "Elva" in the search name field
    And Admin click search button sakit
    Then Sick leave reports data should be displayed based on name
    And Admin clicks on the Reset Button
    Then All filters should be default data

  @auth @eben
  Scenario: Combination of search name, start date and end date, filter unit department
    When User navigates to Laporan Sakit Page
    And Admin clicks filter department button
    And Admin inputs unit name "IT Programmer" for filter department
    And Admin clicks the Apply filter departement button
    Then Sick leave reports data should be displayed based on department
    And Admin clicks on unit combobox
    And Admin click on next page
    And Admin clicks on the Reset Button
    And Admin inputs "Hadir SQA Testing 2" in the search name field
    And Admin click search button sakit
    Then Sick leave reports data should be displayed based on name

  @auth @eben
  Scenario: Admin would like to view and download Sick Leave Reports
    When User navigates to Laporan Sakit Page
    And Admin inputs "Elva" in the search name field
    And Admin clicks view and download surat sakit
    Then Admin can see the downloaded file
