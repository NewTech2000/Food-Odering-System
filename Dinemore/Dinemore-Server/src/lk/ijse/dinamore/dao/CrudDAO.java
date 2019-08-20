package lk.ijse.dinamore.dao;

import java.util.List;

public interface CrudDAO<T ,ID> extends SuperDAO{

    public boolean Save(T entity)throws Exception;

    public boolean Update(T entity)throws Exception;

    public boolean delete(ID id)throws Exception;

    public T Search(ID id)throws Exception;

    public List<T> getAll()throws Exception;

    public List<T> getAllThree()throws Exception;

}
