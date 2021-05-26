package DAL.SQLClient;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import Util.Exception.DbException;

public class SQLClientBase {

    private static Connection DbConnection;

    private String createQuery = "create";
    private String selectQuery = "select * from Table";
    private String dropQuery = "drop table Table";

    // private static final String selectLogQuery = "select * from Log order by Date
    // desc";

    // private static final String insertUserQuery = "insert into User(login,
    // passwordhash) values (?, ?)";
    // private static final String insertVideoFileQuery = "insert into
    // VideoFile(size, formatType, duration, fileUri) values (?, ?, ?, ?)";
    // private static final String insertLogQuery = "insert into Log(Message)
    // values(?)";

    // private static final String updateQuery = "update Hospital set Name = ?,
    // Address = ?, Profile = ?, PlacesCount = ?, DepartmentsCount = ?,
    // IsChildDepartment = ?, OpeningDate = ? where Id = ?";

    // private static final String dropUserQuery = "drop table User";
    // private static final String dropExerciseQuery = "drop table Exercise";
    // private static final String dropVideoFileQuery = "drop table VideoFile";

    // private static final String deleteQuery = "delete from Table where id = ?";

    public SQLClientBase(String dbPath) throws DbException {
        DbConnection = GetConnectionFromDriverManager(dbPath);
        CreateTable();
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
            if (DbConnection == null)
                DbConnection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);

