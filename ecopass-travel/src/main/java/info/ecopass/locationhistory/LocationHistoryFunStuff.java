package info.ecopass.locationhistory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import info.ecopass.locationhistory.model.LocationVO;

public class LocationHistoryFunStuff {

	public List<LocationVO> getNearbyActivities(String date, int activities) {
		List<LocationVO> nearbyDates = new ArrayList<>();
		return nearbyDates;
	}

	public List<LocationVO> getNearbyActivities(Date date) {
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
