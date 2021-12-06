
@test
Feature: Gatekeeper Challenge
  As a QA
  I want to test gatekeeper challenge application
  So that all possible tests can be

  Background: Launch the gatekeeper
    Given I launch the gatekeeper application

  Scenario Outline: Math test
    When I will add two input numbers as <input1> and <input2>
    Then I should get result as <output>

    Examples:
    |input1|input2|output|
    |  10  | 20   | 30   |
    |  30  | 40   | 70   |

  Scenario: In search of Unicorn
    When I search the field as "bobi" and click on enter
    Then I result should be as "Bobi Codeshake"

   Scenario: Return of the popup
     When I click on Let battle begin
     Then I should see popup with orange target
     And I click on orange target

   Scenario: Our address needs to be verified
     When I scroll down to office address in codeshake and verify with extracted address