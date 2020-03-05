package lib.io;

import lib.entity.Log;
import lib.utils.LogType;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

public class LogFileTest {

    private LogFile logger;
    private static String pathLogFile = "./testLogFile.txt";

    @Before
    public void setUp() throws IOException {
        logger = new LogFile(pathLogFile);
    }

    @AfterClass
    public static void clean() {
        File file = new File(pathLogFile);
        if(file.exists())
            file.delete();
        Logger.destroyFileHandler();
    }

    @Test
    public void shouldLogAnError() {
        logger.write(new Log("This a test message", LogType.ERROR));
    }

    @Test
    public void shouldLogAMessage() {
        logger.write(new Log("This a test message", LogType.MESSAGE));
    }

    @Test
    public void shouldLogAWarning() {
        logger.write(new Log("This a test message", LogType.WARNING));
    }
}
