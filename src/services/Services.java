package services;

import java.sql.SQLException;
import java.util.List;

public interface Services<E> {
	    void insert(E e);
	    void delete(E e);
	    public boolean update(E e)throws SQLException;
	    public List<E> readAll();
	    E readById(int id);   
}
