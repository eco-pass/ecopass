package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GPSE7Coordinate;

public class HaversineGPSDistanceCalculator implements GPSDistanceCalculator {

   @Override
   public double calculateMeters(GPSE7Coordinate point1, GPSE7Coordinate point2) {
      final double earthRadius = 6371e3; // metres

      double latitudeE7Point1 = point1.getLatitude();
      double latitudeE7Point2 = point2.getLatitude();

      double longitudeE7Point1 = point1.getLongitude();
      double longitudeE7Point2 = point2.getLongitude();

      double latitudeDifference = Math.toRadians(latitudeE7Point2 - latitudeE7Point1);
      double longitudeDifference = (longitudeE7Point2 - longitudeE7Point1);

      double latitude1Radians = Math.toRadians(latitudeE7Point1);
      double latitude2Radians = Math.toRadians(latitudeE7Point2);
      System.out.println(latitude1Radians);

      double sinusSquareHalfLatDiff = Math.sin(latitudeDifference / 2) * Math.sin(latitudeDifference / 2);
      double cosineProductOfLatitudes = Math.cos(latitude1Radians) * Math.cos(latitude2Radians);
      double sineSquareHalfLongDiff = Math.sin(longitudeDifference / 2) * Math.sin(longitudeDifference / 2);

      double a = sinusSquareHalfLatDiff + cosineProductOfLatitudes * sineSquareHalfLongDiff;

      double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

      double d = earthRadius * c;
      return d * 1000;
   }
}
