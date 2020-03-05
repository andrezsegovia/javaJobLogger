package lib.utils;

import org.junit.Test;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;

public class LogFormatterTest {

    @Test
    public void doFormat() {
        String message = "This is a error message text";
        String type = "error";
        Date currentDate = new Date();
        String date = DateFormat.getDateInstance(DateFormat.LONG).format(currentDate);
        String messageFmt = LogFormatter.doFmt(message, type, currentDate);

        assertNotNull(messageFmt);
        assertTrue(messageFmt.toLowerCase().contains(type) );
        assertTrue(messageFmt.toLowerCase().contains(date.toLowerCase()));
        assertTrue(messageFmt.toLowerCase().contains(message.toLowerCase()));
    }


}
