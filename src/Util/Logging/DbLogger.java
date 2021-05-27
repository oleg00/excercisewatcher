package Util.Logging;

import DAL.SQLClient.SQLClient;
import DAL.SQLClient.SQLClientSettings;
import Util.Exception.DbException;

public class DbLogger implements ILogger {

    private SQLClient _sqlClient;

    public DbLogger() {
        try {
            _sqlClient = new SQLClient(SQLClientSettings.DbPath);
        } catch (Exception ex) {
        }
    }

    @Override
    public void Log(String msg) {
        try {
            if (_sqlClient != null)
                _sqlClient.InsertLog(msg);
        } catch (Exception e) {
        }
    }

}
