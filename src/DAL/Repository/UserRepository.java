package DAL.Repository;

import java.util.ArrayList;

import DAL.Model.User;
import DAL.SQLClient.SQLClient;
import DAL.SQLClient.SQLClientSettings;
import Util.Exception.DbException;

public class UserRepository implements IRepository<User> {

    private SQLClient _sqlClient;

    public UserRepository() throws DbException {
        _sqlClient = new SQLClient(SQLClientSettings.DbPath);
    }

    public User Get(String login) {
        try {
            var rs = _sqlClient.ExecuteSelect(SQLClientSettings.SelectUserWhereLoginQuery, login);
            return new User(rs.getInt("id"), rs.getString("login"), rs.getString("passwordHash"));
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public ArrayList<User> GetAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User Get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean Add(User entity) throws DbException {
        return _sqlClient.InsertUser(entity);
    }

    @Override
    public boolean Update(User entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean Delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }


    
}
