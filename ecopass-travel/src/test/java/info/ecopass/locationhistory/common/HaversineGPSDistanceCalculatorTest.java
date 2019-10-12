package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GPSE7Coordinate;
import org.junit.Test;

import static org.junit.Assert.*;

public class HaversineGPSDistanceCalculatorTest {

    @Test
    public void calculateMeters() {
        // based on https://www.movable-type.co.uk/scripts/latlong.html
        // haversinse the two should be 29.3 meters
        //1564099212000, 472564732, 188930727, 3, 169, 3
        //1564099227000, 472562328, 188932317, 3, 172, 3
        double expectedDistance = 29.3D;
        GPSE7Coordinate pointOne = new GPSE7Coordinate(472564732, 188930727, 169);
        GPSE7Coordinate pointTwo = new GPSE7Coordinate(472562328, 188932317, 172);


        HaversineGPSDistanceCalculator haversineGPSDistanceCalculator = new HaversineGPSDistanceCalculator();
        double actualDistance = haversineGPSDistanceCalculator.calculateMeters(pointOne, pointTwo);
        assertEquals(expectedDistance, actualDistance, 0.1D);
    }
}