package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import controlLayer.CtrStatistics;
import dbLayer.DbArchive;

@RunWith(Suite.class)
@SuiteClasses({ CtrBookingTest.class, DbBookingTest.class,
		DbConnectionTest.class })
public class AllTests {

}
