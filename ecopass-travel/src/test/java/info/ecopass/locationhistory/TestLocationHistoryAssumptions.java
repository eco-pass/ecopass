package info.ecopass.locationhistory;

import info.ecopass.locationhistory.common.util.LocationHistoryParser;
import info.ecopass.locationhistory.model.Location;
import org.junit.*;

import java.nio.file.Paths;
import java.util.*;


public class TestLocationHistoryAssumptions {

    private static final String[] PATH_TO_LOCATION_HISTORY = {
            "src",
            "test",
            "resources",
            "5kLineLocationHistory.json"
    };

    private final List<Location> locations =
            LocationHistoryParser.readFullLocationHistory(Paths.get("", PATH_TO_LOCATION_HISTORY));

    @Test
    public void gatherLocationHistoryStatistics() {
        LocationHistoryStatistics stats = new LocationHistoryStatistics();

        locations.forEach(locationVO -> {
            stats.incrementRootEntries();
            List<Location.InnerActivities> activities = locationVO.getActivity();
            if (null == activities) {
                stats.addLevelOneActivityLength(0);
                stats.addLevelTwoActivityLength(0);
            } else {
                stats.addLevelOneActivityLength(activities.size());
                activities.forEach(innerActivity -> {
                    stats.incrementLevelOneEntries();
                    if (null == innerActivity) {
                        stats.addLevelTwoActivityLength(0);
                    } else {
                        List<Location.DetectedActivityVO> detectedActivities = innerActivity.getActivity();
                        int activitySize = detectedActivities.size();
                        stats.addLevelTwoActivityLength(activitySize);
                        stats.incrementLevelTwoEntries(activitySize);
                    }
                });
            }

        });
        System.out.println(stats.toString());
    }

    @Test
    public void allRootLocationEntriesHaveDifferentTimeStamps() {
        Set<Long> locationTimestamps = new HashSet<>();
        locations.forEach(locationVO -> {
            long setSize = locationTimestamps.size();
            locationTimestamps.add(locationVO.getTimestampMs());
            if (locationTimestamps.size() == setSize) {
                Assert.fail("At least one Root location entry has a duplicate timestamp");
            }
        });
    }

    @Test
    public void outerLocationEntriesAreOrderedByTimestampDesc() {
        for (int i = 0; i < locations.size() - 1; i++) {
            long current = locations.get(i).getTimestampMs();
            long next = locations.get(i + 1).getTimestampMs();
            if (current < next) {
                throw new RuntimeException(
                        "Timestamp conflicting descending order found\n" + getTimeStampErrorMessage(i, current, next));
            }
            if (0 == (i + 1) % 10000) {
                System.out.println(("processed " + i + " location entires"));
            }
        }
    }

    private String getTimeStampErrorMessage(int index, long current, long next) {
        return "Index: " + index + "\n" + "Current: " + current + "\nNext:    " + next;
    }

}
