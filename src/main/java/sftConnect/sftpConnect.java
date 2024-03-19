package sftConnect;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class sftpConnect {

    private static final String SFTP_HOST = "laptsolentcom01";
    private static final int SFTP_PORT = 22;
    private static final String SFTP_USER = "svcDEVUTILAUTO";
    private static final String SFTP_PASS = "q@bKw2nt";
    private static final String FILE_TO_CHECK = "example.txt";
   
   
    
    
    @Test
    public void testFilePresenceOnSFTPServer() {
        JSch jsch = new JSch();
        Session session = null;
        ChannelSftp sftpChannel = null;
        try {
            session = jsch.getSession(SFTP_USER, SFTP_HOST, SFTP_PORT);
            session.setPassword(SFTP_PASS);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();

            // Check if the file exists
            boolean fileExists = sftpChannel.ls(".").stream()
                    .anyMatch(entry -> entry.getFilename().equals(FILE_TO_CHECK));

            assertTrue(fileExists, "File " + FILE_TO_CHECK + " not found on the SFTP server");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sftpChannel != null) {
                sftpChannel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }
}