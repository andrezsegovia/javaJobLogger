package lib.io;

import lib.entity.Log;
import lib.utils.LogType;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class LogConsoleTest {

    private LogConsole logger;

    @Before
    public void setUp() {
        logger = new LogConsole();
    }

    @AfterClass
    public static void clean() {
        Logger.destroyConsoleHandler();
    }
    @Test
    public void logAnErrorToConsole() {
        logger.write(new Log("This a test message", LogType.ERROR));
    }

    @Test
    public void logAMessageToConsole() {
        logger.write(new Log("This a test message", LogType.MESSAGE));
    }

    @Test
    public void logAWarningToConsole() {
        logger.write(new Log("This a test message", LogType.WARNING));
    }
}
