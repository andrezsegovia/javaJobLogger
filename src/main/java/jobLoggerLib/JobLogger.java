package jobLoggerLib;

import java.io.IOException;

public interface JobLogger {
    void message(String text) throws Exception;
    void warning(String text) throws Exception;
    void error(String text) throws Exception;
}
