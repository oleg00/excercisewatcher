package Util.Exception;

import Util.Logging.ILogger;

public class LoggingException extends Exception {

    public LoggingException(String msg) {
        super(msg);
    }

    public void Log(ILogger logger) {
        logger.Log(getMessage());
    }    
    
}
