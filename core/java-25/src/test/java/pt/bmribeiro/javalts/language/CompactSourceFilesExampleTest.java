
package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompactSourceFilesExampleTest {

    @Test
    void shouldExecuteCompactSourceFile() throws Exception {

        boolean windows = System.getProperty("os.name")
            .toLowerCase()
            .contains("win");

        Path javaExecutable = Path.of(
            System.getProperty("java.home"),
            "bin",
            windows ? "java.exe" : "java"
        );

        Path sourceFile = Path.of(
            "src",
            "main",
            "java",
            "CompactSourceFilesExample.java"
        ).toAbsolutePath();

        Process process = new ProcessBuilder(
            javaExecutable.toString(),
            sourceFile.toString()
        )
            .redirectErrorStream(true)
            .start();

        String output = new String(
            process.getInputStream().readAllBytes()
        ).trim();

        int exitCode = process.waitFor();

        assertEquals(0, exitCode, output);

        assertEquals("Hello, Java 25!", output);
    }
}
