package sftConnect;
import com.jcraft.jsch.*;
import java.util.Vector;
public class NoKerboSFTP {

    private static final String REMOTE_FTP_DIR = "/data/app/certs";
    private static final String SFTP_HOST = "laptsolentcom01";
    private static final int SFTP_PORT = 22;
    private static final String SFTP_USER = "svcDEVUTILAUTO";
    private static final String SFTP_PASS = "q@bKw2nt";
    private static final String FILE_TO_CHECK = "example.txt";
   
    public static void main(String[] args) {
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession("svcDEVUTILAUTO", "laptsolentcom01", 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("q@bKw2nt");
            session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password"); // Add this line
            session.connect();

            // Display a message after successful connection
            System.out.println("SFTP connection established successfully!");

            Channel channel = session.openChannel("sftp");
            channel.connect();
            String remoteDir="/data/app/certs";
            ChannelSftp sftpChannel = (ChannelSftp) channel;
          
            Vector<ChannelSftp.LsEntry> files = sftpChannel.ls(remoteDir);
            for (ChannelSftp.LsEntry file : files) {
                if (!file.getAttrs().isDir()) {
                    System.out.println("File: " + file.getFilename());
                }}
           
       
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        }
    }
}