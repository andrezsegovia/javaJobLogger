package lib.io;

import lib.entity.LogConfig;
import lib.Logger;
import lib.entity.Log;
import lib.utils.LogFormatter;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class LogDb implements Logger {
    private static DatabaseLogger logger = null;

    public LogDb(LogConfig logConfig) throws SQLException {
        if(logger == null) {
            logger = DatabaseLogger.init(logConfig);
        }
    }

    @Override
    public void write(Log log) throws SQLException {
        Statement stmt = logger.getConnection().createStatement();
        stmt.executeUpdate("insert into log.Log_Values (message, type) values('"+ LogFormatter.doFmt(log.getMessage(), log.getType().getName(), new Date()) +"',"+log.getType().getId()+")");
    }
}
