package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GPSE7Coordinate;

public class HaversineGPSDistanceCalculator implements GPSDistanceCalculator {

   @Override
   public double calculateMeters(GPSE7Coordinate point1, GPSE7Coordinate point2) {
      final double earthRadius = 6371e3; // metres

      double latitudeE7Point1 = point1.getLatitude();
      double longitudeE7Point1 = point1.getLongitude();

      double latitudeE7Point2 = point2.getLatitude();
      double longitudeE7Point2 = point2.getLongitude();

      double latitude1Radians = Math.toRadians(latitudeE7Point1);
      double latitude2Radians = Math.toRadians(latitudeE7Point2);
      double latitudeDifference = Math.toRadians(latitudeE7Point2 - latitudeE7Point1);
      double longitudeDifference = (longitudeE7Point2 - longitudeE7Point1);

      double a = Math.sin(latitudeDifference / 2) * Math.sin(latitudeDifference / 2) +
            Math.cos(latitude1Radians) * Math.cos(latitude2Radians) *
                  Math.sin(longitudeDifference / 2) * Math.sin(longitudeDifference / 2);
      double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

      double d = earthRadius * c;
      return d * 1000;
   }
}
