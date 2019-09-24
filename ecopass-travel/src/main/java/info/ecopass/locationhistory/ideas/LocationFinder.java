package info.ecopass.locationhistory.ideas;

import info.ecopass.locationhistory.model.Location;

import java.util.*;

public class LocationFinder {

    private static final String FROM_DATE_BAD_NOT_EARLIER = "From date should be earlier than To but it was ";
    private static final String EQUAL = "equal";
    private static final String LATER = "later";
    private static final String DATE_CANNOT_BE_NULL = " date cannot be null";
    private static final String FROM = "From";
    private static final String TO = "To";

    public static LocationFinder createFrom(List<Location> locationHistoryEntries) {
        return new LocationFinder();
    }

    private LocationFinder() {
        // hide default constructor
    }

    public List<Location> getLocationsForInterval(Date start, Date end) {
        validateArgs(start, end);
        return null;
    }

    private void validateArgs(Date from, Date to) {
        validateFromToNonNull(from, to);
        validateFromEarlierThanTo(from, to);
    }

    private void validateFromToNonNull(Date from, Date to) {
        Objects.requireNonNull(from, FROM + DATE_CANNOT_BE_NULL);
        Objects.requireNonNull(to, TO + DATE_CANNOT_BE_NULL);
    }

    private void validateFromEarlierThanTo(Date from, Date to){
        if (from.equals(to)){
            throw new IllegalArgumentException(FROM_DATE_BAD_NOT_EARLIER + EQUAL);
        }
        if (from.after(to)) {
            throw new IllegalArgumentException(FROM_DATE_BAD_NOT_EARLIER + LATER);
        }
    }
}
