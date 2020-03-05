import lib.JobLogger;
import lib.JobLoggerImpl;
import lib.entity.LogConfig;
import org.junit.Test;

public class JobLoggerTest {

    @Test
    public void shouldLogMessageConsole() throws Exception {
        LogConfig logConfig = new LogConfig(true);
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.message("This is a text message");
    }

    @Test
    public void shouldLogWarningToConsole() throws Exception {
        LogConfig logConfig = new LogConfig(true);
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.warning("This is a warning message");
    }

    @Test
    public void shouldLogErrorToConsole() throws Exception {
        LogConfig logConfig = new LogConfig(true);
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.error("This is an error message");
    }
    @Test
    public void shouldLogMessageToFile() throws Exception {
        LogConfig logConfig = new LogConfig(true, "./integrationTestLog.txt");
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.message("This is a text message");
    }

    @Test
    public void shouldLogWarningToFile() throws Exception {
        LogConfig logConfig = new LogConfig(true, "./integrationTestLog.txt");
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.warning("This is a warning message");
    }

    @Test
    public void shouldLogErrorToFile() throws Exception {
        LogConfig logConfig = new LogConfig(true, "./integrationTestLog.txt");
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.error("This is an error message");
    }
    @Test
    public void shouldLogMessageToDatabase() throws Exception {
        LogConfig logConfig = new LogConfig(true, "jobLogger", "jobLogger123", "mysql", "localhost", "3306");
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.message("This is a text message");
    }

    @Test
    public void shouldLogWarningToDatabase() throws Exception {
        LogConfig logConfig = new LogConfig(true, "jobLogger", "jobLogger123", "mysql", "localhost", "3306");
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.warning("This is a warning message");
    }

    @Test
    public void shouldLogErrorToDatabase() throws Exception {
        LogConfig logConfig = new LogConfig(true, "jobLogger", "jobLogger123", "mysql", "localhost", "3306");
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.error("This is an error message");
    }
}
