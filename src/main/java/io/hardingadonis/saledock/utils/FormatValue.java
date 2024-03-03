package io.hardingadonis.saledock.utils;

import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class FormatValue {
    public static String formatCurrency(double amount, String monetaryUnit) {
        NumberFormat currencyFormatter = null;
        switch (monetaryUnit) {
            case "VND":
                currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                break;
            default:
                System.out.println("Can't find valid moneytary unit!");
        }
         
        String formattedAmount = currencyFormatter.format(amount);

        return formattedAmount;
    }
    
    public static String formatDateTime(LocalDateTime dateTime) {
        String formattedTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return formattedTime;
    }
}
