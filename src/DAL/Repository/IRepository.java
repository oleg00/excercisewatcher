package DAL.Repository;

import java.util.ArrayList;
import Util.Exception.DbException;

/**
 * Generic Repository design pattern implementation. 
 */
public interface IRepository<T> {

    /**
     * Gets all entities.
     * @return all present entities.
     * @throws DbException
     */
    ArrayList<T> GetAll() throws DbException;

    /**
     * Get entity by id.
     * @param id - id of the entity
     */
    T Get(int id) throws DbException;
    boolean Add(T entity) throws DbException;
    boolean Update(T entity) throws DbException;
    boolean Delete(int id) throws DbException;
    
}
