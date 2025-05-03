Feature: Laporan Lembur

  Background:
   Given Admin is logged in

@auth @eben
Scenario: Search Overtime Report by employee name dan date range
  When the admin navigates to Overtime Reports menu
  And the admin enters the employee name "Elva" in the search bar
  And the admin selects the start date "Mar 1, 2024" and end date "Apr 30, 2024"
  And the admin clicks the Search Button
  Then the Overtime Report for the selected employee and date should be displayed

  @auth @eben
Scenario: Search Overtime Report by employee name
  When the admin navigates to Overtime Reports menu
  And the admin enters the employee name "Agung Aji Nugraha" in the search bar
  And the admin clicks the Search Button
  Then the Overtime Report should be displayed

  @auth @eben
Scenario: Search Overtime Report by employee name, date, and department
  When the admin navigates to Overtime Reports menu
  And the admin enters the employee name "kazama" in the search bar
  And the admin selects the start date "Nov 1, 2024" and end date "Nov 30, 2024"
  And the admin clicks the Search Button
#  And the admin clicks the filter department button
#  And the admin enters the department name "IT Programmer" in the filter field
#  And the admin clicks the Terapkan button
  Then the Overtime Report for the selected employee, date, and department should be displayed

#  @auth @eben
#Scenario: Search Overtime Report by Department
#  When the admin navigates to Overtime Reports menu
#  And the admin clicks on the filter department button
#  And the admin enters the department name "Sysmex" in the search bar
#  And the admin clicks the Terapkan button
#  Then the Overtime reports for the selected department should be displayed

  @auth @eben
Scenario: Export the Overtime Reports
  When the admin navigates to Overtime Reports menu
  And the admin clicks the Export button
  Then the Overtime Reports should be downloaded

  @auth @eben
Scenario: Scroll the overtime report table horizontally
  When the admin navigates to Overtime Reports menu
  And the admin scrolls the table to the right
  Then additional colums in the Overtime Reports table should be visible

  @auth @eben
Scenario: Clicks the Edit form from Overtime Reports table
  When the admin navigates to Overtime Reports menu
  And the admin clicks the Action button on a report row
  And the admin clicks the Edit button
  Then the Edit Overtime Report form should be displayed

  @auth @eben
Scenario: Cancel editing the Overtime Report
  When the admin navigates to Overtime Reports menu
  And the admin clicks the Action button on a report row
  And the admin clicks the Cancel button in the edit form
  Then the edit form should be closed

  @auth @eben
Scenario: Test pagination and reset functionalities
  When the admin navigates to Overtime Reports menu
  And the admin selects the start date "Jan 1, 2021" and end date "Apr 30, 2025"
  And the admin clicks the Reset button
  Then all filters should be cleared and the main Overtime Reports page should be displayed
  And the admin selects the start date "Feb 1, 2025"
  And the admin clicks the Cancel Date button
  And the admin clicks the Reset button
  And the admin clicks the Go to Next Page button
  And the admin clicks the Go to Last Page button
  And the admin clicks the Go to Previous Page button
  And the admin clicks the Go to First Page button
  Then the Overtime Report should be displayed
