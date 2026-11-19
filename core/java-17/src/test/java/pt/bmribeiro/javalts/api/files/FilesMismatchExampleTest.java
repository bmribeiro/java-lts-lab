package pt.bmribeiro.javalts.api.files;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FilesMismatchExampleTest {

    @TempDir
    Path tempDir;

    private final FilesMismatchExample example =
        new FilesMismatchExample();

    @Test
    void shouldReturnMinusOneWhenFilesAreIdentical() throws IOException {
        Path firstFile = tempDir.resolve("first.txt");
        Path secondFile = tempDir.resolve("second.txt");

        Files.writeString(firstFile, "Java 17");
        Files.writeString(secondFile, "Java 17");

        assertEquals(
            -1L,
            example.findFirstMismatch(firstFile, secondFile)
        );

        assertTrue(example.areFilesIdentical(firstFile, secondFile));
    }

    @Test
    void shouldReturnFirstDifferentBytePosition() throws IOException {
        Path firstFile = tempDir.resolve("first.txt");
        Path secondFile = tempDir.resolve("second.txt");

        Files.writeString(firstFile, "Java 17");
        Files.writeString(secondFile, "Java 21");

        assertEquals(
            5L,
            example.findFirstMismatch(firstFile, secondFile)
        );

        assertFalse(example.areFilesIdentical(firstFile, secondFile));
    }

    @Test
    void shouldReturnFirstPositionAfterCommonContent() throws IOException {
        Path firstFile = tempDir.resolve("first.txt");
        Path secondFile = tempDir.resolve("second.txt");

        Files.writeString(firstFile, "Java");
        Files.writeString(secondFile, "Java 17");

        assertEquals(
            4L,
            example.findFirstMismatch(firstFile, secondFile)
        );
    }

    @Test
    void shouldReturnMinusOneForTwoEmptyFiles() throws IOException {
        Path firstFile = tempDir.resolve("first.txt");
        Path secondFile = tempDir.resolve("second.txt");

        Files.createFile(firstFile);
        Files.createFile(secondFile);

        assertEquals(
            -1L,
            example.findFirstMismatch(firstFile, secondFile)
        );
    }

    @Test
    void shouldReturnZeroWhenFirstBytesAreDifferent() throws IOException {
        Path firstFile = tempDir.resolve("first.txt");
        Path secondFile = tempDir.resolve("second.txt");

        Files.writeString(firstFile, "Java");
        Files.writeString(secondFile, "Kotlin");

        assertEquals(
            0L,
            example.findFirstMismatch(firstFile, secondFile)
        );
    }
}
