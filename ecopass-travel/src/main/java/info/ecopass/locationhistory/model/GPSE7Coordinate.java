package info.ecopass.locationhistory.model;

/**
 * A GPS coordinate representation using integers
 * The decimal coordinate to be represented is obtained by
 */
public class GPSE7Coordinate {

    private int latitudeE7;
    private int longitudeE7;
    private int altitude;

    public GPSE7Coordinate(int latitudeE7, int longitudeE7, int altitude) {
        this.latitudeE7 = latitudeE7;
        this.longitudeE7 = longitudeE7;
        this.altitude = altitude;
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

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "GpsE7Coordinate{" +
                "latitudeE7=" + latitudeE7 +
                ", longitudeE7=" + longitudeE7 +
                ", altitude=" + altitude +
                '}';
    }
}
