# GoldCashFreeSpins

## Overview
GoldCashFreeSpins is an automated UI test project using TestNG to run tests in parallel. The TestNG suite file is `testng.xml`, which controls listeners, parameters and parallel execution.

## Prerequisites
- Java JDK 11+
- Eclipse IDE with TestNG plugin
- Browser driver executables (e.g., `chromedriver`) on `PATH` or managed via WebDriverManager
- Maven (optional)

## Project structure (typical)
- `src/main/java` \- helpers and utilities
- `src/test/java` \- test classes (for example, `testscript.VerifyAgeTest`, `testscript.HomeCanvasTest`)
- `testng.xml` \- TestNG suite controlling execution and parallelism

## About `testng.xml`
- Defines a listener class `reportgeneration.Listners`
- Sets a suite parameter `browser` (default: `chrome`)
- Configures a `<test>` with `thread-count="5"` to run classes in parallel
- Modify `browser`, `thread-count` or included classes to change runtime behavior

## Running tests in Eclipse
1. Open the project in Eclipse.
2. Ensure TestNG plugin is installed (Help > Eclipse Marketplace > search TestNG).
3. In Project Explorer, right-click `testng.xml` and choose Run As \> TestNG Suite.

## Running tests with Maven
Since the project uses Maven, run the suite with:
mvn clean install 
mvn test -Dsurefire.suiteXmlFiles=testng.xml

## Troubleshooting
- Browser fails to start: verify browser version matches driver or enable WebDriverManager.
- Tests hang or resource conflicts: reduce `thread-count` or change parallel strategy.
- Inspect Eclipse Console and TestNG reports for stack traces and root causes.

## Design Decisions

•	Used Page Factory (Enhanced Encapsulation) by using @FindBy annotations to declare elements as private members.
•	Configured testng.xml to control execution and parallelism so configuration is external to code and easy to change per-run.
•	Exposed browser as a suite parameter to switch browsers without modifying test code or recompiling.
•	Registered reportgeneration.Listners as a listener to centralize reporting, logging and lifecycle hooks in one place.
•	Keeping test inclusions and method-level includes commented for quick, targeted runs during debugging or CI troubleshooting.
