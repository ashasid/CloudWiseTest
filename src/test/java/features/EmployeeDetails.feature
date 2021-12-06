
@test
Feature: Cloudwise employee details
   As a QA
   I want to see all the employee details from all the departments of cloudwise
   So that i can also collect all the duplicate employee names as well

   Scenario: Get all the employees details from all the departments and verify for duplicate names
      Given I launch the cloudWise application
      When I click on dit is cloudwise
      And I click on alle cloudwisers
      Then Get all the employee names from all the departments and check for duplicate names
