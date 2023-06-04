package extract.method.after;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailServiceTest {

    @Test
    void should_not_sendEmail() {
        EmailService emailService = new EmailService();
        try {
            emailService.sendEmail("abc@gmail", "Gerry", "Hello Gerry, how are you?");
        } catch (Exception e) {
            Assertions.assertEquals(e.getMessage(), "User not exist");
        }
    }

    @Test
    void should_not_sendEmail_if_sender_not_exist() {
        extract.method.after.EmailService emailService = new EmailService();
        try {
            emailService.sendEmail("abc@gmail", "Abigail", "Hello Gerry, how are you?");
        } catch (Exception e) {
            Assertions.assertEquals(e.getMessage(), "User not exist");
        }
    }

}