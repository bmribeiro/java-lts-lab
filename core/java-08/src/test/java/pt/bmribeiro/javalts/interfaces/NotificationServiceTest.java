package pt.bmribeiro.javalts.interfaces;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    private final EmailNotificationService service =
        new EmailNotificationService();

    @Test
    void shouldImplementAbstractMethod() {
        service.send("user@example.com", "Hello");

        assertEquals(
            "user@example.com: Hello",
            service.getSentMessages().get(0)
        );
    }

    @Test
    void shouldUseDefaultMethodFromInterface() {
        service.sendWelcomeMessage("user@example.com");

        assertEquals(
            "user@example.com: Welcome to our application!",
            service.getSentMessages().get(0)
        );
    }

    @Test
    void shouldValidateRecipientUsingStaticMethod() {
        assertTrue(
            NotificationService.isValidRecipient("user@example.com")
        );

        assertFalse(
            NotificationService.isValidRecipient(null)
        );

        assertFalse(
            NotificationService.isValidRecipient("   ")
        );
    }

    @Test
    void shouldRejectInvalidRecipientWhenSending() {
        assertThrows(
            IllegalArgumentException.class,
            () -> service.send(null, "Hello")
        );
    }

    @Test
    void shouldReturnCopyOfSentMessages() {
        service.send("user@example.com", "Hello");

        List<String> messages = service.getSentMessages();
        messages.clear();

        assertEquals(1, service.getSentMessages().size());
    }
}

