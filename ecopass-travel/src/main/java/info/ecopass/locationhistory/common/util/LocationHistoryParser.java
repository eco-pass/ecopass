package info.ecopass.locationhistory.common.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import info.ecopass.locationhistory.model.*;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static info.ecopass.locationhistory.common.util.FileIO.streamResource;

public class LocationHistoryParser {

    public static List<Location> readFullLocationHistory(Path pathToFile) {
        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();
        Stream<String> jsonStream = streamResource(pathToFile);
        jsonStream.forEach(line -> appendAsNewLine(sb, line));
        String jsonAsString = sb.toString();
        LocationsWrapper parsed = gson.fromJson(jsonAsString, LocationsWrapper.class);
        return parsed.getLocations();
    }

    private static void appendAsNewLine(StringBuilder sb, String line) {
        sb.append(line);
        sb.append("\n");
    }
}
