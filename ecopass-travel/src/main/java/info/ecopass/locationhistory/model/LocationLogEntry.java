package info.ecopass.locationhistory.model;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class LocationLogEntry {
    private long timestampMs;
    private int latitudeE7;
    private int longitudeE7;
    private int accuracy;
    private int altitude;
    private int verticalAccuracy;
    private double speedToNext;

    public static LocationLogEntry from(Location location) {
        LocationLogEntry locationLogEntry = new LocationLogEntry();

        locationLogEntry.setTimestampMs(location.getTimestampMs());

        locationLogEntry.setLatitudeE7(location.getLatitudeE7());
        locationLogEntry.setLongitudeE7(location.getLongitudeE7());
        locationLogEntry.setAccuracy(location.getAccuracy());

        locationLogEntry.setAltitude(location.getAltitude());
        locationLogEntry.setVerticalAccuracy(location.getVerticalAccuracy());

        return locationLogEntry;
    }

    public long getTimestampMs() {
        return timestampMs;
    }

    public void setTimestampMs(long timestampMs) {
        this.timestampMs = timestampMs;
    }

    public int getLatitudeE7() {
        return latitudeE7;
    }

    public void setLatitudeE7(int latitudeE7) {
        this.latitudeE7 = latitudeE7;
    }

    public int getLongitudeE7() {
        return longitudeE7;
    }

    public void setLongitudeE7(int longitudeE7) {
        this.longitudeE7 = longitudeE7;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getVerticalAccuracy() {
        return verticalAccuracy;
    }

    public void setVerticalAccuracy(int verticalAccuracy) {
        this.verticalAccuracy = verticalAccuracy;
    }

    public double getSpeedToNext() {
        return speedToNext;
    }

    public void setSpeedToNext(double speedToNext) {
        this.speedToNext = speedToNext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationLogEntry entry = (LocationLogEntry) o;
        return timestampMs == entry.timestampMs &&
                latitudeE7 == entry.latitudeE7 &&
                longitudeE7 == entry.longitudeE7 &&
                accuracy == entry.accuracy &&
                altitude == entry.altitude &&
                verticalAccuracy == entry.verticalAccuracy &&
                Double.compare(entry.speedToNext, speedToNext) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestampMs, latitudeE7, longitudeE7, accuracy, altitude, verticalAccuracy, speedToNext);
    }

    @Override
    public String toString() {
        String separator = ", ";
        return getReadableDate(timestampMs) + separator + (double)latitudeE7 + separator + longitudeE7 + separator + speedToNext + separator + accuracy + separator + altitude + separator + verticalAccuracy;
    }

    private String getReadableDate(long dateMillis) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss.SSS");
        Date toDisplay = Date.from(Instant.ofEpochMilli(dateMillis));
        return simpleDateFormat.format(toDisplay);
    }
}
