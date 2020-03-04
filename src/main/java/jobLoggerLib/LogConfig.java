package jobLoggerLib;

import java.util.HashMap;
import java.util.Map;

public class LogConfig {

    private boolean fileLog = false;
    private boolean dbLog = false;
    private boolean consoleLog = false;
    private String password;
    private String dbms;
    private String serverName;
    private String portNumber;
    private String logFileFolder;
    private String userName;

    public LogConfig() {}

    /* constructor for console log format*/
    public LogConfig(boolean consoleLog) {
        this.consoleLog = consoleLog;
    }
    /* constructor for file log format*/
    public LogConfig(boolean fileLog, String logFileFolder) {
        this.fileLog = fileLog;
        this.logFileFolder = logFileFolder;
    }
    /* constructor for database log format*/
    public LogConfig(boolean dbLog, String userName, String password, String dbms, String serverName, String portNumber) {
        this.dbLog = dbLog;
        this.userName = userName;
        this.password = password;
        this.dbms = dbms;
        this.serverName = serverName;
        this.portNumber = portNumber;
    }
    /* constructor for database and console log formats*/
    public LogConfig(boolean dbLog, boolean consoleLog, String userName, String password, String dbms, String serverName, String portNumber) {
        this.dbLog = dbLog;
        this.consoleLog = consoleLog;
        this.userName = userName;
        this.password = password;
        this.dbms = dbms;
        this.serverName = serverName;
        this.portNumber = portNumber;
    }
    /* constructor for database and file log formats*/
    public LogConfig(boolean dbLog, boolean fileLog, String userName, String password, String dbms, String serverName, String portNumber, String logFileFolder) {
        this.dbLog = dbLog;
        this.fileLog = fileLog;
        this.userName = userName;
        this.password = password;
        this.dbms = dbms;
        this.serverName = serverName;
        this.portNumber = portNumber;
        this.logFileFolder = logFileFolder;
    }
    /* constructor for console and file log formats*/
    public LogConfig(boolean consoleLog, boolean fileLog, String logFileFolder) {
        this.consoleLog = consoleLog;
        this.fileLog = fileLog;
        this.logFileFolder = logFileFolder;
    }
    /* constructor for database, console and file log formats*/
    public LogConfig(boolean fileLog, boolean dbLog, boolean consoleLog, String userName, String password, String dbms, String serverName, String portNumber, String logFileFolder) {
        this.fileLog = fileLog;
        this.dbLog = dbLog;
        this.consoleLog = consoleLog;
        this.userName = userName;
        this.password = password;
        this.dbms = dbms;
        this.serverName = serverName;
        this.portNumber = portNumber;
        this.logFileFolder = logFileFolder;
    }

    public Map<String, Object> map() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("fileLog", this.fileLog);
        map.put("consoleLog", this.consoleLog);
        map.put("dbLog", this.dbLog);
        map.put("userName",this.userName);
        map.put("password",this.password);
        map.put("serverName",this.serverName);
        map.put("portNumber",this.portNumber);
        map.put("dbms",this.dbms);
        map.put("logFileFolder",this.logFileFolder);
        return map;
    }

    public boolean isFileLog() {
        return fileLog;
    }

    public void setFileLog(boolean fileLog) {
        this.fileLog = fileLog;
    }

    public boolean isDbLog() {
        return dbLog;
    }

    public void setDbLog(boolean dbLog) {
        this.dbLog = dbLog;
    }

    public boolean isConsoleLog() {
        return consoleLog;
    }

    public void setConsoleLog(boolean consoleLog) {
        this.consoleLog = consoleLog;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbms() {
        return dbms;
    }

    public void setDbms(String dbms) {
        this.dbms = dbms;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public String getLogFileFolder() {
        return logFileFolder;
    }

    public void setLogFileFolder(String logFileFolder) {
        this.logFileFolder = logFileFolder;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LogConfig{" +
                "fileLog=" + fileLog +
                ", dbLog=" + dbLog +
                ", consoleLog=" + consoleLog +
                ", password='" + password + '\'' +
                ", dbms='" + dbms + '\'' +
                ", serverName='" + serverName + '\'' +
                ", portNumber='" + portNumber + '\'' +
                ", logFileFolder='" + logFileFolder + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
