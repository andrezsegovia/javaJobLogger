package lib;

import lib.entity.Log;
import lib.io.LogConsole;
import lib.io.LogDb;
import lib.io.LogFile;
import lib.utils.LogType;

import java.io.IOException;

public class JobLoggerImpl implements JobLogger {

    private LogConfig logConfig;

    public JobLoggerImpl(LogConfig logConfig) throws IOException {
        this.logConfig = logConfig;
    }

    public void message(String text) throws Exception {
        if(logConfig.isFileLog()) {
            Logger logger = new LogFile(this.logConfig.getLogFileFolder());
            logger.write(new Log("Message type: " + text +". To file.", LogType.MESSAGE));
        }
        if(logConfig.isConsoleLog()) {
            Logger logger = new LogConsole();
            logger.write(new Log("Message type: " + text+". To console.", LogType.MESSAGE));
        }
        if(logConfig.isDbLog()) {
            Logger logger = new LogDb(this.logConfig);
            logger.write(new Log("Message type: " + text+". To database.", LogType.MESSAGE));
        }
    }

    public void warning(String text) throws Exception {
        if(logConfig.isFileLog()) {
            Logger logger = new LogFile(this.logConfig.getLogFileFolder());
            logger.write(new Log("Warning type: " + text+". To file.", LogType.WARNING));
        }
        if(logConfig.isConsoleLog()) {
            Logger logger = new LogConsole();
            logger.write(new Log("Warning type: " + text+". To console.", LogType.WARNING));
        }
        if(logConfig.isDbLog()) {
            Logger logger = new LogDb(this.logConfig);
            logger.write(new Log("Warning type: " + text+". To database.", LogType.WARNING));
        }
    }

    public void error(String text) throws Exception {
        if(logConfig.isFileLog()) {
            Logger logger = new LogFile(this.logConfig.getLogFileFolder());
            logger.write(new Log("Error type: " + text+". To file.", LogType.ERROR));
        }
        if(logConfig.isConsoleLog()) {
            Logger logger = new LogConsole();
            logger.write(new Log("Error type: " + text+". To console.", LogType.ERROR));
        }
        if(logConfig.isDbLog()) {
            Logger logger = new LogDb(this.logConfig);
            logger.write(new Log("Error type: " + text+". To database.", LogType.ERROR));
        }
    }
}
