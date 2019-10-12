package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GPSE7Coordinate;

public class HaversineGPSDistanceCalculator implements GPSDistanceCalculator {

    @Override
    public double calculateMeters(GPSE7Coordinate point1, GPSE7Coordinate point2) {
        double R = 6371e3; // metres
        double latitude1Radiant = Math.toRadians(point1.getLatitudeE7());
        double latitude2Radiant = Math.toRadians(point2.getLatitudeE7());
        double latitudeDifference = Math.toRadians(point2.getLatitudeE7() - point1.getLatitudeE7());
        double longitudeDifference = (point2.getLongitudeE7() - point1.getLongitudeE7());

        double a = Math.sin(latitudeDifference / 2) * Math.sin(latitudeDifference / 2) +
                Math.cos(latitude1Radiant) * Math.cos(latitude2Radiant) *
                        Math.sin(longitudeDifference / 2) * Math.sin(longitudeDifference / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double d = R * c;
        return d;
    }
}
