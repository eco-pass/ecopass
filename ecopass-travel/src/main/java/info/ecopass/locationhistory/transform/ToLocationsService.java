package info.ecopass.locationhistory.transform;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import info.ecopass.locationhistory.common.util.FileIO;
import info.ecopass.locationhistory.model.*;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class ToLocationsService {

    private Gson gson = new Gson();

    public List<Location> readFullLocationHistory(Path locationHistoryPath) {
        StringBuilder sb = new StringBuilder();
        Stream<String> jsonStream = FileIO.streamResource(locationHistoryPath);
        jsonStream.forEach(line -> appendAsNewLine(sb, (String) line));

        String jsonAsString = sb.toString();
        LocationsWrapper locationsWrapper = gson.fromJson(jsonAsString, new TypeToken<LocationsWrapper>() {
        }.getType());
        return locationsWrapper.getLocations();
    }

    private static void appendAsNewLine(StringBuilder sb, String line) {
        sb.append(line);
        sb.append("\n");
    }

}
