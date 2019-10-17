package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GPSE7Coordinate;

public interface GPSDistanceCalculator {

   /**
    * Calculates the distance of 2 GPSE7 coordinates
    *
    * @param point1 The first point
    * @param point2 The second point
    * @return The distance of the 2 coordinates in meters
    */
   double calculateMeters(GPSE7Coordinate point1, GPSE7Coordinate point2);
}
