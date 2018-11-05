package info.ecopass;

import lombok.Data;

@Data
public class DetectedActivityVO {

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
