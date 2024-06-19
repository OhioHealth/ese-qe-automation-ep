
This README provides a comprehensive guide to understanding, setting up, and running the EPbacthAutomation project.

# EPbacthAutomation

**EPbacthAutomation** is a custom Java test framework designed to automate the process of creating and uploading text files based on input values specified in an `InputConfig.json` file. This framework generates sample text files specific to a campaign, uploads these files to a designated SFTP location, and validates the data by checking updates in the corresponding database tables.

## Project Overview

- **Project Name:** `ese-qe-automation-epb`
- **Framework Name:** `EPbacthAutomation`

## Key Features

1. **File Generation:** 
   - Reads input configurations from `InputConfig.json`.
   - Generates text files with data specific to a campaign.
   - Ensures the generated file matches the expected format defined in the JSON configuration.

2. **SFTP Upload:**
   - Uploads the generated text file to a specified SFTP server (`lattsolentcom01`).
   - Ensures the file is uploaded to the correct location for further processing by an inbound job.

3. **Database Validation:**
   - Establishes a connection to a SQL Server database.
   - Validates that the appropriate inbound and outbound tables are updated with the correct data after the file upload.

## Dependencies

The project relies on several dependencies managed by Maven. Below are the key dependencies as specified in the `pom.xml` file:

- **JUnit:** For running and managing unit tests.
  - Group: `junit`
  - Artifact: `junit`
  - Version: `4.13.1`
  - Scope: `test`

- **JSCH Library:** For handling SFTP connections.
  - Group: `com.jcraft`
  - Artifact: `jsch`
  - Version: `0.1.55`

- **JSON Library:** For reading and parsing JSON files.
  - Group: `org.json`
  - Artifact: `json`
  - Version: `20240205`

- **MS SQL JDBC Driver:** For connecting to SQL Server databases.
  - Group: `com.microsoft.sqlserver`
  - Artifact: `mssql-jdbc`
  - Version: `8.2.0.jre8`

- **Jackson Databind:** For mapping JSON content to Java objects and vice versa.
  - Group: `com.fasterxml.jackson.core`
  - Artifact: `jackson-databind`
  - Version: `2.13.0`

## Java Version

The project is configured to use Java 1.8:

- **Compiler Source:** `1.8`
- **Compiler Target:** `1.8`

## Setup and Running Tests

### Clone the Repository

1. Clone the `ese-qe-automation-ep` repository to your local machine:

   ```sh
   git clone https://github.com/yourusername/ese-qe-automation-ep.git
   ```

2. Open the cloned repository in Eclipse IDE or your preferred Java development environment.

### Running Tests

1. Open the terminal in your project directory.

2. Run the following Maven commands to clean the project and execute the test suite:

   ```sh
   mvn clean
   mvn test -Dtest="AllTests"
   ```

   - `mvn clean`: Cleans the project by removing the target directory.
   - `mvn test -Dtest="AllTests"`: Runs the entire test suite.

## Test Coverage

### File Validation Test

- **Purpose:** Verifies that the generated text file matches the expected format provided in the JSON file.
- **Method:** Compares the generated file content with the specified input values.

### SFTP Upload Test

- **Purpose:** Ensures that the generated text file is uploaded to the correct SFTP location.
- **Method:** Confirms the presence of the uploaded file in the SFTP server's specified directory.

### Database Validation Tests

- **Purpose:** Validates the correctness of data updates in the inbound and outbound database tables after file upload.
- **Method:** Executes SQL queries to check data integrity and correctness in the relevant database tables.

## Additional Information

### Classes Used in the Project

1. **`ConfigReader`:** Reads and parses the input configuration from the `InputConfig.json` file.
2. **`createTxtfile`:** Generates text files based on the input configuration and appends random numbers to filenames to ensure uniqueness.
3. **`dbConnectionTest`:** Contains tests to validate database connections and queries.
4. **`dbConnection`:** Manages connections to the SQL Server database.
5. **`sftpConnection`:** Handles connections to the SFTP server and manages file uploads.

### Input File

- **`InputConfig.json`:** Contains the configuration data for generating text files, such as campaign details and file formats.




---

This README provides a comprehensive guide to understanding, setting up, and running the EPbacthAutomation project.
