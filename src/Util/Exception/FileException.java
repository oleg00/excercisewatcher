package Util.Exception;

import Util.Logging.FileLogger;

public class FileException extends LoggingException {
    
    private static final FileLogger fileLogger = new FileLogger();

    public FileException(String msg) {
        super(msg);
        Log(fileLogger);
    }

}
