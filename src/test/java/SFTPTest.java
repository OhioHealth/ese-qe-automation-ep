import org.junit.Test;


public class SFTPTest {

    @Test
   public void testSFTPConnection() {
        // Replace with your actual SFTP server details
        String host = "lattsolentcom01";
        String username = "svcDEVUTILAUTO";
        String password = "q@bKw2nt";
       
        String localFileName="PEP_3dayXpilot_outgoing_110.txt";
        
        String remoteFilePath = "/data/batch/inbound/epic/incoming";
        // Call the connectAndListFiles method with parameters
       // SFTPConnector.connectAndListFiles(host, username, password);
        
        
     // Call the connectAndPutFiles method with parameters to put local file on SFTP
        
       
         SFTPConnector.connectAndPutFiles(host, username, password,localFileName,remoteFilePath);
    }
}