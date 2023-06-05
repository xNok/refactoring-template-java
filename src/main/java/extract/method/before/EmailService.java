package extract.method.before;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailService {

    Map<String, String> userEmailMap;

    public EmailService(Map<String, String> userEmailMap) {
        this.userEmailMap = userEmailMap;
    }

    /**
     * Send an email on behave of an user, to a receiver 
     * @param receiverEmail is an email, and the input string should be validated
     * @param sender is the name of the sender and it's email is retrive from our database
     * @param content is the body of the email and should be validated
     */
    public void sendEmail(String receiverEmail, String sender, String content) throws Exception {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(receiverEmail);
        if (matcher.matches()) {
            if (userEmailMap.containsKey(sender)) {
                String senderEmail = userEmailMap.get(sender);
                if (content.trim().length() < 500) {
                    this.send(receiverEmail, senderEmail, content);
                } else {
                    throw new Exception("Email content is oversize");
                }
            } else {
                throw new Exception("User not exist");
            }
        } else {
            throw new Exception("Email address not valid");
        }
    }

    private void send(String receiverEmail, String senderEmail, String content) {
        //send email
        System.out.printf("send email from %s%n to %s%n", senderEmail, receiverEmail);
    }
}
