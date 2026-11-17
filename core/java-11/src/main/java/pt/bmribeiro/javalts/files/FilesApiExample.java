package pt.bmribeiro.javalts.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesApiExample {

    /**
     * Reads the content of a text file as a String.
     */
    public String readFile(Path path) throws IOException {
        return Files.readString(path);
    }

    /**
     * Writes a String into a text file.
     */
    public void writeFile(Path path, String content) throws IOException {
        Files.writeString(path, content);
    }
}
