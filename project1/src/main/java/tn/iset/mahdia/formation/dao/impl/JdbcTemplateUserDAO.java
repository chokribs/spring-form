package tn.iset.mahdia.formation.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;

import tn.iset.mahdia.formation.dao.UserDAO;
import tn.iset.mahdia.formation.model.User;
import tn.iset.mahdia.formation.model.UserMapper;
@Named
public class JdbcTemplateUserDAO implements UserDAO{
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertUser(User user) {
		System.out.println("JdbcTemplateUserDAO: insertUser");
		jdbcTemplate.update(QueryText.SQL_INSERT_USER, user.getLogin(),user.getPassword(),user.getName());		
	}

	@Override
	public User finByUserLogin(String login) {
		System.out.println("JdbcTemplateUserDAO: finByUserLogin");
		return jdbcTemplate.queryForObject(QueryText.SQL_FIND_USER, new Object[] {login},new UserMapper());
	}

	@Override
	public List<User> getAllUsers() {
		System.out.println("JdbcTemplateUserDAO: getAllUsers");
		List<User> users=jdbcTemplate.query(QueryText.SQL_GET_ALL_USER,new UserMapper() );
		return users;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
