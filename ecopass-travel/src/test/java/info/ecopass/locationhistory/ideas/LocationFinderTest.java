package info.ecopass.locationhistory.ideas;

import info.ecopass.locationhistory.common.util.LocationHistoryParser;
import info.ecopass.locationhistory.model.Location;
import org.junit.*;
import org.omg.CORBA.TIMEOUT;

import java.nio.file.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static info.ecopass.locationhistory.common.TestConstants.PATH_TO_LOCATION_HISTORY;

public class LocationFinderTest {

    // The first and last timestamps in the example 5k location history JSON
    private static final long FIRST_TIMESTAMP = 1548169767331L;
    private static final long THIRD_TIMESTAMP = 1548169941393L;
    private static final long FOURTH_TIMESTAMP = 1548169961465L;
    private static final long LAST_TIMESTAMP = 1548229582682L;

    private static final List<Location> locations = Collections.unmodifiableList(getTestLocations());

    @BeforeClass
    public static void validateConstants(){
        assert (FIRST_TIMESTAMP < THIRD_TIMESTAMP);
        assert (THIRD_TIMESTAMP < FOURTH_TIMESTAMP);
        assert (FOURTH_TIMESTAMP < LAST_TIMESTAMP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLocationsForInterval_intervalStartEqualToIntervalEnd_notAllowed() {
        LocationFinder locationFinder = LocationFinder.createFrom(locations);
        locationFinder.getLocationsForInterval(new Date(0L), new Date(0L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLocationsForInterval_intervalStartAfterIntervalEnd_notAllowed() {
        LocationFinder locationFinder = LocationFinder.createFrom(locations);
        locationFinder.getLocationsForInterval(new Date(1L), new Date(0L));
    }

    @Test
    public void getLocationsForInterval_startBeforeFirstEntryEndBetweenThirdAndFourth_returnsFirstThree() {
        long oneDayBeforeFirstTimeStamp = FIRST_TIMESTAMP - TimeUnit.DAYS.toMillis(1);
        Date oneDayEarlierThanFirst = new Date(oneDayBeforeFirstTimeStamp);

    }

    private static List<Location> getTestLocations() {
        Path locationHistoryPath = Paths.get("", PATH_TO_LOCATION_HISTORY);
        return LocationHistoryParser.readFullLocationHistory(locationHistoryPath);
    }

}
