package lib.io;

import lib.Logger;
import lib.entity.Log;
import lib.utils.LogFormatter;

import java.util.Date;
import java.util.logging.Level;

public class LogConsole implements Logger {

    private static lib.io.Logger LOGGER = null;

    public LogConsole() {
        if(LOGGER == null) {
            LOGGER = lib.io.Logger.init().setConsoleHandler();
        }
    }

    @Override
    public void write(Log log) {
       LOGGER.log(Level.INFO, LogFormatter.doFmt(log.getMessage(), log.getType().getName(), new Date()));
    }
}
