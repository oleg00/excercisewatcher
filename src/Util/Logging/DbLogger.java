package Util.Logging;

import DAL.SQLClient.SQLClient;
import DAL.SQLClient.SQLClientSettings;

/**
 * Implementation of the DataBase Logger. It uses SQLClient to log messages to the database.
 * @see SQLClient
 */
public class DbLogger implements ILogger {

    private SQLClient _sqlClient;

    /**
     * Ctor. Initializes SQLClient.
     */
    public DbLogger() {
        try {
            _sqlClient = new SQLClient(SQLClientSettings.DbPath);
        } catch (Exception ex) {
        }
    }

    /**
     * Calls InsertLog() SQLClient Method.
     * @param msg - message to log
     */
    @Override
    public void Log(String msg) {
        try {
            if (_sqlClient != null)
                _sqlClient.InsertLog(msg);
        } catch (Exception e) {
        }
    }

}
