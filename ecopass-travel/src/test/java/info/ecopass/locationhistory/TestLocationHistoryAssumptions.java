package info.ecopass.locationhistory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Log
public class TestLocationHistoryAssumptions {

    private static final String LOCATION_HISTORY_JSON = "ShortLocationHistory.json";
    private Gson gson = new Gson();
    private final List<LocationVO> locations = readFullLocationHistory().getLocations();

    @Test
    public void allLocationEntriesHaveDifferentTimeStamps() {

    }

    @Test
    public void outerLocationEntriesAreOrderedByTimestampDesc() {
        for (int i = 0; i < locations.size() - 1; i++) {
            long current = locations.get(i).getTimestampMs();
            long next = locations.get(i + 1).getTimestampMs();
            if (current < next) {
                throw new RuntimeException("Timestamp conflicting descending order found\n" + getTimeStampErrorMessage(i, current, next));
            }
            if (0 == (i + 1) % 10000) {
                log.info("processed " + i + " location entires");
            }
        }
    }

    private String getTimeStampErrorMessage(int index, long current, long next) {
        return "Index: " + index + "\n" + "Current: " + current + "\nNext:    " + next;
    }

    @SneakyThrows
    private LocationsWrapper readFullLocationHistory() {
        Stream jsonStream = streamResource(LOCATION_HISTORY_JSON);
        StringBuilder sb = new StringBuilder();
        jsonStream.forEach(line -> appendAsNewLine(sb, (String) line));
        String jsonAsString = sb.toString();
        return gson.fromJson(jsonAsString, new TypeToken<LocationsWrapper>() {
        }.getType());
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
