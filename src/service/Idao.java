package service;

import java.util.List;

/**
 *
 * @author wiemhjiri
 */
public interface Idao<T> {
    public void insert(T o);
    public void delete(T o);
    public List<T> displayAll();
    public T displayById(int id);
    
    public boolean update(T os);
    
}


