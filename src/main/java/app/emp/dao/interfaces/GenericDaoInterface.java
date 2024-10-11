package app.emp.dao.interfaces;

import java.util.List;
import java.util.UUID;

public interface GenericDaoInterface <T>{
    void save(T entity);
    List<T> getAll();
    void delete(T entity);
    T getByID(UUID id);
    void update(T entity);
}
