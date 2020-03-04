import jobLoggerLib.JobLogger;
import jobLoggerLib.JobLoggerImpl;
import jobLoggerLib.LogConfig;
import org.junit.Test;

import java.io.IOException;

public class JobLoggerTest {

    @Test
    public void messageLogToConsole() throws Exception {
        LogConfig logConfig = new LogConfig(true);
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.message("This the a text message");
    }

    @Test
    public void warningLogToConsole() throws Exception {
        LogConfig logConfig = new LogConfig(true);
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.warning("This the a text message");
    }

    @Test
    public void errorLogToConsole() throws Exception {
        LogConfig logConfig = new LogConfig(true);
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.error("This the a text message");
    }
    @Test
    public void messageLogToFile() throws Exception {
        LogConfig logConfig = new LogConfig(true, "./log");
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.message("This the a text message");
    }

    @Test
    public void warningLogToFile() throws Exception {
        LogConfig logConfig = new LogConfig(true, "./log");
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.warning("This the a text message");
    }

    @Test
    public void errorLogToFile() throws Exception {
        LogConfig logConfig = new LogConfig(true, "./log");
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.error("This the a text message");
    }
    @Test
    public void messageLogToDatabase() throws Exception {
        LogConfig logConfig = new LogConfig(true, "jobLogger", "jobLogger123", "mysql", "localhost", "3306");
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.message("This the a text message");
    }

    @Test
    public void warningLogToDatabase() throws Exception {
        LogConfig logConfig = new LogConfig(true, "jobLogger", "jobLogger123", "mysql", "localhost", "3306");
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.warning("This the a text message");
    }

    @Test
    public void errorLogToDatabase() throws Exception {
        LogConfig logConfig = new LogConfig(true, "jobLogger", "jobLogger123", "mysql", "localhost", "3306");
        JobLogger jobLogger = new JobLoggerImpl(logConfig);
        jobLogger.error("This the a text message");
    }
}
