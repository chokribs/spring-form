package tn.iset.mahdia.formation.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user= new User(
				rs.getString("LOGIN"),
				rs.getString("PASSWORD"), 
				rs.getString("NAME")
			);
		return user;
	}

}
