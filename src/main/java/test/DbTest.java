package test;

import org.junit.jupiter.api.Test;

import database.TestdbConnection;

class DbTest {

	@Test
	public void test() {
		TestdbConnection testdbConnection = new TestdbConnection();
		testdbConnection.selectData();
	}

}
