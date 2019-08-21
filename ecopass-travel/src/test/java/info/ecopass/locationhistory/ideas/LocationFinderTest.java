package info.ecopass.locationhistory.ideas;

import info.ecopass.locationhistory.common.util.LocationHistoryParser;
import info.ecopass.locationhistory.model.Location;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.*;

import static info.ecopass.locationhistory.common.TestConstants.PATH_TO_LOCATION_HISTORY;

public class LocationFinderTest {

    // The first and last timestamps in the example 5k location history JSON
    private static final long FIRST_TIMESTAMP = 1548229582682L;
    private static final long LAST_TIMESTAMP = 1548169767331L;

    @Test (expected = IllegalArgumentException.class)
    public void getLocationsForInterval_intervalOpenLaterOrEqualToIntervalClose_notAllowed() {
        List<Location> locations = LocationHistoryParser.readFullLocationHistory(Paths.get("", PATH_TO_LOCATION_HISTORY));
        LocationFinder locationFinder = LocationFinder.createFrom(locations);
    }

    @Test
    public void getLocationsForInterval_intervalOpenEarlierThanFirst_entriesStartWithFirst(){

    }

}
