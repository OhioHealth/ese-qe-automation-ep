package sftConnect;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import java.util.Vector;

public class SFTPConnector {

    private static final String REMOTE_FTP_DIR = "/data/app/certs";
    private static final int SFTP_PORT = 22;

    public static void connectAndListFiles(String host, String username, String password) {
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
            String remoteDir = REMOTE_FTP_DIR;
            ChannelSftp sftpChannel = (ChannelSftp) channel;

            Vector<ChannelSftp.LsEntry> files = sftpChannel.ls(remoteDir);
            for (ChannelSftp.LsEntry file : files) {
                if (!file.getAttrs().isDir()) {
                    System.out.println("File: " + file.getFilename());
                }
            }

            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
            System.err.println("SFTP connection failed: " + e.getMessage());
        }
    }
}