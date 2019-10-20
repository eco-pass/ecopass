package info.ecopass.locationhistory.common;

import info.ecopass.locationhistory.model.Location;

public interface LocationSpeedCalculator {

    double calculate(Location first, Location second);
}
