Feature: Negative Laporan Sakit

  Background:
    Given Admin is logged in and on to the dashboard for Laporan Sakit


  @auth @eben
  Scenario: Filter laporan sakit dengan nama tidak terdaftar
    When User navigates to Laporan Sakit Page
    And Admin inputs invalid employee name "Kadit Dae"
    And Admin click search button sakit
    Then No laporan sakit data should be displayed or an alert message should appear

  @auth @eben
  Scenario: Search using invalid unit name department
    When User navigates to Laporan Sakit Page
    And Admin inputs invalid unit name "Department Mager"
    And Admin clicks the Apply filter departement button
    Then No laporan sakit data should be displayed or an alert should appear

  @auth @eben
  Scenario: Search without any inputs
    When User navigates to Laporan Sakit Page
    And Admin clicks the Search button without entering any filter departement
    Then No laporan sakit data should be displayed or an alert should appear

