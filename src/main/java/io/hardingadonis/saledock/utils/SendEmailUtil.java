package io.hardingadonis.saledock.utils;

import io.hardingadonis.saledock.model.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.*;

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
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(SendEmailUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }

    public static Message prepareMessage(Session session, String from, String recipient, String title, String textMessage) throws UnsupportedEncodingException {

        try {
            Message message = new MimeMessage(session);
            message.addHeader("Content-type", "text/HTML; charset = UTF-8");
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient, false));
            message.setReplyTo(InternetAddress.parse(from, false));
            message.setSubject(MimeUtility.encodeText(title, "UTF-8", "B"));
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
    
    public static void sendOrderMessage(String to, String title, Order order) {
        
        String message = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <title>Đặt hàng thành công</title>\n"
                + "    <style>\n"
                + "        .table-cart {\n"
                + "            width: 100%;\n"
                + "            border-collapse: collapse;\n"
                + "        }\n"
                + "\n"
                + "        .table-cart th, .table-cart td {\n"
                + "            text-align: center;\n"
                + "            padding: 8px;\n"
                + "            border: 1px solid #ddd;\n"
                + "            min-width: 120px;\n"
                + "        }\n"
                + "\n"
                + "        .order-detail-field {\n"
                + "            margin: 0;\n"
                + "        }\n"
                + "    </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <p>Cảm ơn khách hàng <strong>" + order.getCustomer().getName() + "</strong></p>\n"
                + "    <p>Bạn đã đặt hàng thành công.</p>\n"
                + "    <p>Đây là chi tiết đơn hàng của bạn: </p>\n"
                + "    <table class=\"table-cart\">\n"
                + "        <thead>\n"
                + "            <tr>\n"
                + "                <th>\n"
                + "                    <h5><strong>Tên sản phẩm</strong></h5>\n"
                + "                </th>\n"
                + "                <th>\n"
                + "                    <h5><strong>Đơn giá</strong></h5>\n"
                + "                </th>\n"
                + "                <th>\n"
                + "                    <h5><strong>Số lượng</strong></h5>\n"
                + "                </th>\n"
                + "                <th>\n"
                + "                    <h5><strong>Thành tiền</strong></h5>\n"
                + "                </th>\n"
                + "            </tr>\n"
                + "        </thead>\n"
                + "        <tbody>";
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            message += "<tr>\n"
                    + "                <td>\n"
                    + "                    <p class=\"order-detail-field\">" + orderDetail.getProduct().getName()+ "</p>\n"
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    <p class=\"order-detail-field\">" + orderDetail.getProduct().getPrice() + " ₫</p> \n"
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    <p class=\"order-detail-field\">" + orderDetail.getQuantity()+ "</p> \n"
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    <p class=\"order-detail-field\">" + orderDetail.getProduct().getPrice()*orderDetail.getQuantity() + " ₫</p> \n"
                    + "                </td>\n"
                    + "            </tr>";
        }
        message += "</tbody>\n"
                + "    </table>\n"
                + "    <p>Tổng số tiền cần thanh toán cho đơn hàng là: <strong>" + order.getTotal() + " ₫</strong></p>\n"
                + "    <p>Địa chỉ giao hàng là: <strong>" + order.getCustomer().getAddress() + "</strong></p>\n"
                + "    <p>Thời gian đặt hàng: <strong>" + order.getCreatedAt() + "</p>\n"
                + "    <p>Vui lòng giữ liên lạc để nhận hàng trong thời gian tới.</p>\n"
                + "    <p><strong>Cảm ơn bạn đã tin tưởng Sale Dock!</strong></p>\n"
                + "</body>\n"
                + "</html>";
        sendEmail(to, title, message);
    }
}
