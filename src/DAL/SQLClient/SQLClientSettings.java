package DAL.SQLClient;

/**
 * Describes static SQL Client Settings, such as DbPath and Create/Select/Insert queries.
 */
public class SQLClientSettings {

    public static final String DbPath = "/exercisedbtest.db";

    public static final String ExerciseTableCreateQuery = "create table Exercise(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, description TEXT, groupType TEXT)";
    public static final String UserTableCreateQuery = "create table User(id INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT, passwordhash TEXT)";
    public static final String VideoFileTableCreateQuery = "create table VideoFile(id INTEGER PRIMARY KEY AUTOINCREMENT, size INTEGER, formatType INTEGER, duration INTEGER, fileURI TEXT)";
    public static final String LogTableCreateQuery = "CREATE TABLE IF NOT EXISTS \"Log\" (\n"
    + "\t\"Date\"\tDATETIME DEFAULT (datetime('now','localtime')),\n" + "\t\"Message\"\tTEXT NOT NULL\n"
    + ");";

    public static final String SelectUserWhereLoginQuery = "select * from User where login = ?";
    public static final String SelectVideoFilesQuery = "select * from VideoFile";
    public static final String SelectExerciseQuery = "select * from Exercise";

    public static final String InsertLogQuery = "insert into Log(Message) values(?)";
    public static final String InsertUserQuery = "insert into User(login, passwordHash) values(?, ?)";
    public static final String InsertVideoFileQuery = "insert into VideoFile(size, formatType, duration, fileURI) values(?, ?, ?, ?)";
}
