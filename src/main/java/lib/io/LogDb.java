package lib;

import lib.entity.Log;
import lib.utils.LogFormatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class LogDb implements Logger {
    private Connection connection;

    public LogDb(LogConfig logConfig) throws SQLException {
        Properties properties = new Properties();
        properties.put("user", logConfig.getUserName());
        properties.put("password", logConfig.getPassword());
        this.connection = DriverManager.getConnection("jdbc:" + logConfig.getDbms() + "://" + logConfig.getServerName() + ":" + logConfig.getPortNumber() + "/", properties);
    }

    @Override
    public void write(Log log) throws SQLException {
        Statement stmt = this.connection.createStatement();
        stmt.executeUpdate("insert into log.Log_Values (message, type) values('"+ LogFormatter.doFmt(log.getMessage(), log.getType()) +"','3')");
    }
}
