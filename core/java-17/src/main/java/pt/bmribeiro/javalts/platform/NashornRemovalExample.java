package pt.bmribeiro.javalts.platform;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.List;

/**
 * Demonstrates JavaScript engine discovery through
 * the Java Scripting API after Nashorn removal.
 *
 * JEP: 372
 * Introduced: Java 15
 * Target Version: Java 17
 * Category: Platform / JavaScript Engine
 */
public class NashornRemovalExample {

    private final ScriptEngineManager engineManager;

    public NashornRemovalExample() {
        this.engineManager = new ScriptEngineManager();
    }

    public boolean isJavaScriptEngineAvailable() {
        return engineManager.getEngineByName("JavaScript") != null;
    }

    public boolean isNashornAvailable() {
        return engineManager.getEngineByName("nashorn") != null;
    }

    public List<String> getAvailableEngineNames() {
        return engineManager.getEngineFactories()
            .stream()
            .flatMap(factory -> factory.getNames().stream())
            .distinct()
            .sorted()
            .toList();
    }

    public String getNashornStatus() {
        return isNashornAvailable()
            ? "Nashorn JavaScript Engine is available."
            : "Nashorn JavaScript Engine is not available.";
    }
}
