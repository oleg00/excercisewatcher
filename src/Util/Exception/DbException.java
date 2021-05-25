package Util.Exception;

import Util.Logging.DbLogger;

public class DbException extends LoggingException {
    
    private static final DbLogger dbLogger = new DbLogger();

    public DbException(String msg) {
        super(msg);
        Log(dbLogger);
    }
}
