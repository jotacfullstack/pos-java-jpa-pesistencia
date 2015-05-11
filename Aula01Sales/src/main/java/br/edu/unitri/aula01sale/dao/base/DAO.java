package br.edu.unitri.aula01sale.dao.base;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T, I> {
	T insert(T t) throws SQLException;

	boolean remove(I i) throws SQLException;

	boolean update(T t) throws SQLException;

	T getById(I i) throws SQLException;

	List<T> findAll() throws SQLException;

}
