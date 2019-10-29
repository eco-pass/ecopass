package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.GPSE7Coordinate;
import info.ecopass.locationhistory.model.Location;
import info.ecopass.locationhistory.model.LocationLogEntry;

public class LocationHaversineSpeedCalculator implements LocationSpeedCalculator {

    private GPSDistanceCalculator gpsDistanceCalculator;

    public LocationHaversineSpeedCalculator(HaversineGPSDistanceCalculator haversineGPSDistanceCalculator) {
        gpsDistanceCalculator = haversineGPSDistanceCalculator;
    }

    @Override
    public double calculateKilometersPerHour(Location firstLocation, Location secondLocation) {
        GPSE7Coordinate first = GPSE7Coordinate.from(firstLocation);
        GPSE7Coordinate second = GPSE7Coordinate.from(secondLocation);
        double haversineDistanceMeters = gpsDistanceCalculator.calculateMeters(first, second);
        long timeDifferenceMillis = Math.abs(firstLocation.getTimestampMs() - secondLocation.getTimestampMs());

        return calculateKilometersPerHour(haversineDistanceMeters, timeDifferenceMillis);
    }

    @Override
    public double calculateKilometersPerHour(LocationLogEntry firstEntry, LocationLogEntry secondEntry) {
        GPSE7Coordinate first = GPSE7Coordinate.from(firstEntry);
        GPSE7Coordinate second = GPSE7Coordinate.from(secondEntry);
        double haversineDistanceMeters = gpsDistanceCalculator.calculateMeters(first, second);
        long timeDifferenceMillis = Math.abs(firstEntry.getTimestampMs() - secondEntry.getTimestampMs());

        return calculateKilometersPerHour(haversineDistanceMeters, timeDifferenceMillis);
    }


}
