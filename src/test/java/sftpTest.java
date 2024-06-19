import org.junit.Test;
import com.jcraft.jsch.JSchException;
import Utilities.ConfigReader;



public class sftpTest {

    @Test
   public void testSftpConnection() throws JSchException {
        // Replace with your actual SFTP server details
    	ConfigReader.readConfigdata("InputConfig.json");
		String host= ConfigReader.getSftpHost();
		String username= ConfigReader.getSftpUsername();
		String password= ConfigReader.getSftpPassword();
		String localFileName=createTxtfile.fname;  ///fileName.file_Name;;;
		String remoteFilePath= ConfigReader.getsftpRemoteFilePath();
		int SFTP_PORT= ConfigReader.getSftpPort();
		
		System.out.println("sftpTest Variable test !"+ localFileName+remoteFilePath);

			sftpConnection.pushFiletotestserver(host, username, password,localFileName,remoteFilePath,SFTP_PORT);

	
		
	
	}

 
       

    }
