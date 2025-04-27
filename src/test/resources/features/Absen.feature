Feature: Import Absen

  Background:
    Given Admin is on the dashboard page for Absen

  @auth @positive
    Scenario: Download template data for absen
      When Admin navigates to Import > Absen
      And Admin clicks download template for Absen
      Then Template for Absen should be downloaded

  @auth @positive
    Scenario: Import data Absen (valid data)
      And Admin uploads valid absen template file
      Then Absen should be imported successfully

  @auth @negative
    Scenario: Import tanpa memilih file (Absen)
      When Admin navigates to Import > Absen
      And Admin clicks import without choose a file
      Then Error message should be shown for missing file in Absen

  @auth @negative
    Scenario: Import file tidak sesuai template (Absen)
      When Admin uploads incorrect Absen template file
      Then Error message should be show for invalid format in Absen

  @auth @negative
    Scenario: Import file bukan format excel (Absen)
      When Admin uploads non-Excel file for Absen
      Then Error message should be show for file type in Absen
