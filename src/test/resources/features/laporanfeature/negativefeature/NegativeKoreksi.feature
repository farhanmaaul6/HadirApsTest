Feature: Correction Reports - Negative Tests

  Background: Admin is successfully logged in and on the dashboard
    Given Admin is on the dashboard page for Koreksi

  Scenario: Admin attempts to search for an employee name without a date range and without entering a name
    Given Admin does not enter an employee name in the Search Bar
    And Admin does not enter a Date Range
    When Admin clicks Search
    Then The system should display an error message or no search results

  Scenario: Admin attempts to search for an employee name with a specific date range without entering a name
    Given Admin does not enter an employee name in the Search Bar
    And Admin enters a Date Range
    When Admin clicks Search
    Then The system should display an error message or no search results

  Scenario: Admin performs filtering by Unit
    When Admin clicks the filter button
    And Admin enters a unit
    Then The filter results should display correction reports based on the selected unit