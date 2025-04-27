Feature : Import Cuti

  Background: Admin is on the dashboard for status aktif

    @auth @positive
      Scenario: Download template cuti
        When Admin navigates to Import > Cuti
        And Admin clicks Download Template Cuti
        Then Template for Cuti should be downloaded

    @auth @positive
      Scenario: Import data cuti (valid file)
        When Admin uploads valid cuti template files
        Then Cuti data should be imported successfully

    @auth @negative
      Scenario: Import tanpa memilih file (Cuti)
        When Admin navigates to Import Cuti
        And Admin clicks Import without select a file
        Then Error Message should be show for missing file in cuti

    @auth @negative
      Scenario: Import file tidak sesuai template (Cuti)
        When Admin uploads incorrect Cuti template file
        Then Error message should be show for invalid format in Cuti

    @auth @negative
      Scenario: Import file bukan format excel (Cuti)
        When Admin uploads non-excel file for cuti
        Then Error message should be show for file type in cuti
