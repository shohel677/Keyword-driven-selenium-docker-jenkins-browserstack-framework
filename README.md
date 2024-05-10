## Robust selenium framework
This project is a comprehensive automation testing framework built in Java, utilizing Selenium WebDriver and TestNG. The framework is designed to support local execution, Docker execution, and integration with BrowserStack for cross-browser testing. It is also seamlessly integrated with Jenkins for continuous integration.

### Key Features:

1. Page object model: The Page Object Model (POM) design pattern for improved code maintainability and readability.
2. TestNG Integration: TestNG is used as the testing framework, providing features such as annotations for test execution control, parallel execution support, and reporting capabilities.
3. Cross-Browser Testing with BrowserStack: Integration with BrowserStack allows for automated testing across various browsers and devices, ensuring broad compatibility and coverage.
4. Docker Support: The framework is Dockerized, enabling easy setup and execution of tests in Docker containers. This facilitates consistent testing environments and scalability.
5. Jenkins Integration: Jenkins, a popular CI/CD tool, is integrated with the framework for automated test execution upon code commits or scheduled builds. Jenkins pipelines are configured to trigger test execution and generate reports.
6. Logging and Reporting: Comprehensive logging mechanisms capture test execution details, while TestNG's built-in reporting features provide detailed test reports. Additionally, custom reporting tools may be integrated for enhanced visualization of test results.
7. Parameterization and Data-Driven Testing: The framework supports parameterization and data-driven testing, allowing tests to be executed with different input data sets. External data sources such as Excel sheets or JSON files can be easily integrated.
8. Maintenance and Scalability: The framework is designed for ease of maintenance and scalability, with clear separation of concerns and standardized coding practices. Regular updates ensure compatibility with evolving application requirements and technologies.

### Usage:

1. Developers and QA engineers can write test scripts using Java, TestNG, and Selenium WebDriver, following the established framework structure and conventions.
2. Test suites can be executed locally on developer machines for rapid feedback during development.
3. Docker containers can be utilized to execute tests in isolated environments, ensuring consistency across different environments.
4. Integration with Jenkins enables automated test execution as part of the CI/CD pipeline, facilitating continuous testing and deployment.
5. BrowserStack integration allows for comprehensive cross-browser and cross-device testing, ensuring optimal user experience across diverse platforms.

### Installation

1. Pull the project in your environment
2. Maven run command `mvn clean test`
3. You can select platform for running the test in different platform by `-Dplatform`. And value for the parameter is for docker `docker`, for browser stack `browserStack`. and no platform requited for running on local
4. You can different test suit by `-DsuiteFile=suites/regression.xml`

Overall, this framework provides a robust and versatile solution for automated testing, empowering teams to efficiently validate application functionality, achieve faster release cycles, and deliver high-quality software products.