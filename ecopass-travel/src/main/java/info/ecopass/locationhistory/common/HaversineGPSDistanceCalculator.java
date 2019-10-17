package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GPSE7Coordinate;

/**
 * Calculates the Haversine distance of 2 GPSE7 coordinates
 * NOTE: This formula ignores height and should not be used if there is a meaningful height difference
 * Source: https://www.movable-type.co.uk/scripts/latlong.html
 */
public class HaversineGPSDistanceCalculator implements GPSDistanceCalculator {

   @Override
   public double calculateMeters(GPSE7Coordinate point1, GPSE7Coordinate point2) {
      final double earthRadiusMeters = 6371e3;

      double latitudeE7Point1 = point1.getLatitude();
      double latitudeE7Point2 = point2.getLatitude();
      double latitudeDifferenceRad = Math.toRadians(latitudeE7Point2 - latitudeE7Point1);

      double longitudeE7Point1 = point1.getLongitude();
      double longitudeE7Point2 = point2.getLongitude();
      double longitudeDifferenceRad = Math.toRadians(longitudeE7Point2 - longitudeE7Point1);

      double latitude1Rad = Math.toRadians(latitudeE7Point1);
      double latitude2Rad = Math.toRadians(latitudeE7Point2);

      double sinusSquareHalfLatitudeDiff = Math.sin(latitudeDifferenceRad / 2) * Math.sin(latitudeDifferenceRad / 2);
      double cosineProductOfLatitudes = Math.cos(latitude1Rad) * Math.cos(latitude2Rad);
      double sineSquareHalfLongitudeDiff = Math.sin(longitudeDifferenceRad / 2) * Math.sin(longitudeDifferenceRad / 2);

      double a = sinusSquareHalfLatitudeDiff + cosineProductOfLatitudes * sineSquareHalfLongitudeDiff;
      double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

      return earthRadiusMeters * c;
   }
}
