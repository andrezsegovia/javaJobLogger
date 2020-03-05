package lib.entity;

import lib.LogConfig;
import lib.utils.LogType;

public class Log {
    private String message;
    private LogType type;
    private LogConfig logConfig;

    public Log(String message, LogType type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LogType getType() {
        return type;
    }

    public void setType(LogType type) {
        this.type = type;
    }
}
