package learning.gabonyib;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import info.ecopass.locationhistory.model.LocationsWrapper;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestLearningGSON {

    private static final String LOCATION_HISTORY_JSON = "Location History.json";
    private Gson gson = new Gson();


    @Test
    public void testReadingShortJson() throws IOException, URISyntaxException {
        System.out.println("testing json readings");
        Stream jsonStream = streamResource(LOCATION_HISTORY_JSON);
        StringBuilder sb = new StringBuilder();
        jsonStream.forEach(line -> appendAsNewLine(sb, (String) line));
        String jsonAsString = sb.toString();
        LocationsWrapper locations = gson.fromJson(jsonAsString, new TypeToken<LocationsWrapper>() {}.getType());
        System.out.println(locations.getLocations().size());
    }

    private static void appendAsNewLine(StringBuilder sb, String line) {
        sb.append(line);
        sb.append("\n");
    }


    private Stream<String> streamResource(String resourceFileName) throws IOException, URISyntaxException {
        Path path = Paths.get(getClass().getClassLoader().getResource(resourceFileName).toURI());
        return Files.lines(path);
    }
}
