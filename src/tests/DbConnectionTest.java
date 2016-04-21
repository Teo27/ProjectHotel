package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import dbLayer.DbConnection;

public class DbConnectionTest {

	@Test
	public void test() {
		DbConnection dbCon = DbConnection.getInstance();
		if(dbCon != null)
		{
			System.out.println("Connection - DB connection to the Database successful");
		}
		else{
		    fail("Can not connect to the DB");
		}
	}


}
