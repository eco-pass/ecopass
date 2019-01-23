package info.ecopass.locationhistory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import info.ecopass.locationhistory.model.LocationVO;
import info.ecopass.locationhistory.model.LocationsWrapper;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

@Log
public class TestLocationHistoryAssumptions {

	private static final String LOCATION_HISTORY_JSON = "5kLineLocationHistory.json";
	private static final String RESOURCES_FOLDER = "src/test/resources";

	private Gson gson = new Gson();
	private final List<LocationVO> locations = readFullLocationHistory().getLocations();

	@Test
	public void gatherLocationHistoryStatistics() {
		LocationHistoryStatistics stats = new LocationHistoryStatistics();

		locations.forEach(locationVO -> {
			stats.incrementRootEntries();
			List<LocationVO.InnerActivities> activities = locationVO.getActivity();
			if (null == activities) {
				stats.addLevelOneActivityLength(0);
				stats.addLevelTwoActivityLength(0);
			} else {
				stats.addLevelOneActivityLength(activities.size());
				activities.forEach(innerActivity -> {
					stats.incrementLevelOneEntries();
					if (null == innerActivity) {
						stats.addLevelTwoActivityLength(0);
					} else {
						List<LocationVO.DetectedActivityVO> detectedActivities = innerActivity.getActivity();
						int activitySize = detectedActivities.size();
						stats.addLevelTwoActivityLength(activitySize);
						stats.incrementLevelTwoEntries(activitySize);
					}
				});
			}

		});
		int soCoolLetsDebugStats = 0;
		soCoolLetsDebugStats++;
		System.out.println(stats.toString());
	}

	@Test
	public void allRootLocationEntriesHaveDifferentTimeStamps() {
		Set<Long> locationTimestamps = new HashSet<>();
		locations.forEach(locationVO -> {
			long setSize = locationTimestamps.size();
			locationTimestamps.add(locationVO.getTimestampMs());
			if (locationTimestamps.size() == setSize) {
				Assert.fail("At least one Root location entry has a duplicate timestamp");
			}
		});
	}

	@Test
	public void outerLocationEntriesAreOrderedByTimestampDesc() {
		for (int i = 0; i < locations.size() - 1; i++) {
			long current = locations.get(i).getTimestampMs();
			long next = locations.get(i + 1).getTimestampMs();
			if (current < next) {
				throw new RuntimeException(
						"Timestamp conflicting descending order found\n" + getTimeStampErrorMessage(i, current, next));
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
		StringBuilder sb = new StringBuilder();
		try (Stream<String> jsonStream = streamResource(LOCATION_HISTORY_JSON)) {
			jsonStream.forEach(line -> appendAsNewLine(sb, (String) line));
		}
		String jsonAsString = sb.toString();
		return gson.fromJson(jsonAsString, new TypeToken<LocationsWrapper>() {
		}.getType());
	}

	private static void appendAsNewLine(StringBuilder sb, String line) {
		sb.append(line);
		sb.append("\n");
	}

	private Stream<String> streamResource(String resourceFileName) throws IOException, URISyntaxException {
		return Files.lines(Paths.get(RESOURCES_FOLDER, LOCATION_HISTORY_JSON));
	}
}
