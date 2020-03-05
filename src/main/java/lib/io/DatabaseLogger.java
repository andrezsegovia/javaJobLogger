package lib.io;

import lib.entity.LogConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseLogger {

    private static DatabaseLogger databaseLogger = null;

    private static Connection connection = null;

    private DatabaseLogger() {}

    private DatabaseLogger(LogConfig logConfig) throws SQLException {
        Properties properties = new Properties();
        properties.put("user", logConfig.getUserName());
        properties.put("password", logConfig.getPassword());
        connection = DriverManager.getConnection("jdbc:" + logConfig.getDbms() + "://" + logConfig.getServerName() + ":" + logConfig.getPortNumber() + "/", properties);
    }

    public static DatabaseLogger init(LogConfig logConfig) throws SQLException {
        if(databaseLogger == null) {
            databaseLogger = new DatabaseLogger(logConfig);
        }
        return databaseLogger;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void destroy() throws SQLException {
        if(connection !=  null) {
            connection.close();
            connection = null;
        }
        if(databaseLogger != null) {
            databaseLogger = null;
        }
    }
}
