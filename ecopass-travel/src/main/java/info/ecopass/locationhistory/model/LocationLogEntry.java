package info.ecopass.locationhistory.model;

import java.util.Objects;

public class LocationLogEntry {
   private long timestampMs;
   private int latitudeE7;
   private int longitudeE7;
   private int accuracy;
   private int altitude;
   private int verticalAccuracy;

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

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      LocationLogEntry that = (LocationLogEntry) o;
      return timestampMs == that.timestampMs &&
            latitudeE7 == that.latitudeE7 &&
            longitudeE7 == that.longitudeE7 &&
            accuracy == that.accuracy &&
            altitude == that.altitude &&
            verticalAccuracy == that.verticalAccuracy;
   }

   @Override
   public int hashCode() {
      return Objects.hash(timestampMs, latitudeE7, longitudeE7, accuracy, altitude, verticalAccuracy);
   }

   @Override
   public String toString() {
      String separator = ", ";
      return timestampMs + separator + latitudeE7 + separator + longitudeE7 + separator + accuracy + separator + altitude + separator + verticalAccuracy;
   }
}
