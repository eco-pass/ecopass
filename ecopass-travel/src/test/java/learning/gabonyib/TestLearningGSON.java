package learning.gabonyib;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestLearningGSON {

    private static final String LOCATION_HISTORY_JSON = "Location History.json";
    private Gson gson;



    private Stream<String> streamResource(String resourceFileName) throws IOException, URISyntaxException {
        Path path = Paths.get(getClass().getClassLoader().getResource(resourceFileName).toURI());
        return Files.lines(path);
    }
}
