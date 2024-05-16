import org.junit.Test;
import com.jcraft.jsch.JSchException;
import Utilities.ConfigReader;
import Utilities.ConfigReader.fileName;


public class sftpTest {

    @Test
   public void testSftpConnection() throws JSchException {
        // Replace with your actual SFTP server details
    	ConfigReader.readConfig("InputConfig.json");
		String host= ConfigReader.getSftpHost();
		String username= ConfigReader.getSftpUsername();
		String password= ConfigReader.getSftpPassword();
		String localFileName=fileName.file_Name;;;
		String remoteFilePath= ConfigReader.getsftpRemoteFilePath();
		int SFTP_PORT= ConfigReader.getSftpPort();
		
          

			sftpConnection.pushFile(host, username, password,localFileName,remoteFilePath,SFTP_PORT);

	
		
	
	}

 
       

    }
