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

}


