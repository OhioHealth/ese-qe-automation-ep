package test;

import com.jcraft.jsch.*;

import org.junit.jupiter.api.Test;



public class SftpConnpk {
    public static void main(String[] args) {
        String privateKey = "C:\\Users\\mxv082\\Downloads\\automation";
        String username = "svcDEVUTILAUTO";
        String host = "lattsolentcom01";
        String password = "q@bKw2nt";
        int port = 22; // or any other port your SSH server is running on
        
        try {
            JSch jsch = new JSch();
            
            // Load the private key
            jsch.addIdentity(privateKey);
            
            // Create a session
            Session session = jsch.getSession(username, host, port);
            session.setPassword(password);
            
            // Disable strict host key checking
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            
            // Connect to the server
            session.connect();
            
            
            // Open a channel
            Channel channel = session.openChannel("sftp");
            session.setConfig(
            	    "PreferredAuthentications", "publickey,keyboard-interactive,password");
            channel.connect();
            
            
            System.out.println("Connection successful");
            
            // Disconnect channel and session when done
            channel.disconnect();
            session.disconnect();
            
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }
}
