package lib.io;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

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
