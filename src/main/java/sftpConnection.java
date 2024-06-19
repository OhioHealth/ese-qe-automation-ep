

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class sftpConnection {

   


   
   public static void pushFiletotestserver(String host, String username, String password,String localFileName,String remoteFilePath,int SFTP_PORT ) {

		
		
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(username, host, SFTP_PORT);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(password);
            session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
            session.connect();

            // Display a message after successful connection
            System.out.println("SFTP connection established successfully!");

            Channel channel = session.openChannel("sftp");
            channel.connect();
           // String remoteDir = remoteFilePath;
            //String localFileName1 = localFileName;
            
            
           ChannelSftp sftpChannel = (ChannelSftp) channel;

            
            // Uploading file 
           System.out.println("Uploading file !"+ localFileName+remoteFilePath);
            sftpChannel.put(localFileName,remoteFilePath);
                     
             
           System.out.println(localFileName +"File uploaded successfully. " );
            
          
            sftpChannel.disconnect();
            session.disconnect();
        } catch (JSchException | SftpException e) {
        	//Handle the exception, which indicates a failure during file upload
            
            System.err.println("SFTP File Upload failed: " + e.getMessage());
            e.printStackTrace();
                    
        }
		 
        
       
    }
    
    
}