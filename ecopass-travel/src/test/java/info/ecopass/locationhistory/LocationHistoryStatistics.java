package info.ecopass.locationhistory;


import java.util.*;

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

    public long getTotalRootEntries() {
        return totalRootEntries;
    }

    public void setTotalRootEntries(long totalRootEntries) {
        this.totalRootEntries = totalRootEntries;
    }

    public long getLevelOneEntries() {
        return levelOneEntries;
    }

    public void setLevelOneEntries(long levelOneEntries) {
        this.levelOneEntries = levelOneEntries;
    }

    public List<Integer> getLevelOneActivityLengths() {
        return levelOneActivityLengths;
    }

    public void setLevelOneActivityLengths(List<Integer> levelOneActivityLengths) {
        this.levelOneActivityLengths = levelOneActivityLengths;
    }

    public long getLevelTwoEntries() {
        return levelTwoEntries;
    }

    public void setLevelTwoEntries(long levelTwoEntries) {
        this.levelTwoEntries = levelTwoEntries;
    }

    public List<Integer> getLevelTwoActivityLengths() {
        return levelTwoActivityLengths;
    }

    public void setLevelTwoActivityLengths(List<Integer> levelTwoActivityLengths) {
        this.levelTwoActivityLengths = levelTwoActivityLengths;
    }

    @Override
    public String toString() {
        return "LocationHistoryStatistics{" +
                "totalRootEntries=" + totalRootEntries +
                ", levelOneEntries=" + levelOneEntries +
                ", levelOneActivityLengths=" + levelOneActivityLengths +
                ", levelTwoEntries=" + levelTwoEntries +
                ", levelTwoActivityLengths=" + levelTwoActivityLengths +
                '}';
    }
}
