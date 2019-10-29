package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.Location;
import info.ecopass.locationhistory.model.LocationLogEntry;

import java.util.concurrent.TimeUnit;

public interface LocationSpeedCalculator {

    double METERS_PER_SEC_TO_KILOMETERS_PER_HOUR = 3.6D;

    default double calculateKilometersPerHour(double distanceMeters, long elapsedTimeMillis) {
        if (0D == distanceMeters || 0L == elapsedTimeMillis){
            return 0D;
        }
        double elapsedTimeSeconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTimeMillis);
        return (distanceMeters / elapsedTimeSeconds) * METERS_PER_SEC_TO_KILOMETERS_PER_HOUR;
    }

    double calculateKilometersPerHour(Location first, Location second);

    double calculateKilometersPerHour(LocationLogEntry first, LocationLogEntry second);
}
