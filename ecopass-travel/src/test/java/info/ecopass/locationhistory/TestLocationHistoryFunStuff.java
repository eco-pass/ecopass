package info.ecopass.locationhistory;

import java.util.Date;

import org.junit.Test;

public class TestLocationHistoryFunStuff {
	
	@Test (expected = IllegalArgumentException.class)
	public void whenFutureDate_thenThrowsException() {
		LocationHistoryFunStuff locationHistoryFunStuff = new LocationHistoryFunStuff();
		Date now = new Date();
		long yearInMilliseconds = 365 * 24 * 60 * 60 * 1000;
		Date future = new Date(now.getTime() + yearInMilliseconds);
		locationHistoryFunStuff.getNearbyActivities(future);
	}

}
