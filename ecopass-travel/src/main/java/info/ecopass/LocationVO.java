package info.ecopass;

import lombok.Data;

import java.util.List;

@Data
public class LocationVO {
    private long timestampMs;
    private int latitudeE7;
    private int longitudeE7;
    private int accuracy;
    private int altitude;
    private int verticalAccuracy;
    private List<InnerActivities> activities;

    private class InnerActivities {
        private long timestampMs;
        List<DetectedActivityVO> detectedActivityVOS;
    }

    private static class DetectedActivityVO {

        private Activity activity;
        private int confidence;

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

}


