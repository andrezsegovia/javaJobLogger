package lib.io;

import lib.entity.Log;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.JVM)
public class LoggerTest {

    static Logger logger1 = null;
    static Logger logger2 = null;

    @Before
    public void setUp() {
        logger1 = Logger.init();
        logger2 = Logger.init();
    }

    @After
    public void clean() {
        logger1.destroyConsoleHandler();
        logger2.destroyFileHandler().destroy();
    }
    @Test
    public void createAnSingletonInstance() {
        assertEquals(logger1.hashCode(),logger2.hashCode());
    }
}
