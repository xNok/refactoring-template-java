package extract.method;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class EmailServiceAfter {
    Map<String, String> userEmailMap;

    public EmailServiceAfter() {
        this.userEmailMap = new HashMap<>();
        this.userEmailMap.put("Gerry Smith", "g.smith@gmail.com");
        this.userEmailMap.put("Tom Brown", "t.brown@gmail.com");
        this.userEmailMap.put("Greg White", "g.white@gmail.com");
    }

    public void sendEmail(String receiverEmail, String sender, String content) {
        if (validate(receiverEmail, sender, content)) {
            String senderEmail = userEmailMap.get(sender);
            this.send(receiverEmail, senderEmail, content);
        }
    }

    private void send(String receiverEmail, String senderEmail, String content) {
        //actually send email
        System.out.printf("Send email from %s%n to %s%n, %s%n", senderEmail, receiverEmail, content);
    }

    private boolean validateEmail(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        return pattern.matcher(email).matches();
    }

    private boolean validateSenderEmailExist(String sender) {
        return userEmailMap.containsKey(sender);
    }

    private boolean validateContentSize(String content) {
        return content.length() < 500;
    }

    private boolean validate(String receiver, String sender, String content) {
        return validateEmail(receiver) && validateSenderEmailExist(sender) && validateContentSize(content);
    }
}
