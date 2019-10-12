package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GPSE7Coordinate;

public class HaversineGPSDistanceCalculator implements GPSDistanceCalculator {

    @Override
    public double calculateMeters(GPSE7Coordinate point1, GPSE7Coordinate point2) {
        double R = 6371e3; // metres
        int latitudeE71 = point1.getLatitudeE7() / (10 * 1000 * 1000);
        int latitudeE72 = point2.getLatitudeE7() / (10 * 1000 * 1000);
        int longitudeE72 = point2.getLongitudeE7() / (10 * 1000 * 1000);
        int longitudeE71 = point1.getLongitudeE7() / (10 * 1000 * 1000);
        double latitude1Radiant = Math.toRadians(latitudeE71);
        double latitude2Radiant = Math.toRadians(latitudeE72);
        double latitudeDifference = Math.toRadians(latitudeE72 - latitudeE71);
        double longitudeDifference = (longitudeE72 - longitudeE71);

        double a = Math.sin(latitudeDifference / 2) * Math.sin(latitudeDifference / 2) +
                Math.cos(latitude1Radiant) * Math.cos(latitude2Radiant) *
                        Math.sin(longitudeDifference / 2) * Math.sin(longitudeDifference / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double d = R * c;
        return d * 1000;
    }
}
