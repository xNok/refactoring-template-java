package extract.method.after;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailServiceTest {

    @Test
    void should_not_sendEmail() {
        Map<String, String> userEmailMap = new HashMap<>();
        userEmailMap.put("Gerry Smith", "g.smith@gmail.com");
        userEmailMap.put("Tom Brown", "t.brown@gmail.com");
        userEmailMap.put("Greg White", "g.white@gmail.com");

        EmailService emailService = new EmailService(userEmailMap);
        try {
            emailService.sendEmail("abc@gmail", "Gerry", "Hello Gerry, how are you?");
        } catch (Exception e) {
            Assertions.assertEquals(e.getMessage(), "User not exist");
        }
    }

    @Test
    void should_not_sendEmail_if_sender_not_exist() {
        Map<String, String> userEmailMap = new HashMap<>();
        userEmailMap.put("Gerry Smith", "g.smith@gmail.com");
        userEmailMap.put("Tom Brown", "t.brown@gmail.com");
        userEmailMap.put("Greg White", "g.white@gmail.com");

        extract.method.after.EmailService emailService = new EmailService(userEmailMap);
        try {
            emailService.sendEmail("abc@gmail", "Abigail", "Hello Gerry, how are you?");
        } catch (Exception e) {
            Assertions.assertEquals(e.getMessage(), "User not exist");
        }
    }

}