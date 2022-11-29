package model.dao;

import java.util.List;

import mapper.IRowMapper;

 interface genericDao<T> {
	List<T> query(String sql, IRowMapper<T> rowMapper, Object... Parameters); 
	Long insert(String sql,Object... Parameters);
	void update(String sql,Object... Parameters);
	Integer count(String sql,Object... Parameters);
	
}