package jobLoggerLib;

import jobLoggerLib.entity.Log;
import jobLoggerLib.utils.LogFormatter;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class LogFile implements Logger {

    private FileHandler  fileHandler;
    private java.util.logging.Logger logger;

    public LogFile(LogConfig logConfig) throws IOException {
        File file = new File(logConfig.getLogFileFolder()+"/log.txt");
        if(!file.exists()) {
            file.createNewFile();
        }
        boolean setHandler = true;
        this.logger = java.util.logging.Logger.getLogger("FileLog");
        if(this.logger.getHandlers().length > 0) {
            for(int i = 0; i < this.logger.getHandlers().length; i++) {
                if(this.logger.getHandlers()[i] instanceof FileHandler) {
                    setHandler = false;
                }
            }
        }
        if(setHandler) {
            this.fileHandler = new FileHandler(logConfig.getLogFileFolder()+"/log.txt");
            this.logger.addHandler(this.fileHandler);
        }
    }

    @Override
    public void write(Log log) {
        this.logger.log(Level.INFO, LogFormatter.doFmt(log.getMessage(), log.getType()));
    }
}
