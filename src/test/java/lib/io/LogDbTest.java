package lib.io;

import lib.LogConfig;
import lib.entity.Log;
import lib.utils.LogType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.SQLException;

public class LogDbTest {

    private LogDb logger = null;
    private static LogConfig logConfig;

    @Before
    public void setUp() throws SQLException {
        logConfig = new LogConfig(true, "jobLogger", "jobLogger123", "mysql", "localhost", "3306");
        logger = new LogDb(logConfig);
    }

    @After
    public void clean() throws SQLException {
        DatabaseLogger databaseLogger = DatabaseLogger.init(logConfig);
        databaseLogger.getConnection().createStatement().execute("truncate table log.Log_Values");
    }

    @AfterClass
    public static void CleanAll() throws SQLException {
        DatabaseLogger.destroy();
    }

    @Test
    public void shouldLogAnError() throws SQLException {
        logger.write(new Log("This a test message", LogType.ERROR));
        assertTrue(DatabaseLogger.init(logConfig).getConnection().createStatement().executeQuery("select * from log.Log_Values where type ="+ LogType.ERROR.getId()).first());
    }

    @Test
    public void shouldLogAMessage() throws SQLException {
        logger.write(new Log("This a test message", LogType.MESSAGE));
        assertTrue(DatabaseLogger.init(logConfig).getConnection().createStatement().executeQuery("select * from log.Log_Values where type ="+ LogType.MESSAGE.getId()).first());
    }

    @Test
    public void shouldLogAWarning() throws SQLException {
        logger.write(new Log("This a test message", LogType.WARNING));
        assertTrue(DatabaseLogger.init(logConfig).getConnection().createStatement().executeQuery("select * from log.Log_Values where type = "+LogType.WARNING.getId()).first());
    }

}
