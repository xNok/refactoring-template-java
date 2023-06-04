package extract.method.after;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class EmailService {
    Map<String, String> userEmailMap;

    public EmailService() {
        this.userEmailMap = new HashMap<>();
        this.userEmailMap.put("Gerry Smith", "g.smith@gmail.com");
        this.userEmailMap.put("Tom Brown", "t.brown@gmail.com");
        this.userEmailMap.put("Greg White", "g.white@gmail.com");
    }

    public void sendEmail(String receiverEmail, String sender, String content) throws Exception {
        validate(receiverEmail, sender, content);
        String senderEmail = userEmailMap.get(sender);
        this.send(receiverEmail, senderEmail, content);
    }

    private void send(String receiverEmail, String senderEmail, String content) {
        //actually send email
        System.out.printf("Send email from %s%n to %s%n, %s%n", senderEmail, receiverEmail, content);
    }

    private void validateEmail(String email) throws Exception {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if (!pattern.matcher(email).matches()) {
            throw new Exception("Email address is invalid");
        }

    }

    private void validateSenderEmailExist(String sender) throws Exception {
        if (!userEmailMap.containsKey(sender)) {
            throw new Exception("User not exist");
        }
        ;
    }

    private void validateContentSize(String content) throws Exception {
        if (content.length() < 500) {
            throw new Exception("Email content is oversize");
        }
        ;
    }

    private void validate(String receiver, String sender, String content) throws Exception {
        validateEmail(receiver);
        validateSenderEmailExist(sender);
        validateContentSize(content);
    }
}
