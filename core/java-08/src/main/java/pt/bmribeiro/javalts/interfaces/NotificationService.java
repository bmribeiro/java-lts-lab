
package pt.bmribeiro.javalts.interfaces;

public interface NotificationService {

    void send(String recipient, String message);

    default void sendWelcomeMessage(String recipient) {
        send(recipient, "Welcome to our application!");
    }

    static boolean isValidRecipient(String recipient) {
        return recipient != null && !recipient.trim().isEmpty();
    }
}
