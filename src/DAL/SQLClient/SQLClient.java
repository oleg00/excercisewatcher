package DAL.SQLClient;

import java.sql.*;
import DAL.Model.User;
import DAL.Model.VideoFile;
import Util.Exception.DbException;

/**
 * SQLite client that can connect to SQLite DB, execute select and insert queries.
 */
public class SQLClient {

    /**
     * DataBase JDBC Connection.
     */
    private Connection _dbConnection;

    /**
     * Ctor. Initializes SQL JDBC connection.
     * @param dbPath
     * @throws DbException
     */
    public SQLClient(String dbPath) throws DbException {
        _dbConnection = GetConnectionFromDriverManager(dbPath);
    }

    /**
     * Gets connection from the driver manager.
     * 
     * @param dbPath path to the db file
     * @see Connection
     * @throws CustomException
     */
    private Connection GetConnectionFromDriverManager(String dbPath) throws DbException {
        try {
            if (_dbConnection == null)
                _dbConnection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);

            return _dbConnection;
        } catch (SQLException e) {
            throw new DbException(
                    "GetConnectionFromDriverManager() exception: " + dbPath + "; message: " + e.getMessage());
        }
    }

    /**
     * Executes create query.
     * @param createQuery - SQL Create query
     * @return execution result
     * @throws DbException
     */
    public boolean ExecuteCreate(String createQuery) throws DbException {
        try {
            var statement = _dbConnection.prepareStatement(createQuery);
            return statement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    /**
     * Executes Select Query.
     * @param selectQuery - SQL Select query
     * @return ResultSet containing query result
     * @throws DbException
     */
    public ResultSet ExecuteSelect(String selectQuery) throws DbException {
        try {
            var statement = _dbConnection.prepareStatement(selectQuery);
            return statement.executeQuery();
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        }
    }

    /**
     * Executes select query with one "where" parameter with the  prepared statement.
     * @param selectQuery 
     * @param searchParameter
     * @return ResultSet containing query results
     * @throws DbException
     */
    public ResultSet ExecuteSelect(String selectQuery, String searchParameter) throws DbException {
        try {
            var statement = _dbConnection.prepareStatement(selectQuery);
            statement.setString(1, searchParameter);
            return statement.executeQuery();
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        }
    }

    /**
     * Executes SQL Statement.
     * @param stmt 
     * @see PreparedStatement
     * @return execution result
     * @throws DbException
     */
    public boolean ExecuteStatement(PreparedStatement stmt) throws DbException {
        try {
            return stmt.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    /**
     * Prepares User Insert/Update Statement
     * 
     * @param user
     * @return @see PreparedStatement
     * @throws DbException
     */
    private PreparedStatement PrepareUserStatement(User user) throws DbException {
        try {
            var statement = _dbConnection.prepareStatement(SQLClientSettings.InsertUserQuery);
            statement.setString(1, user.GetLogin());
            statement.setString(2, user.GetPasswordHash());
            return statement;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    /**
     * Prepares VideoFile Insert/Update Statement
     * 
     * @param video
     * @return @see PreparedStatement
     * @throws DbException
     */
    private PreparedStatement PrepareVideoFileStatement(VideoFile video) throws DbException {
        try {
            var statement = _dbConnection.prepareStatement(SQLClientSettings.InsertVideoFileQuery);
            statement.setInt(1, video.GetSize());
            statement.setInt(2, video.GetFormatType().ordinal());
            statement.setInt(3, video.GetDuration());
            statement.setString(4, video.GetFileUri());
            return statement;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    /**
     * Prepares Log Insert/Update Statement
     * 
     * @param user
     * @return @see PreparedStatement
     * @throws DbException
     */
    private PreparedStatement PrepareLogStatement(String msg) throws DbException {
        try {
            var statement = _dbConnection.prepareStatement(SQLClientSettings.InsertLogQuery);
            statement.setString(1, msg);
            return statement;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    /**
     * Executes Insert Query to the User Table.
     * @param user to insert
     * @return execution result
     * @throws DbException
     */
    public boolean InsertUser(User user) throws DbException {
        return ExecuteStatement(PrepareUserStatement(user));
    }

    /**
     * Executes Insert Query to the User Table.
     * @param user to insert
     * @return execution result
     * @throws DbException
     */
    public boolean InsertVideoFile(VideoFile videoFile) throws DbException {
        return ExecuteStatement(PrepareVideoFileStatement(videoFile));
    }

    /**
     * Executes insert query to the Log Table.
     * 
     * @param message to log
     * @throws DbException
     */
    public void InsertLog(String message) throws DbException {
        var stmt = PrepareLogStatement(message);
        ExecuteStatement(stmt);
    }

}
