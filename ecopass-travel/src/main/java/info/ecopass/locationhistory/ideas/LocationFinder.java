package info.ecopass.locationhistory.ideas;

import info.ecopass.locationhistory.model.Location;

import java.util.List;

public class LocationFinder {

    public static LocationFinder createFrom(List<Location> locations) {
        return new LocationFinder();
    }

    private LocationFinder() {
        // hide default constructor
    }
}
