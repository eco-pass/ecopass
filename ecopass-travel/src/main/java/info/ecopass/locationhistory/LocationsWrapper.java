package info.ecopass.locationhistory;

import info.ecopass.locationhistory.LocationVO;
import lombok.Data;

import java.util.List;

@Data
public class LocationsWrapper {

    private List<LocationVO> locations;
}
