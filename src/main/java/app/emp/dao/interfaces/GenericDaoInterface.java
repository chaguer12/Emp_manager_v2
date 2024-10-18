package app.emp.dao.interfaces;

import java.util.List;
import java.util.UUID;

public interface GenericDaoInterface <T>{
    T save(T entity);
    List<T> getAll();
    boolean delete(T entity);
    T getByID(UUID id);
    boolean update(T entity);
}
