package lib;

import lib.entity.Log;

public interface Logger {
    void write(Log log) throws Exception;
}
