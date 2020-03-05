package lib;

public interface JobLogger {
    /**
     * writes a text of type {@link lib.utils.LogType#MESSAGE}
     * in the console, a file or the database
     * @param text the message of the log record
     * @throws Exception
     */
    void message(String text) throws Exception;

    /**
     * writes a text of type {@link lib.utils.LogType#WARNING}
     * in the console, a file or the database
     * @param text the message of the log record
     * @throws Exception
     */
    void warning(String text) throws Exception;

    /**
     * writes a text of type {@link lib.utils.LogType#ERROR}
     * in the console, a file or the database
     * @param text the message of the log record
     * @throws Exception
     */
    void error(String text) throws Exception;
}
