package info.ecopass.locationhistory.model;

import java.util.List;


public class Location {
   private long timestampMs;
   private int latitudeE7;
   private int longitudeE7;
   private int accuracy;
   private int velocity;
   private int altitude;
   private int verticalAccuracy;

   private List<InnerActivities> activity;

   public static class InnerActivities {
      private long timestampMs;
      private List<DetectedActivityVO> activity;

      public long getTimestampMs() {
         return timestampMs;
      }

      public void setTimestampMs(long timestampMs) {
         this.timestampMs = timestampMs;
      }

      public List<DetectedActivityVO> getActivity() {
         return activity;
      }

      public void setActivity(List<DetectedActivityVO> activity) {
         this.activity = activity;
      }
   }

   public static class DetectedActivityVO {

      private Activity type;
      private int confidence;

      public Activity getType() {
         return type;
      }

      public void setType(Activity type) {
         this.type = type;
      }

      public int getConfidence() {
         return confidence;
      }

      public void setConfidence(int confidence) {
         this.confidence = confidence;
      }

      private enum Activity {
         STILL,
         ON_FOOT,
         WALKING,
         IN_VEHICLE,
         IN_ROAD_VEHICLE,
         IN_TWO_WHEELER_VEHICLE,
         IN_FOUR_WHEELER_VEHICLE,
         IN_RAIL_VEHICLE,
         ON_BICYCLE,
         RUNNING,
         TILTING,
         UNKNOWN,

      }
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

   public int getVelocity() {
      return velocity;
   }

   public void setVelocity(int velocity) {
      this.velocity = velocity;
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

   public List<InnerActivities> getActivity() {
      return activity;
   }

   public void setActivity(List<InnerActivities> activity) {
      this.activity = activity;
   }


}


