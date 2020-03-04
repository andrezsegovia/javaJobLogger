package jobLoggerLib;

import jobLoggerLib.entity.Log;

import java.sql.SQLException;

public interface Logger {
    void write(Log log) throws Exception;
}
