package lib.io;

import lib.Logger;
import lib.entity.Log;
import lib.utils.LogFormatter;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;

public class LogFile implements Logger {

    private static lib.io.Logger LOGGER = null;

    public LogFile(String pathFile) throws IOException {
        if(LOGGER == null) {
            LOGGER = lib.io.Logger.init();
        }
        LOGGER.setFileHandler(pathFile);
    }

    @Override
    public void write(Log log) {
        LOGGER.log(Level.INFO, LogFormatter.doFmt(log.getMessage(), log.getType().getName(), new Date()));
    }
}
