package tn.iset.mahdia.formation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import tn.iset.mahdia.formation.dao.UserDAO;
import tn.iset.mahdia.formation.model.User;
//@Named
public class JdbcUserDAO implements UserDAO{
	@Inject
	private DataSource dataSource;
	@Override
	public void insertUser(User user) {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(QueryText.SQL_INSERT_USER);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

	@Override
	public User finByUserLogin(String login) {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(QueryText.SQL_FIND_USER);
			ps.setString(1, login);
			User user = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(
					rs.getString("LOGIN"),
					rs.getString("PASSWORD"), 
					rs.getString("NAME")
				);
			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public List<User> getAllUsers() {

		Connection conn = null;
		List<User> userList=new ArrayList<User>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(QueryText.SQL_GET_ALL_USER);
			
			User user = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(
					rs.getString("LOGIN"),
					rs.getString("PASSWORD"), 
					rs.getString("NAME")
				);
				userList.add(user);
			}
			rs.close();
			ps.close();
			return userList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
