package info.ecopass.locationhistory.ideas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import info.ecopass.locationhistory.model.LocationVO;

public class LocationHistoryNearestProvider {

	public List<LocationVO> getNearestActivities(String date, int activities) {
		List<LocationVO> nearbyDates = new ArrayList<>();
		return nearbyDates;
	}

	public List<LocationVO> getNearestActivities(Date date) {
		validateDateNotFuture(date);
		List<LocationVO> nearbyDates = new ArrayList<>();
		return nearbyDates;
	}
	
	private void validateDateNotFuture(Date date) {
		Date now = new Date();
		if (date.after(now)) {
			throw new IllegalArgumentException("Provided date should be in the past");
		}
	}

}
