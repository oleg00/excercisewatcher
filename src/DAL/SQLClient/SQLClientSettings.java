package DAL.SQLClient;

public class SQLClientSettings {

    public static final String DbPath = "";

    public static final String LogTableName = "Log";
    
    public static final String ExerciseTableCreateQuery = "create table Exercise(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, description TEXT, groupType TEXT)";
    public static final String UserTableCreateQuery = "create table User(id INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT, passwordhash TEXT)";
    public static final String VideoFileTableCreateQuery = "create table VideoFile(id INTEGER PRIMARY KEY AUTOINCREMENT, size INTEGER, formatType INTEGER, duration INTEGER, fileURI TEXT)";
    public static final String LogTableCreateQuery = "CREATE TABLE IF NOT EXISTS \"Log\" (\n"
    + "\t\"Date\"\tDATETIME DEFAULT (datetime('now','localtime')),\n" + "\t\"Message\"\tTEXT NOT NULL\n"
    + ");";

}
