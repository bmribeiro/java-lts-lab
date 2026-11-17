package pt.bmribeiro.javalts.files;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FilesApiExampleTest {

    private final FilesApiExample example = new FilesApiExample();

    @TempDir
    Path tempDir;

    @Test
    void shouldWriteAndReadFile() throws IOException {
        Path file = tempDir.resolve("example.txt");
        String content = "Java 11 simplifies file operations.";

        example.writeFile(file, content);

        assertTrue(file.toFile().exists());
        assertEquals(content, example.readFile(file));
    }

    @Test
    void shouldReadMultilineContent() throws IOException {
        Path file = tempDir.resolve("multiline.txt");
        String content = "Java 8\nJava 11\nJava 17";

        example.writeFile(file, content);

        assertEquals(content, example.readFile(file));
    }
}
