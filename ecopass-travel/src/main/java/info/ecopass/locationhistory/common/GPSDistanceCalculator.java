package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GpsE7Coordinate;

public interface GPSDistanceCalculator {

    double calculateDistance(GpsE7Coordinate point1, GpsE7Coordinate point2);
}
