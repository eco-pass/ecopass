package info.ecopass.locationhistory.ideas;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import info.ecopass.locationhistory.model.Location;

public class TestLocationHistoryNearestProvider {

	private static final long ACTIVITY_BEFORE = 1539623266024L;
	private static final long ACTIVITY_AFTER = 1539623245989L;

	@Test
	public void whenNoAmountSpecifiedAndDateIsAfterFirstEntry_thenReturnsPreviousAndNext() {
		LocationHistoryNearestProvider locationHistoryFunStuff = new LocationHistoryNearestProvider();
		long timestampBetweenActivities = (ACTIVITY_BEFORE + ACTIVITY_AFTER) / 2;
		Date dateBetween = new Date(timestampBetweenActivities);
		List<Location> result = locationHistoryFunStuff.getNearestActivities(dateBetween);
		assertEquals(2, result.size());
	}

	@Test
	public void whenFutureDateSpecified_thenReturnsLastEntry() {
		
	}
}
