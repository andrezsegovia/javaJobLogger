package jobLoggerLib.entity;

import jobLoggerLib.LogConfig;

public class Log {
    private String message;
    private String type;
    private LogConfig logConfig;

    public Log(String message, String type, LogConfig logConfig) {
        this.message = message;
        this.type = type;
        this.logConfig = logConfig;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LogConfig getLogConfig() {
        return logConfig;
    }

    public void setLogConfig(LogConfig logConfig) {
        this.logConfig = logConfig;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
