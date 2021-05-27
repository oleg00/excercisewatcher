package DAL.Repository;

import java.util.ArrayList;

import Util.Exception.DbException;

public interface IRepository<T> {
 
    ArrayList<T> GetAll() throws DbException;
    T Get(int id) throws DbException;
    boolean Add(T entity) throws DbException;
    boolean Update(T entity) throws DbException;
    boolean Delete(int id) throws DbException;
    
}
