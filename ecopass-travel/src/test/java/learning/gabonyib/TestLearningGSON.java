package learning.gabonyib;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import info.ecopass.locationhistory.model.LocationsWrapper;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import static info.ecopass.locationhistory.common.util.FileIO.streamResource;


public class TestLearningGSON {

    private static final String LOCATION_HISTORY_JSON = "5kLineLocationHistory.json";
    private Gson gson = new Gson();


    @Test
    public void testReadingShortJson() throws IOException, URISyntaxException {
        System.out.println("testing json readings");
        Stream<String> jsonStream = streamResource(LOCATION_HISTORY_JSON);
        StringBuilder sb = new StringBuilder();
        jsonStream.forEach(line -> appendAsNewLine(sb, (String) line));
        String jsonAsString = sb.toString();
        LocationsWrapper locations = gson.fromJson(jsonAsString, new TypeToken<LocationsWrapper>() {
        }.getType());
        System.out.println(locations.getLocations().size());
    }

    private static void appendAsNewLine(StringBuilder sb, String line) {
        sb.append(line);
        sb.append("\n");
    }

}
