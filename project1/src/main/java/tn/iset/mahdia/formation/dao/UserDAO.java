package tn.iset.mahdia.formation.dao;

import java.util.List;

import tn.iset.mahdia.formation.model.User;

public interface UserDAO {
	public void insertUser(User user);
	public User finByUserLogin(String login);
	public List<User> getAllUsers();

}
