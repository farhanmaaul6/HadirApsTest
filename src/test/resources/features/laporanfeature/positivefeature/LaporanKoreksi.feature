Feature: Positive Test Correction Report

  Background:
    Given Admin is logged in and on the dashboard for Laporan Koreksi

  @auth @positive
  Scenario: Search correction by employee name and date range
    When Admin navigates to Correction Report
    And Admin inputs "Juned" in the search field
    And Admin selects start date "Jan 1, 2025" and end date "Apr 30, 2025"
    And Admin clicks the Search button
    Then Correction data should be displayed based on the name and date range

  @auth @positive
  Scenario: Search correction by unit name
    When Admin clicks the Filter button
    And Admin inputs unit name "Sysmex"
    And Admin clicks the Apply filter button
    Then Correction data should be displayed only from the selected unit

  @auth @positive
  Scenario: Approve correction request
    When Admin clicks the Approve button for the first correction
    And Admin clicks the Confirm button
    Then A success popup should appear with message "Berhasil menyetujui koreksi absen"

  @auth @positive
  Scenario: Reject correction request
    When Admin clicks the Reject button for the first correction
    And Admin inputs rejection reason "Alasan tidak valid"
    And Admin clicks the Submit rejection button
    Then A success popup should appear with message "Berhasil menolak permintaan koreksi absen"

  @auth @positive
  Scenario: Reset correction search filter
    When Admin clicks the Reset button
    Then All filters should be cleared and default data should be displayed
