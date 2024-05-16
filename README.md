# ese-qe-automation-epb
# ese-qe-automation-epb
EPbacthAutomation: This Project creates a sample text file specific to a campaign and places in SFTP location(lattsolentcom01) so the created file is read by inbound job and updates corresponding tables accordingly. Then a Database connection is made to validate the corresponding inbound tables and outbound table to confirm the campaign message has been sent.

Dependancies: All the below dependancies are automatically downloaded by maven
jsch library from com.jcraft
json library from org.json
mssql-jdbc from com.microsoft.sqlserver
junit

Instructions to run Test:
Clone the ese-qe-automation-ep repository to your local
Open the repository in Eclipse IDE
Open the terminal and run following commands
mvn clean
mvn Test -Dtest="AllTests" to run entire test suite

Test Coverage:
Validate text file test validates that sample text file is created in expected format.
SFTP test validates that created text file is Uploaded in right location
DB Tests validate queries to ensure appropriate inbound and outbound tables are updated with correct data.

