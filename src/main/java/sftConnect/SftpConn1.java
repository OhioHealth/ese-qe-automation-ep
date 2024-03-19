package sftConnect;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SftpConn1 {

    public SftpConn1() {
    }

    public static void main(String[] args) {
        String SFTPHOST = "laptsolentcom01";
        int SFTPPORT = 22;
        String SFTPUSER = "svcDEVUTILAUTO";
        String SFTPPASS = "q@bKw2nt";
       

        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;

        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            
            
            while(session != null){
                System.out.println("Killing the session");
                session.disconnect();
           
                System.exit(0);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}