package info.ecopass.locationhistory.ideas;


import info.ecopass.locationhistory.common.TestConstants;
import info.ecopass.locationhistory.common.util.LocationHistoryParser;
import info.ecopass.locationhistory.model.Location;
import info.ecopass.locationhistory.model.LocationLogEntry;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SpeedRangeFinderTest {

    @Test
    public void findWithinKilometersPerHour_onlyHasEntriesWithinSpeedLimit() {
        double minSpeed = 1.0;
        double maxSpeed = 2.0;
        List<List<LocationLogEntry>> expectedEntries = new ArrayList<>();
        List<List<LocationLogEntry>> actualEntries = SpeedRangeFinder.findWithinKilomtersPerHour(minSpeed, maxSpeed);
        assertEquals(expectedEntries, actualEntries);
    }

    @Test
    public void getSimpleMapLocationHistory() {
        List<Location> locations = LocationHistoryParser.readFullLocationHistory(TestConstants.FULL_LOCATION_HISTORY);

        Date from = fromString("2019-07-26__02:00:00.000");
        Date to = fromString("2019-07-26__02:39:00.000");

        List<LocationLogEntry> simpleLocations = locations.stream()
                .map(SpeedRangeFinderTest::from)
                .filter(fromTo(from, to))
                .collect(Collectors.toList());

        System.out.println(simpleLocations.size());
    }


    private static LocationLogEntry from(Location location) {
        LocationLogEntry to = new LocationLogEntry();
        to.setTimestampMs(location.getTimestampMs());
        to.setLatitudeE7(location.getLatitudeE7());
        to.setLongitudeE7(location.getLongitudeE7());
        to.setAccuracy(location.getAccuracy());
        to.setAltitude(location.getAltitude());
        to.setVerticalAccuracy(location.getVerticalAccuracy());
        return to;
    }


    private Predicate<LocationLogEntry> fromTo(Date from, Date to) {
        return loc -> (from.getTime() <= loc.getTimestampMs() && (loc.getTimestampMs() < to.getTime()));
    }

    private Date fromString(String from) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        try {
            return sdf.parse(from.replaceAll("\\D", ""));
        } catch (ParseException e) {
            throw new IllegalArgumentException("The following date cannot be parsed: " + from);
        }
    }

}
