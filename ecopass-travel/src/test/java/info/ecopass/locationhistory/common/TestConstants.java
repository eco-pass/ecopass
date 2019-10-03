package info.ecopass.locationhistory.common;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestConstants {

    private static final String SRC_TEST_RESOURCES = "src/test/resources/";
    private static final String SHORT_LOCATION_HISTORY_FILENAME = "5kLineLocationHistory.json";
    private static final String FULL_LOCATION_HISTORY_FILENAME = "Location History.json";

    public static final Path SHORT_LOCATION_HISTORY = Paths.get(SRC_TEST_RESOURCES + SHORT_LOCATION_HISTORY_FILENAME);
    public static final Path FULL_LOCATION_HISTORY = Paths.get(SRC_TEST_RESOURCES + FULL_LOCATION_HISTORY_FILENAME);

}
