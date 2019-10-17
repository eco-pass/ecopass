package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GPSE7Coordinate;
import org.junit.Test;

import static org.junit.Assert.*;

public class HaversineGPSDistanceCalculatorTest {

   private static final double DELTA_DIVISOR = 1e8;

   @Test
   public void calculateMetersIsCorrectShortDistance() {
      double expectedDistance = 2.9301098166113785e1;
      double delta = expectedDistance / DELTA_DIVISOR;
      GPSE7Coordinate pointOne = new GPSE7Coordinate(472564732, 188930727, 0);
      GPSE7Coordinate pointTwo = new GPSE7Coordinate(472562328, 188932317, 0);

      HaversineGPSDistanceCalculator haversineGPSDistanceCalculator = new HaversineGPSDistanceCalculator();
      double actualDistance = haversineGPSDistanceCalculator.calculateMeters(pointOne, pointTwo);
      assertEquals(expectedDistance, actualDistance, delta);
   }

   @Test
   public void calculateMetersIsCorrectLongDistance() {
      double expectedDistance = 2.001508679602057e7;
      double delta = expectedDistance / DELTA_DIVISOR;
      GPSE7Coordinate pointOne = new GPSE7Coordinate(0, 0, 0);
      GPSE7Coordinate pointTwo = new GPSE7Coordinate(0, 1800000000, 0);

      HaversineGPSDistanceCalculator haversineGPSDistanceCalculator = new HaversineGPSDistanceCalculator();
      double actualDistance = haversineGPSDistanceCalculator.calculateMeters(pointOne, pointTwo);
      assertEquals(expectedDistance, actualDistance, delta);
   }
}