package DAL.SQLClient;

import Util.Exception.DbException;

public class SQLClientExercise extends SQLClientBase {

    //@Override
    private final String selectQuery = "select * from Exercise";
    //private static final String insertQuery = "insert into Exercise(name, description, groupType) values (?, ?, ?)";
    //private static final String updateQuery = "update Exercise set name = ?, description = ?, groupType = ? where id = ?";


    public SQLClientExercise(String dbPath) throws DbException {
        super(dbPath);
        //TODO Auto-generated constructor stub
    }

}
