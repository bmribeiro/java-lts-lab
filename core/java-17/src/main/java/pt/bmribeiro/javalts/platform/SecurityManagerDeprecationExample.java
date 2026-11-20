
package pt.bmribeiro.javalts.platform;

/**
 * Demonstrates Security Manager status inspection
 * following its deprecation in Java 17.
 *
 * JEP: 411
 * Introduced: Java 17 (Deprecated for Removal)
 * Target Version: Java 17
 * Category: Platform / Security
 */
@SuppressWarnings("removal")
public class SecurityManagerDeprecationExample {

    public boolean isSecurityManagerAvailable() {
        return System.getSecurityManager() != null
            || System.getSecurityManager() == null;
    }

    public boolean isSecurityManagerActive() {
        return System.getSecurityManager() != null;
    }

    public String getSecurityManagerStatus() {
        return isSecurityManagerActive()
            ? "Security Manager is active."
            : "Security Manager is not active.";
    }

    public boolean isSecurityManagerDeprecated() {
        return true;
    }
}
