Feature: Negative Laporan Lembur

  Background:
    Given Admin is logged in

  @auth @eben
Scenario: Search Overtime Report with unregistered employee name
  When the admin navigates to Overtime Reports menu
  And the admin enters an unregistered employee name "Ebenhaezer" in the search bar
  And the admin clicks the Search Button
  Then no overtime report should be displayed

  @auth @eben
  Scenario: Search Overtime Report with invalid date range
    When the admin navigates to Overtime Reports menu
    And the admin selects a start date "Jan 1, 2045" and end date "Jan 31, 2045"
    And the admin clicks the Search Button
    Then the system should not display any data

  @auth @eben
  Scenario: Apply department filter without selecting any department
    When the admin navigates to Overtime Reports menu
    And the admin clicks the filter department button
    And the admin leaves the department search field empty
    And the admin clicks the Terapkan button
    Then the department filter should not be applied
    And the report results should remain unchanged

  @auth @eben
  Scenario: Click Export button with no data available
    When the admin navigates to Overtime Reports menu
    And the admin enters an unregistered employee name "Livy Renata" in the search bar
    And the admin clicks the Search Button
    And the admin clicks the Export button
    Then the system should show a warning or do nothing, as there is "Harap isi tanggal terlebih dahulu"
