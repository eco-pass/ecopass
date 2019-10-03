package info.ecopass.locationhistory.ideas;


import info.ecopass.locationhistory.model.LocationLogEntry;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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


}
