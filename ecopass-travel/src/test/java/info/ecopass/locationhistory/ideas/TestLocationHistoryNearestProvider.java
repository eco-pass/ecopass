package info.ecopass.locationhistory.ideas;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import info.ecopass.locationhistory.model.LocationVO;

public class TestLocationHistoryNearestProvider {

	private static final long ACTIVITY_BEFORE = 1539623266024L;
	private static final long ACTIVITY_AFTER = 1539623245989L;

	@Test(expected = IllegalArgumentException.class)
	public void whenFutureDate_thenThrowsException() {
		LocationHistoryNearestProvider locationHistoryFunStuff = new LocationHistoryNearestProvider();
		Date now = new Date();
		long yearInMilliseconds = 365 * 24 * 60 * 60 * 1000;
		Date future = new Date(now.getTime() + yearInMilliseconds);
		locationHistoryFunStuff.getNearestActivities(future);
	}

	@Test
	public void whenNoAmountSpecifiedAndDateIsAfterFirstEntry_thenReturnsPreviousAndNext() {
		LocationHistoryNearestProvider locationHistoryFunStuff = new LocationHistoryNearestProvider();
		long millisBetween = (ACTIVITY_BEFORE + ACTIVITY_AFTER) / 2;
		Date dateBetween = new Date(millisBetween);
		List<LocationVO> result = locationHistoryFunStuff.getNearestActivities(dateBetween);
		
	}

}
