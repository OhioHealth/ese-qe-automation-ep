package test;

import FTPConnect.FTPConnection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FtpTest {

	@Test
	void test() {
		// Call the FTPConnection.connect method
		FTPConnection ftpConnection = new FTPConnection();
		ftpConnection.connect("svcDEVUTILAUTO", "q@bKw2nt");
	}

}
