
package pt.bmribeiro.javalts.platform;

/**
 * Demonstrates the removal of RMI Activation
 * from the Java platform.
 *
 * JEP: 407
 * Introduced: Java 17
 * Target Version: Java 17
 * Category: Platform / RMI
 */
public class RmiActivationRemovalExample {

    private static final String ACTIVATION_CLASS =
        "java.rmi.activation.Activatable";

    public boolean isRmiActivationAvailable() {
        try {
            Class.forName(ACTIVATION_CLASS);
            return true;
        } catch (ClassNotFoundException exception) {
            return false;
        }
    }

    public boolean isRmiAvailable() {
        try {
            Class.forName("java.rmi.Remote");
            return true;
        } catch (ClassNotFoundException exception) {
            return false;
        }
    }

    public String getRmiActivationStatus() {
        return isRmiActivationAvailable()
            ? "RMI Activation is available."
            : "RMI Activation is not available.";
    }

    public String getRmiStatus() {
        return isRmiAvailable()
            ? "Java RMI is available."
            : "Java RMI is not available.";
    }
}
