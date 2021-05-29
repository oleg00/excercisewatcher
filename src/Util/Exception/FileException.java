package Util.Exception;

import Util.Logging.FileLogger;

/**
 * File Logging Exception.
 */
public class FileException extends LoggingException {
    
    private static final FileLogger fileLogger = new FileLogger();

    public FileException(String msg) {
        super(msg);
        Log(fileLogger);
    }

}
