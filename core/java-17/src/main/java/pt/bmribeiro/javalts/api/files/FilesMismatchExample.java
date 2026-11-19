package pt.bmribeiro.javalts.api.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Files.mismatch()
 *
 * Introduced: Java 12
 * Target Version: Java 17
 * Category: Files API
 */
public class FilesMismatchExample {

    public long findFirstMismatch(Path firstFile, Path secondFile)
        throws IOException {

        return Files.mismatch(firstFile, secondFile);
    }

    public boolean areFilesIdentical(Path firstFile, Path secondFile)
        throws IOException {

        return findFirstMismatch(firstFile, secondFile) == -1;
    }
}
