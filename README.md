# FitPeo Revenue Calculator Automation

This project automates the **Revenue Calculator** feature on the FitPeo homepage using **Cucumber**, **TestNG**, **Selenium**, and **Java**. It covers end-to-end testing scenarios to ensure the functionality and accuracy of the Revenue Calculator.

---

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [Execution](#execution)
- [Test Structure](#test-structure)
- [Reports](#reports)
- [Contact](#contact)

---

## Project Overview

The automation tests for the **Revenue Calculator** include:
1. Adjusting the slider and verifying updates in the text field.
2. Updating the text field and validating slider synchronization.
3. Selecting CPT codes and verifying the selection.
4. Validating the **Total Recurring Reimbursement** calculation.

---

## Technologies Used

The project leverages the following technologies and tools:
- **Java** (JDK 17 or higher)
- **Selenium WebDriver** (v4.26.0)
- **Cucumber** (v7.20.1)
- **TestNG** (v7.10.2)
- **Maven** for build and dependency management

---

## Setup Instructions

### Prerequisites
- Install [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html).
- Install [Maven](https://maven.apache.org/install.html).
- Install [Google Chrome](https://www.google.com/chrome/) and ensure the `chromedriver` executable matches your Chrome version.
- Set up an IDE like [Eclipse](https://www.eclipse.org/) or [IntelliJ IDEA](https://www.jetbrains.com/idea/).

### Steps
1. **Clone the repository**:
   ```bash
   git clone <your-repo-url>
   cd RevenueCalculator
2.**Update Chromedriver Path**: 
Replace the placeholder path in stepdefinitions/FitPeoRevenueCalculatorSteps.java with the path to your local chromedriver.

**Test Structure**
Feature File
The feature file is located at FeatureFiles/FitPeoRevenueCalculator.feature and contains the test scenarios in Gherkin syntax.
Example:
Scenario: Adjust slider, update text field, select CPT codes, and validate reimbursement total
    Given I open the FitPeo homepage with url "https://www.fitpeo.com/home"
    When I navigate to the Revenue Calculator page
    Then I should see the Revenue Calcualtor page
    And I scroll to the slider section
    And I set the slider to 820
    Then I should see the text field updated to 820
    ...
**Step Definitions**
All step definitions are implemented in stepdefinitions/FitPeoRevenueCalculatorSteps.java.

**Test Runner**
The test runner class is testrunners/TestRunner.java and is configured with the following:
@CucumberOptions(
    features = "FeatureFiles/FitPeoRevenueCalculator.feature",
    glue = "stepdefinitions",
    dryRun = false,
    plugin = {"pretty", "html:Test Reports/revenueresul.html"}
)
**Reports**
After execution, HTML reports are generated in the Test Reports/ folder.
Open the revenueresul.html file in any browser to view the detailed results.


