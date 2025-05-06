Feature: Positive Test Sick Report

  Background:
    Given Admin is logged in and on the dashboard for Laporan Sakit

  @auth @positive
  Scenario: Search sick report by date
    When Admin navigates to the Sick report page
    And Admin selects start date "Jan 1, 2024" and end date "Mar 31, 2024"
    And Admin clicks the Search button
    Then Sick report data should be shown by date

  @auth @positive
  Scenario: Search sick report by employee name
    When Admin clicks the Reset button
    And Admin inputs "Hadir SQA Testing 1" in the search field
    And Admin clicks the Search button
    Then Sick report data should be shown by employee name

  @auth @positive
  Scenario: Search sick report by unit name
    When Admin clicks the Reset button
    And Admin clicks the Filter button
    And Admin inputs unit name "IT Programmer"
    And Admin clicks the Apply button
    Then Sick report data should be shown by unit name

  @auth @positive
  Scenario: Search sick report by name and date
    When Admin clicks the Reset button
    And Admin inputs "Elva" in the search field
    And Admin selects start date "Jan 1, 2024" and end date "Jan 31, 2024"
    And Admin clicks the Search button
    Then Sick report data should be shown by name and date

  @auth @positive
  Scenario: View sick evidence
    When Admin clicks the View button on a sick report
    Then Sick evidence has been displayed and closed

  @auth @positive
  Scenario: Download sick evidence
    When Admin clicks the Download button on a sick report
    Then Sick evidence file should be downloaded