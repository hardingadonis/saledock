package io.hardingadonis.saledock.utils;

public class OtpUltil {

    public static String generateRandomOTP() {
        int otpLength = 6;
        String allowedDigits = "0123456789";
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < otpLength; i++) {
            int index = (int) (Math.random() * allowedDigits.length());
            otp.append(allowedDigits.charAt(index));
        }
        return otp.toString();
    }
}
