package Util.Exception;

import Util.Logging.DbLogger;

public class DbException extends LoggingException {
    
    public DbException(String msg) {
        super(msg);
        Log(new DbLogger());
    }
}
