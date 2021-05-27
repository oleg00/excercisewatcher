package DAL.Repository;

import java.util.ArrayList;

import DAL.Model.Exercise;
import DAL.Model.ExerciseGroupType;
import DAL.SQLClient.SQLClient;
import DAL.SQLClient.SQLClientSettings;
import Util.Exception.DbException;

public class ExerciseRepository implements IRepository<Exercise> {

    private SQLClient _sqlClient;

    public ExerciseRepository() throws DbException {
        _sqlClient = new SQLClient(SQLClientSettings.DbPath);
    }

    @Override
    public ArrayList<Exercise> GetAll() throws DbException {

        var exercises = new ArrayList<Exercise>();
        var rs = _sqlClient.ExecuteSelect(SQLClientSettings.SelectVideoFilesQuery);

        try {
            while (rs.next()) {
                var exercise = new Exercise(rs.getString("name"), rs.getString("description"),
                ExerciseGroupType.values()[rs.getInt("groupType")]);
                exercises.add(exercise);
            }
        } catch (Exception e) {
        }

        return exercises;
    }

    @Override
    public Exercise Get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean Add(Exercise entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean Update(Exercise entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean Delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    



}
