package info.ecopass.locationhistory.ideas;

import info.ecopass.locationhistory.common.TestConstants;
import info.ecopass.locationhistory.common.util.LocationHistoryParser;
import info.ecopass.locationhistory.model.Location;
import info.ecopass.locationhistory.model.LocationLogEntry;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LostD750RelevantLocationsTest {

    @Test
    public void getSimpleMapLocationHistory() {
        List<Location> locations = LocationHistoryParser.readFullLocationHistory(TestConstants.FULL_LOCATION_HISTORY);

        Date from = fromString("2019-07-26__02:00:00.000");
        Date to = fromString("2019-07-26__02:39:00.000");

        List<LocationLogEntry> simpleLocations = locations.stream()
                .map(LostD750RelevantLocationsTest::from)
                .filter(fromTo(from, to))
                .collect(Collectors.toList());

        simpleLocations.forEach(System.out::println);
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