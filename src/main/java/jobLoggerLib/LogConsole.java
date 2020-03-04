package jobLoggerLib;

import jobLoggerLib.entity.Log;
import jobLoggerLib.utils.LogFormatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class LogConsole implements Logger {

    private ConsoleHandler consoleHandler;
    private java.util.logging.Logger logger;

    public LogConsole() {

        this.logger = java.util.logging.Logger.getLogger("ConsoleLog");
        boolean setHandler = true;
        if(this.logger.getHandlers().length > 0) {
            for (int i = 0; i < this.logger.getHandlers().length; i++) {
                if (this.logger.getHandlers()[i] instanceof ConsoleHandler) {
                    setHandler = false;
                }
            }
        }
        if (setHandler) {
            this.consoleHandler = new ConsoleHandler();
            this.logger.addHandler(consoleHandler);
        }
    }

    @Override
    public void write(Log log) {
       this.logger.log(Level.INFO, LogFormatter.doFmt(log.getMessage(), log.getType()));
    }
}
