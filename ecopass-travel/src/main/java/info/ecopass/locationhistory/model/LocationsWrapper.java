package info.ecopass.locationhistory.model;

import lombok.Data;

import java.util.List;

@Data
public class LocationsWrapper {

    private List<LocationVO> locations;
}
