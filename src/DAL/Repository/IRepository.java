package DAL.Repository;

import java.util.ArrayList;

public interface IRepository<T> {
 
    ArrayList<T> GetAll();
    ArrayList<T> Get(int id);
    ArrayList<T> Add(T entity);
    ArrayList<T> Update(T entity);
    ArrayList<T> Delete(int id);
    
}
