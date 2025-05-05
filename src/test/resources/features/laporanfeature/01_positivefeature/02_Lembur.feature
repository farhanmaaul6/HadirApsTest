Feature: Positive Test Overtime Report

  Background:
    Given Admin is logged in and on the dashboard for Laporan Lembur

  @auth @positive
  Scenario: Search overtime by date
    When Admin navigates to the Overtime report page
    And Admin selects start date "Jan 1, 2024" and end date "Mar 31, 2024"
    And Admin clicks the Search button
    Then Overtime report data should be shown by date

  @auth @positive
  Scenario: Search overtime by employee name
    When Admin clicks the Reset button
    And Admin inputs "Agung Aji Nugraha" in the search field
    And Admin clicks the Search button
    Then Overtime report data should be shown by employee name

  @auth @positive
  Scenario: Search overtime by unit name
    When Admin clicks the Reset button
    And Admin clicks the Filter button
    And Admin inputs unit name "IT Programmer"
    And Admin clicks the Apply button
    Then Overtime report data should be shown by unit name

  @auth @positive
  Scenario: Search overtime by name and date
    When Admin clicks the Reset button
    And Admin inputs "Elva" in the search field
    And Admin selects start date "Mar 1, 2024" and end date "Apr 30, 2024"
    And Admin clicks the Search button
    Then Overtime report data should be shown by name and date

  @auth @positive
  Scenario: Export overtime report
    When Admin clicks the Reset button
    And Admin selects start date "Mar 1, 2024" and end date "Apr 30, 2024"
    And Admin clicks the Search button
    And Admin clicks the Export button
    Then Overtime report file should be downloaded

  @auth @positive
  Scenario: Edit user supervisor
    When Admin clicks the Reset button
    And Admin clicks the Action button
    And Admin clicks the Edit Supervisor button
    Then Supervisor information should be updated