            return DbConnection;
        } catch (SQLException e) {
            throw new DbException(
                    "GetConnectionFromDriverManager() exception: " + dbPath + "; message: " + e.getMessage());
        }
    }

    /**
     * Creates Hospital and Log tables
     * 
     * @param dbPath path to the db file
     * @throws CustomException
     */
    private void CreateTable() throws DbException {
        try {
            var statement = DbConnection.prepareStatement(createQuery);
            statement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    /**
     * Creates the db file
     * 
     * @param dbPath db to the db file
     * @throws CustomException
     */
    // private static void CreateDatabaseFile(String dbPath) throws CustomException
    // {
    // try {
    // var fileCreator = new File(dbPath);
    // fileCreator.createNewFile();
    // } catch (IOException e) {
    // throw new CustomException("Creating db file exception: " + e.getMessage());
    // }
    // }

    /**
     * Checks whether tables Hospital and Log exist
     * 
     * @param dbPath
     * @return true if tables exist
     * @throws CustomException
     */
    // public static boolean TablesExist(String dbPath) throws CustomException {
    // try {
    // var connection = GetConnectionFromDriverManager(dbPath);
    // var metadata = connection.getMetaData();
    // var hospitalDbSet = metadata.getTables(null, null, "Hospital", null);
    // var logDbSet = metadata.getTables(null, null, "Log", null);
    // boolean hospitalExists = false, logExists = false;

    // if (hospitalDbSet.next())
    // hospitalExists = !hospitalExists;

    // if (logDbSet.next())
    // logExists = !logExists;

    // return hospitalExists && logExists;

    // } catch (SQLException ex) {
    // throw new CustomException("Checking whether tables exist exception: " +
    // ex.getMessage());
    // }
    // }

    /**
     * Checks whether db file exists
     * 
     * @param dbPath path to the db file
     * @return true if exists
     * @throws CustomException
     */
    // public static boolean DbExists(String dbPath) throws CustomException {
    // var file = new File(dbPath);
    // return file.exists();
    // }

    /**
     * Parses HospitalIdentified entities from DB ResultSet.
     * 
     * @param rs
     * @return list of entities
     * @throws CustomException
     */
    // public static List<HospitalIdentified> GetResultSet(ResultSet rs) throws
    // CustomException {
    // var hospitals = new ArrayList<HospitalIdentified>();

    // try {
    // while (rs.next()) {
    // var hospital = new HospitalIdentified(rs.getString("Id"),
    // rs.getString("Name"), rs.getString("Address"),
    // rs.getString("Profile"), rs.getInt("PlacesCount"),
    // rs.getInt("DepartmentsCount"),
    // rs.getBoolean("IsChildDepartment"),
    // new MyDateStringConverter().fromString(rs.getString("OpeningDate")));
    // hospitals.add(hospital);
    // }
    // return hospitals;
    // } catch (Exception ex) {
    // throw new CustomException(ex.getMessage());
    // }
    // }

    /**
     * Retrieves Hospital data from the db using default select query.
     * 
     * @param dbPath path to the db file
     * @return list of hospital entities
     * @throws CustomException
     */
    private ResultSet GetSelect() throws DbException {
        try {
            var statement = DbConnection.prepareStatement(selectQuery);
            return statement.executeQuery();
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        }
    }

    /**
     * Executes Hospital insert query.
     * 
     * @param dbPath
     * @param hospital
     * @throws CustomException
     */
    // public static void Insert(String dbPath, HospitalIdentified hospital) throws
    // CustomException {
    // var connection = GetConnection(dbPath);

    // try {
    // var statement = connection.prepareStatement(insertQuery);

    // // for (var h : hospitals) {
    // FillStatementFieldsForUpdateOrInsert(statement, hospital);
    // statement.execute();
    // // }
    // } catch (SQLException e) {
    // System.err.println(e.getMessage());

    // throw new CustomException(e.getMessage());
    // }
    // }

    /**
     * Executes insert query to Log Table.
     * 
     * @param dbPath
     * @param message
     * @throws CustomException
     */
    // public static void InsertLog(String dbPath, String message) throws CustomException {
    //     var connection = GetConnection(dbPath);

    //     try {
    //         var statement = connection.prepareStatement(insertLogQuery);

    //         statement.setString(1, message);
    //         statement.execute();
    //     } catch (SQLException e) {
    //         System.err.println(e.getMessage());

    //         throw new CustomException(e.getMessage());
    //     }
    // }

    /**
     * Updates Hospital Identity.
     * 
     * @param dbPath path to db file
     * @param h      hospital entity to update
     * @throws CustomException
     */
    // public static void Update(String dbPath, HospitalIdentified h) throws
    // CustomException {
    // var connection = GetConnection(dbPath);

    // try {
    // var statement = connection.prepareStatement(updateQuery);
    // FillStatementFieldsForUpdateOrInsert(statement, h);

    // statement.executeUpdate();
    // } catch (SQLException e) {
    // System.err.println(e.getMessage());

    // throw new CustomException(e.getMessage());
    // }
    // }

    /**
     * Sets values in prepared statement for insert and update query.
     * 
     * @param statement
     * @param h
     * @throws SQLException
     */
    // private static void FillStatementFieldsForUpdateOrInsert(PreparedStatement
    // statement, HospitalIdentified h)
    // throws SQLException {
    // statement.setString(1, h.getName());
    // statement.setString(2, h.getAddress());
    // statement.setString(3, h.getProfile());
    // statement.setInt(4, h.getPlacesCount());
    // statement.setInt(5, h.getDepartmentsCount());
    // statement.setBoolean(6, h.getIsChildDepartment());
    // // statement.setDate(7, Date.valueOf(h.getOpeningDate().toInstant() //
    // Convert
    // // from legacy class `java.util.Date` (a moment in UTC) to a modern
    // // `java.time.Instant` (a moment in UTC).
    // // .atZone(ZoneId.of("Ukraine/Kyiv")) // Adjust from UTC to a particular time
    // // zone, to determine a date. Instantiating a `ZonedDateTime`.
    // // .toLocalDate()));
    // statement.setString(7, new
    // MyDateStringConverter().toString(h.getOpeningDate()));
    // statement.setString(8, h.getId());
    // }

    /**
     * Executes delete query.
     * 
     * @param dbPath
     * @param h
     * @throws CustomException
     */
    // public static void Delete(String dbPath, HospitalIdentified h) throws
    // CustomException {
    // var connection = GetConnection(dbPath);

    // try {
    // var statement = connection.prepareStatement(deleteQuery);
    // statement.setString(1, h.getId());
    // statement.executeUpdate();
    // } catch (SQLException e) {
    // System.err.println(e.getMessage());
    // throw new CustomException(e.getMessage());
    // }
    // }

    /**
     * Loads logs in reverse mode. (by Date)
     * 
     * @param dbPath
     * @return
     * @throws CustomException
     */
    // public static String LoadLog(String dbPath) throws CustomException {
    // var connection = GetConnection(dbPath);

    // try {
    // var statement = connection.prepareStatement(selectLogQuery);
    // var rs = statement.executeQuery();
    // var resultLog = "";
    // while (rs.next()) {
    // resultLog += rs.getString("Date") + ";" + rs.getString("Message") + "\n";
    // }
    // return resultLog;
    // } catch (SQLException e) {
    // System.err.println(e.getMessage());
    // throw new CustomException(e.getMessage());
    // }

    // }

    /**
     * Executes Drop Hospital query.
     * 
     * @param dbPath
     * @throws CustomException
     */
    public void DropDatabase(String dbPath) throws DbException {
        try {
            var statement = DbConnection.prepareStatement(dropQuery);
            statement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

}
