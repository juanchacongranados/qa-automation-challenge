# QA Automation Challenge

Automated test suite for Web UI and REST API validation using **Java, Serenity BDD, Screenplay Pattern, Cucumber, Selenium WebDriver, and REST Assured**.

The project covers the required user flows for the Selenium website and ReqRes API while keeping Web and API automation within the same Serenity BDD framework.

## Tech Stack

- Java 17
- Maven
- Serenity BDD 5.3.11
- Screenplay Pattern
- Cucumber / Gherkin
- Selenium WebDriver
- Serenity REST / REST Assured
- JUnit Platform

## Test Coverage

### Web — Selenium

The Web suite validates:

1. Selenium home page loads successfully and displays the expected title.
2. Navigation to the Documentation section works correctly.
3. Documentation search returns results related to `WebDriver`.

Target application:

`https://www.selenium.dev/`

### API — ReqRes

The API suite validates:

1. Retrieve the user list and verify the requested page and returned data.
2. Create a new user and verify the response status, generated fields, and submitted information.
3. Update an existing user and verify the response status, update timestamp, and submitted information.

Target API:

`https://reqres.in/`

## Project Structure

```text
src/test/
├── java/com/juanchacon/qa/
│   ├── questions/        # Screenplay Questions used for Web assertions
│   ├── runners/          # Cucumber/JUnit Platform test runner
│   ├── stepdefinitions/  # Cucumber step definitions for Web and API
│   ├── tasks/            # Reusable Screenplay Tasks
│   └── ui/               # Web page targets
└── resources/
    └── features/
        ├── reqres_api.feature
        └── selenium_web.feature
```

## Automation Approach

The solution uses the **Screenplay Pattern** to separate test intent from implementation details.

The Cucumber feature files describe the expected behavior in readable business-oriented language. Step definitions connect those scenarios with Screenplay Tasks and Questions.

For Web automation, UI locators are isolated from the test flow, while reusable Tasks represent user actions such as opening the Selenium website, navigating to Documentation, and performing a search.

For API automation, REST operations are also implemented as Screenplay Tasks. The actor receives the `CallAnApi` ability and performs the GET, POST, and PUT requests through Serenity REST.

This structure keeps the scenarios readable while allowing the implementation to remain maintainable and extensible.

## Prerequisites

Before running the project, make sure the following are installed:

- Java 17 or newer
- Maven 3.9+
- Google Chrome
- Git

Verify the environment with:

```bash
java -version
mvn -version
git --version
```

## Clone the Repository

```bash
git clone https://github.com/juanchacongranados/qa-automation-challenge.git
cd qa-automation-challenge
```

Replace `<repository-url>` with the public repository URL.

## Run the Tests

To execute the complete automated suite:

```bash
mvn clean verify
```

This command runs all Web and API scenarios and generates the Serenity BDD report.

To execute the tests without regenerating the aggregated report:

```bash
mvn test
```

## Serenity Reports

The latest Serenity BDD execution report is publicly available at:

https://juanchacongranados.github.io/qa-automation-challenge/serenity/

After running:

```bash
mvn clean verify
```

the interactive Serenity BDD report is generated at:

```text
target/site/serenity/index.html
```

On macOS it can be opened with:

```bash
open target/site/serenity/index.html
```

The report provides detailed execution results for both Web and API scenarios, including individual steps and overall functional coverage.

## Current Test Suite

The suite contains **6 automated scenarios**:

- 3 Web scenarios
- 3 API scenarios

Latest local execution:

```text
Tests: 6
Passed: 6
Failed: 0
Errors: 0
Success rate: 100%
```

## Design Decisions

A few implementation decisions were made with maintainability in mind:

- Web and API tests share the same Serenity/Cucumber execution framework.
- Cucumber scenarios focus on behavior rather than implementation details.
- Screenplay Tasks encapsulate reusable user actions and API operations.
- UI selectors are centralized in dedicated classes.
- API requests are parameterized instead of hardcoding test data inside the Tasks.
- Assertions validate both successful responses and relevant returned content.
- Selenium driver management is handled automatically by Selenium Manager.

## Notes

The project uses a public test website and public API, so execution depends on the availability and current behavior of those external services.

Chrome DevTools Protocol compatibility warnings may appear when the locally installed Chrome version is newer than the closest CDP version supported by the Selenium dependency. These warnings do not affect the current automated scenarios.

## Author

**Juan Alexander Chacón Granados**  
QA Engineer