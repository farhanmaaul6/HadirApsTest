Feature: Correction Reports - Positive Tests

  Background: Admin is successfully logged in and on the dashboard
    Given Admin is on the dashboard page for Koreksi

  Scenario: Admin searches for an employee name with a specific date range
    Given Admin enters an employee name in the Search Bar
    And Admin enters a Date Range
    When Admin clicks Search
    Then The search results should display correction reports for that employee within the specified date range

  Scenario: Admin resets the filter
    When Admin clicks the Reset Button
    Then The filter should be reset and all correction reports should be displayed

  Scenario: Admin approves a correction
    When Admin clicks the approve button on a correction report
    And Admin clicks the "setujui" (approve) button
    Then The correction report should have an "approved" status

  Scenario: Admin rejects a correction
    When Admin clicks the approve button on a correction report
    And Admin clicks the reject button
    And Admin enters a reason for rejection
    And Admin clicks the "Tolak" (Reject) Button
    Then The correction report should have a "rejected" status with the provided reason

  Scenario: Admin cancels the approval of a correction
    When Admin clicks the approve button on an already approved correction report
    And Admin clicks the "batal" (cancel) button
    Then The approval status of the correction report should be canceled

  Scenario: Admin cancels the rejection of a correction
    When Admin clicks the approve button on an already rejected correction report
    And Admin clicks the reject button
    And Admin clicks the "batal" (cancel) button
    Then The rejection status of the correction report should be canceled