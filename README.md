# SmartBugTracker

SmartBugTracker is a Spring Boot web application that analyzes Java code for bugs using PMD and displays the results in a user-friendly web interface.

## Technologies Used
- Java 17
- Spring Boot
- Maven
- PMD (for static code analysis)
- Thymeleaf (for HTML templating)

## Features
- **Bug Detection:** Uses PMD to scan Java source files for code issues and bugs.
- **Web Interface:** View detected bugs in a table format at `/bugs`.
- **Dynamic Data:** Parses PMD XML output and displays real bug data dynamically.

## Project Structure
```
SmartBugTracker/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/com/smartbugtracker/
│   │   │   ├── SmartBugTrackerWebApplication.java
│   │   │   ├── BuggyCode.java
│   │   │   ├── controller/BugController.java
│   │   │   ├── model/Bug.java
│   │   │   └── util/BugParser.java
│   │   └── resources/templates/bugs.html
│   └── test/java/com/smartbugtracker/AppTest.java
├── target/pmd.xml (generated)
```

## How It Works
1. **Run PMD:**
   - PMD scans your Java code and generates a report at `target/pmd.xml`.
2. **Parse Bugs:**
   - `BugParser` reads the PMD XML and creates a list of `Bug` objects.
3. **Display Bugs:**
   - `BugController` passes the bug list to the `bugs.html` template for display.

## Getting Started
### Prerequisites
- Java 17 or later
- Maven

### Build and Run
```sh
mvn clean install
mvn spring-boot:run
```

### View Bugs
- Open your browser and go to: [http://localhost:8080/bugs](http://localhost:8080/bugs)

## Running PMD
To generate the bug report:
```sh
mvn pmd:pmd
```
This will create `target/pmd.xml`.

## Customizing Rules
- PMD rules can be configured in `pom.xml` or a custom ruleset XML.

## Key Files
- `BugController.java`: Handles web requests and loads bug data.
- `BugParser.java`: Parses PMD XML output.
- `Bug.java`: Model for bug data.
- `bugs.html`: Thymeleaf template for displaying bugs.

## License
This project is for educational/demo purposes.
