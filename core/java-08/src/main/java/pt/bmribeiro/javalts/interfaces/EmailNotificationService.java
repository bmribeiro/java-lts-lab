package pt.bmribeiro.javalts.interfaces;

import java.util.ArrayList;
import java.util.List;

public class EmailNotificationService implements NotificationService {

    private final List<String> sentMessages = new ArrayList<>();

    @Override
    public void send(String recipient, String message) {
        if (!NotificationService.isValidRecipient(recipient)) {
            throw new IllegalArgumentException("Invalid recipient");
        }

        sentMessages.add(recipient + ": " + message);
    }

    public List<String> getSentMessages() {
        return new ArrayList<>(sentMessages);
    }
}
