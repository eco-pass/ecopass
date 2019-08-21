package info.ecopass.locationhistory.ideas;

import info.ecopass.locationhistory.common.util.LocationHistoryParser;
import info.ecopass.locationhistory.model.Location;
import org.junit.*;

import java.nio.file.*;
import java.util.*;

import static info.ecopass.locationhistory.common.TestConstants.PATH_TO_LOCATION_HISTORY;

public class LocationFinderTest {

    // The first and last timestamps in the example 5k location history JSON
    private static final long FIRST_TIMESTAMP = 1548229582682L;
    private static final long LAST_TIMESTAMP = 1548169767331L;
    private static final long FOURTH_TIMESTAMP = 1548229222589L;

    private List<Location> locations;


    @BeforeClass
    public void init() {
        Path locationHistoryPath = Paths.get("", PATH_TO_LOCATION_HISTORY);
        List<Location> locationHistoryPart = LocationHistoryParser.readFullLocationHistory(locationHistoryPath);
        locations = Collections.unmodifiableList(locationHistoryPart);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLocationsForInterval_intervalStartEqualToIntervalEnd_notAllowed() {
        List<Location> locations = LocationHistoryParser.readFullLocationHistory(Paths.get("", PATH_TO_LOCATION_HISTORY));
        LocationFinder locationFinder = LocationFinder.createFrom(locations);
        locationFinder.getLocationsForInterval(new Date(0L), new Date(0L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLocationsForInterval_intervalStartAfterIntervalEnd_notAllowed() {
        List<Location> locations = LocationHistoryParser.readFullLocationHistory(Paths.get("", PATH_TO_LOCATION_HISTORY));
        LocationFinder locationFinder = LocationFinder.createFrom(locations);
        locationFinder.getLocationsForInterval(new Date(1L), new Date(0L));
    }

    @Test
    public void getLocationsForInterval_intervalOpenEarlierThanFirst_entriesStartWithFirst() {

    }

}
