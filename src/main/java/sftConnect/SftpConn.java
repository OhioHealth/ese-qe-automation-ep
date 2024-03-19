package sftConnect;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

  
public class SftpConn {
	 
	 private String host = "laptsolentcom01";
     private int port = 22;
     private Session session = null;

 
    public static void SFTPClient() {
    	 
    }

    public  void connect() throws JSchException {
        JSch jsch = new JSch();
       

     
        session = jsch.getSession("svcDEVUTILAUTO", host, port);
        session.setPassword("q@bKw2nt");

        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
    }
}
