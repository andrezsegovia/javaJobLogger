package jobLoggerLib.utils;

import java.text.DateFormat;
import java.util.Date;

public class LogFormatter {

    public static String doFmt(String message, String type) {
        return "["+type.toUpperCase() +"]("+ DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) +") "+ message;
    }
}
