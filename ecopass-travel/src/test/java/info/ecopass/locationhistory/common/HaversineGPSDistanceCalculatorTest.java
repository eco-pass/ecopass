package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GPSE7Coordinate;
import org.junit.Test;

import static org.junit.Assert.*;

public class HaversineGPSDistanceCalculatorTest {

   @Test
   public void calculateMetersIsCorrect() {
      // based on https://www.movable-type.co.uk/scripts/latlong.html
      // haversine of the two points should be 29.3 meters
      // latitudeE7: 472564732, longitudeE7: 188930727, accuracy: 3, altitude: 169, verticalAccuracy: 3
      // latitudeE7: 472562328, longitudeE7: 188932317, accuracy: 3, altitude: 172, verticalAccuracy: 3
      double expectedDistance = 29.3D;
      GPSE7Coordinate pointOne = new GPSE7Coordinate(472564732, 188930727, 169);
      GPSE7Coordinate pointTwo = new GPSE7Coordinate(472562328, 188932317, 172);


      HaversineGPSDistanceCalculator haversineGPSDistanceCalculator = new HaversineGPSDistanceCalculator();
      double actualDistance = haversineGPSDistanceCalculator.calculateMeters(pointOne, pointTwo);
      assertEquals(expectedDistance, actualDistance, 0.1D);
   }
}