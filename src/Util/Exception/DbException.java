package Util.Exception;

import Util.Logging.DbLogger;

/**
 * Database Logging Exception.
 */
public class DbException extends LoggingException {
    
    public DbException(String msg) {
        super(msg);
        Log(new DbLogger());
    }
}
