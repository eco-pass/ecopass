package info.ecopass.locationhistory;

import java.util.ArrayList;
import java.util.List;

public class LocationHistoryStatistics {

    /**
     * Class used to gather statistical information about the entries of location history
     */

    private long totalRootEntries = 0;
    private long levelOneEntries = 0;
    private List<Integer> levelOneActivityLengths = new ArrayList<>();

    private long levelTwoEntries = 0;
    private List<Integer> levelTwoActivityLengths = new ArrayList<>();


    public void addLevelOneActivityLength(int length) {
        levelOneActivityLengths.add(length);
    }

    public void addLevelTwoActivityLength(int length) {
        levelTwoActivityLengths.add(length);
    }

    public void incrementRootEntries() {
        totalRootEntries++;
    }

    public void incrementLevelOneEntries() {
        levelOneEntries++;
    }

    public void incrementLevelTwoEntries() {
        levelTwoEntries++;
    }

    public void incrementLevelTwoEntries(int amount) {
        levelTwoEntries += amount;
    }

}
