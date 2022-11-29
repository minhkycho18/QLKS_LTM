package mapper;

import java.sql.ResultSet;

public interface IRowMapper<T> {
	T MappingRow(ResultSet rs);
}

