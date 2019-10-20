package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GPSE7Coordinate;
import org.junit.Before;
import org.mockito.Mockito;

public class LocationHaversineSpeedCalculatorTest {

    private HaversineGPSDistanceCalculator haversineGPSDistanceCalculator;
    private LocationHaversineSpeedCalculator haversineSpeedCalculator;

    @Before
    public void setup() {
        haversineGPSDistanceCalculator = Mockito.mock(HaversineGPSDistanceCalculator.class);
        GPSE7Coordinate anyGPSE7Coordinate = Mockito.any(GPSE7Coordinate.class);
        Mockito.when(haversineGPSDistanceCalculator.calculateMeters(anyGPSE7Coordinate, anyGPSE7Coordinate))
                .thenReturn(1D);

        haversineSpeedCalculator = new LocationHaversineSpeedCalculator(haversineGPSDistanceCalculator);
    }

}
