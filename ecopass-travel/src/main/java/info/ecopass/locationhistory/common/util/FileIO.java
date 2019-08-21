package info.ecopass.locationhistory.common.util;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileIO {

    public static Stream<String> streamResource(Path path) {
        try {
            return Files.lines(path);
        } catch (IOException ie) {
            throw new UncheckedIOException(ie);
        }
    }
}
