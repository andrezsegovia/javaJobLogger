package lib.utils;

import java.text.DateFormat;
import java.util.Date;

public class LogFormatter {

    public static String doFmt(String message, String type, Date date) {
        return "["+type.toUpperCase() +"]("+ DateFormat.getDateInstance(DateFormat.LONG).format(date) +") "+ message;
    }
}
