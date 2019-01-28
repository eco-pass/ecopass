package info.ecopass.locationhistory.common.util;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileIO {

    public static Stream<String> streamResource(String folderName, String fileName) {
        try {
            return Files.lines(Paths.get(folderName, fileName));
        } catch (IOException ie) {
            throw new UncheckedIOException(ie);
        }
    }

    public static Stream<String> streamResource(String pathToFile) {
        try {
            return Files.lines(Paths.get(pathToFile));
        } catch (IOException ie) {
            throw new UncheckedIOException(ie);
        }
    }
}
