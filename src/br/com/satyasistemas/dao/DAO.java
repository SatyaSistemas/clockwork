package br.com.satyasistemas.dao;

import java.util.List;
/**
 * Interface with basic operations in the database;
 * @author philippe
 *
 * @param <T>
 */
public interface DAO<T> {
	
	public void save(T t);
	public T findById(int id);
	public void delete(T t);
	public List<T> list();
	public List<T> pageList();
}
