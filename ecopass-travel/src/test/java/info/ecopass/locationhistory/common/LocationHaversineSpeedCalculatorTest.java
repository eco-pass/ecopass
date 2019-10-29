package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GPSE7Coordinate;
import info.ecopass.locationhistory.model.Location;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class LocationHaversineSpeedCalculatorTest {

    private HaversineGPSDistanceCalculator haversineGPSDistanceCalculator;
    private LocationHaversineSpeedCalculator haversineSpeedCalculator;

    @Before
    public void setup() {
        haversineGPSDistanceCalculator = Mockito.mock(HaversineGPSDistanceCalculator.class);

        Mockito.when(haversineGPSDistanceCalculator.calculateMeters(any(GPSE7Coordinate.class), any(GPSE7Coordinate.class)))
                .thenReturn(1D);
        haversineSpeedCalculator = new LocationHaversineSpeedCalculator(haversineGPSDistanceCalculator);
    }

    @Test
    public void calculateReturnsCorrectValue() {
        Location point1 = new Location();
        point1.setTimestampMs(TimeUnit.SECONDS.toMillis(0));

        Location point2 = new Location();
        point2.setTimestampMs(TimeUnit.SECONDS.toMillis(1));

        double expectedSpeed = 3.6D;
        double actualSpeed = haversineSpeedCalculator.calculateKilometersPerHour(point1, point2);

        assertEquals(expectedSpeed, actualSpeed, 0D);
    }

}
