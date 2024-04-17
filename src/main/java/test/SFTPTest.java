package test;

import org.junit.jupiter.api.Test;

import sftConnect.SFTPConnector;

import static org.junit.jupiter.api.Assertions.*;

public class SFTPTest {

    @Test
    void testSFTPConnection() {
        // Replace with your actual SFTP server details
        String host = "laptsolentcom01";
        String username = "svcDEVUTILAUTO";
        String password = "q@bKw2nt";

        // Call the connectAndListFiles method with parameters
        SFTPConnector.connectAndListFiles(host, username, password);
    }
}