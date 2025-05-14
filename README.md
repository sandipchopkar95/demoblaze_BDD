
# Java Selenium BDD Framework with JUnit

This is a Behavior Driven Development (BDD) test automation framework using **Selenium WebDriver**, **Java**, **JUnit**, and **Cucumber**. It follows **Page Object Model (POM)** design principles and is structured for scalable and maintainable test automation.

---

## 📁 Project Structure

```
src/
├── main/
│   └── java/com/personal/demoblaze/
│       ├── AppConstants/              # Application constants
│       │   └── AppConstant.java
│       ├── config/                    # Driver and config setup
│       │   ├── ConfigReader.java
│       │   └── DriverManager.java
│       ├── pages/                     # Page Object Model classes
│       │   ├── CartPage.java
│       │   ├── ContactUs.java
│       │   ├── HomePage.java
│       │   ├── LoginPage.java
│       │   └── MyAccountPage.java
│       └── utils/                     # Utility classes
│           ├── ScreenshotUtil.java
│           └── WaitHelper.java
│
├── test/
│   └── java/com/personal/demoblaze/
│       ├── basetest/                  # Base test class
│       │   └── BaseTest.java
│       ├── runners/                   # Cucumber test runners
│       │   └── TestRunner.java
│       └── stepdefinitions/          # Step definition classes
│           ├── HomePage_Steps.java
│           ├── Login_Logout_Steps.java
│           └── MyAccountPage_Steps.java
│
├── resources/
│   ├── config.properties              # Test configuration
│   └── features/homepage/            # Feature files
│       ├── HomePage.feature
│       ├── Login_LogOut.feature
│       ├── MyAccountPage.feature
│       └── cucumber.properties
```

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 11+
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, etc.)
- Browser driver (e.g., ChromeDriver)

### Installation

Clone the repository and navigate to the project root directory.

```bash
git clone https://github.com/your-repo/demoblaze-bdd-framework.git
cd demoblaze-bdd-framework
```

Install dependencies:

```bash
mvn clean install
```

---

## 🧪 Running Tests

Run the test suite using Maven:

```bash
mvn test
```

Or directly run via JUnit in your IDE using `TestRunner.java`.

---

## 🧾 Writing Feature Files

Feature files are written in **Gherkin** syntax and located in `src/test/resources/features/homepage/`.

Example:

```gherkin
Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given user is on login page
    When user enters valid username and password
    Then user should be redirected to the homepage
```

---

## 🧩 Step Definitions

Step definitions are implemented in `stepdefinitions/` and mapped to feature file steps using Cucumber annotations:

```java
@Given("user is on login page")
public void user_is_on_login_page() {
    loginPage.navigateToLogin();
}
```

---

## ⚙ Configuration

Edit `config.properties` to change environment settings such as:

```properties
browser=chrome
baseUrl=https://demoblaze.com
implicitWait=10
```

---

## 📸 Utilities

- `ScreenshotUtil.java`: Captures screenshots on failures.
- `WaitHelper.java`: Provides custom wait logic.

---

## 🧱 Base Test

`BaseTest.java` handles browser setup and teardown using JUnit `@Before` and `@After`.

---

## 📂 Reporting

Integrate tools like **ExtentReports**, **Allure**, or **Cucumber Reports** for advanced reporting (not included in base setup).

---

