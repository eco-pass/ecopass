package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GPSE7Coordinate;

public interface GPSDistanceCalculator {

    double calculateMeters(GPSE7Coordinate point1, GPSE7Coordinate point2);
}
