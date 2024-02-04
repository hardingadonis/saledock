package io.hardingadonis.saledock.utils;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.*;
import java.util.logging.*;

public class SendEmailUtil {

    private static void sendEmail(String to, String title, String textMessage) {

        //properties : Khai báo thuộc tính
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //smtp host
        props.put("mail.smtp.port", "587"); // TSL 587, SSL 465
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        ResourceBundle resourceBundle = ResourceBundle.getBundle("email");
        final String from = resourceBundle.getString("email");
        final String password = resourceBundle.getString("password");

        Session session = Session.getInstance(props, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }

        });

        new Thread(() -> {
            try {
                Message message = prepareMessage(session, from, to, title, textMessage);
                Transport.send(message);
                System.out.println("Send email success!");
            } catch (MessagingException ex) {
                System.out.println("Send email fail!");
                Logger.getLogger(SendEmailUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }

    public static Message prepareMessage(Session session, String from, String recipient, String title, String textMessage) {

        try {
            Message message = new MimeMessage(session);
            message.addHeader("Content-type", "text/HTML; charset = UTF-8");
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient, false));
            message.setReplyTo(InternetAddress.parse(from, false));
            message.setSubject(title);
            message.setSentDate(new Date());
            message.setContent(textMessage, "text/html; charset=UTF-8");
            return message;

        } catch (MessagingException exception) {
            Logger.getLogger(SendEmailUtil.class.getName()).log(Level.SEVERE, null, exception);
        }
        return null;
    }

    public static void sendGetOTPMessage(String to, String title, String otp) {
        String message = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <title>Get OTP</title>\n"
                + "</head>\n"
                + "<body style=\"margin-bottom: 10px;\">\n"
                + "    <h3>Welcome to Sale Dock</h3>\n"
                + "    <p>Your OTP to change your account password is: " + otp + "</p>\n"
                + "    <p>Please usse this OTP to change your old password.</p>\n"
                + "    <img src=\"\" style=\"\">\n"
                + "</body>\n"
                + "</html>";
        sendEmail(to, title, message);
    }
}
