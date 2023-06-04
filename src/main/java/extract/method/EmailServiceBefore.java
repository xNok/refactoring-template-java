package extract.method;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailServiceBefore {

    Map<String, String> userEmailMap;

    public EmailServiceBefore() {
        this.userEmailMap = new HashMap<>();
        this.userEmailMap.put("Gerry Smith", "g.smith@gmail.com");
        this.userEmailMap.put("Tom Brown", "t.brown@gmail.com");
        this.userEmailMap.put("Greg White", "g.white@gmail.com");
    }

    public void sendEmail(String receiverEmail, String sender, String content) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(receiverEmail);
        if (matcher.matches()) {
            if (userEmailMap.containsKey(sender)) {
                String senderEmail = userEmailMap.get(sender);
                if (content.trim().length() < 500) {
                    this.send(receiverEmail, senderEmail, content);
                }
            }
        }
    }

    private void send(String receiverEmail, String senderEmail, String content) {
        //send email
        System.out.printf("send email from %s%n to %s%n", senderEmail, receiverEmail);
    }
}
