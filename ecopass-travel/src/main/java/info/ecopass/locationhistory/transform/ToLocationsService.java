package info.ecopass.locationhistory.transform;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import info.ecopass.locationhistory.model.LocationVO;
import info.ecopass.locationhistory.model.LocationsWrapper;
import lombok.SneakyThrows;

public class ToLocationsService {

	private Gson gson = new Gson();

	@SneakyThrows
	public List<LocationVO> readFullLocationHistory(String locationHistoryPath) {
		StringBuilder sb = new StringBuilder();
		try (Stream<String> jsonStream = streamResource(locationHistoryPath)) {
			jsonStream.forEach(line -> appendAsNewLine(sb, (String) line));
		}
		String jsonAsString = sb.toString();
		LocationsWrapper locationsWrapper = gson.fromJson(jsonAsString, new TypeToken<LocationsWrapper>() {
		}.getType());
		return locationsWrapper.getLocations();
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
