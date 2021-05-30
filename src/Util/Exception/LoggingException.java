package Util.Exception;

import Util.Logging.ILogger;

/**
 * Base Logging Exception. 
 */
public class LoggingException extends Exception {

    public LoggingException(String msg) {
        super(msg);
    }

    /**
     * Calls input logger instance Log() method.
     * @param logger - logger instance which will be called on exception handled (FileLogger/DbLogger)
     */
    public void Log(ILogger logger) {
        logger.Log(getMessage());
    }    
    
}
