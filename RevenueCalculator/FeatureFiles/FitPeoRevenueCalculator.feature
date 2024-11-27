Feature: Revenue Calculator on FitPeo Homepage

  Scenario: Adjust slider, update text field, select CPT codes, and validate reimbursement total
    Given I open the FitPeo homepage with url "https://www.fitpeo.com/home"
    When I navigate to the Revenue Calculator page
    Then I should see the Revenue Calcualtor page
    And I scroll to the slider section
    And I set the slider to 820
    Then I should see the text field updated to 820
    When I enter 560 in the text field
    Then the slider should reflect the value 560
    Then I update the text field to 820
    When I scroll down and select CPT codes
    Then the Total Recurring Reimbursement should show "$110700"
