package lib.io;

import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class Logger {

    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger("MyLog");
    private static Logger instanceLogger = null;
    private static ConsoleHandler consoleHandler = null;
    private static FileHandler fileHandler = null;
    private static String filePh = null;

    private Logger()  {}

    public static Logger init() {
        if(instanceLogger == null) {
            instanceLogger = new Logger();
        }
        return instanceLogger;
    }

    public void log(Level level, String message) {
        LOGGER.log(level, message);
    }

    public Logger setConsoleHandler() {
        if (consoleHandler == null) {
            consoleHandler = new ConsoleHandler();
            LOGGER.addHandler(consoleHandler);
        }
        return instanceLogger;
    }

    public Logger setFileHandler(String filePath) throws IOException {
        filePh = filePath;
        if(fileHandler == null) {
            fileHandler = new FileHandler(filePath);
            this.LOGGER.addHandler(fileHandler);
        }
        return instanceLogger;
    }

    public java.util.logging.Logger getLogger() {
        return LOGGER;
    }

    public static Logger destroyConsoleHandler() {
        if(consoleHandler != null) {
            LOGGER.removeHandler(consoleHandler);
        }
        return instanceLogger;
    }

    public static Logger destroyFileHandler() {
        if(fileHandler != null) {
            LOGGER.removeHandler(fileHandler);
        }
        return instanceLogger;
    }

    public static void destroy() {
        if(instanceLogger != null) {
            instanceLogger = null;
        }
    }

    public static Logger destroyLogFile() {
        if(fileHandler != null && filePh != null) {
            File file = new File(filePh);
            if (file.exists()) {
                file.delete();
            }
        }
        return instanceLogger;
    }
}
