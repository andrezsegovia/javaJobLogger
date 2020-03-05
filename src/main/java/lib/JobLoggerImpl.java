package jobLoggerLib;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import jobLoggerLib.entity.Log;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JobLoggerImpl implements JobLogger {

    private LogConfig logConfig;

    public JobLoggerImpl(LogConfig logConfig) throws IOException {
        this.logConfig = logConfig;
    }

    public void message(String text) throws Exception {
        if(logConfig.isFileLog()) {
            Logger logger = new LogFile(this.logConfig);
            logger.write(new Log("Message type: " + text +". To file.",  "message", this.logConfig));
        }
        if(logConfig.isConsoleLog()) {
            Logger logger = new LogConsole();
            logger.write(new Log("Message type: " + text+". To console.", "message", this.logConfig));
        }
        if(logConfig.isDbLog()) {
            Logger logger = new LogDb(this.logConfig);
            logger.write(new Log("Message type: " + text+". To database.", "message", this.logConfig));
        }
    }

    public void warning(String text) throws Exception {
        if(logConfig.isFileLog()) {
            Logger logger = new LogFile(this.logConfig);
            logger.write(new Log("Warning type: " + text+". To file.",  "warning", this.logConfig));
        }
        if(logConfig.isConsoleLog()) {
            Logger logger = new LogConsole();
            logger.write(new Log("Warning type: " + text+". To console.", "warning", this.logConfig));
        }
        if(logConfig.isDbLog()) {
            Logger logger = new LogDb(this.logConfig);
            logger.write(new Log("Warning type: " + text+". To database.", "warning", this.logConfig));
        }
    }

    public void error(String text) throws Exception {
        if(logConfig.isFileLog()) {
            Logger logger = new LogFile(this.logConfig);
            logger.write(new Log("Error type: " + text+". To file.",  "error", this.logConfig));
        }
        if(logConfig.isConsoleLog()) {
            Logger logger = new LogConsole();
            logger.write(new Log("Error type: " + text+". To console.", "error", this.logConfig));
        }
        if(logConfig.isDbLog()) {
            Logger logger = new LogDb(this.logConfig);
            logger.write(new Log("Error type: " + text+". To database.", "error", this.logConfig));
        }
    }

/*    private Map<String, String> readConfigFile(String configFile) throws IOException {
        *//*System.out.println(this.getClass().getClassLoader().getResource ("test/java/toConsole.yaml") .getFile());
        File file = new File(this.getClass().getClassLoader().getResource("test/java/toConsole.yaml").getFile());
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        LogConfig logConfig = om.readValue(file, LogConfig.class);
        System.out.println("LogConfig info: "+ logConfig.toString());
        return logConfig.map();*//*
    }*/
}
