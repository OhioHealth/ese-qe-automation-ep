package FTPConnect;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;


public class FTPConnection {

	
		// TODO Auto-generated method stub
		public static void connect (String username, String password) 
		{
			String server="laptsolentcom01";
			int port=22;
			
			System.out.println("hi"+ username + password);
			
			
			FTPClient ftpClient = new FTPClient();
			try {
				
				ftpClient.connect(server,port);
				ftpClient.login(username,password);
				ftpClient.enterLocalPassiveMode();
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				
				System.out.println("Current working directory:" + ftpClient.printWorkingDirectory());
				
				//list the files in the current directory
				
				ftpClient.logout();
				
				
				
				
			}catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				try{
					ftpClient.disconnect();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
			
			
		}

	}


