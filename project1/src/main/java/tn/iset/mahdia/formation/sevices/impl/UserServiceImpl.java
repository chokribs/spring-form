package tn.iset.mahdia.formation.sevices.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import tn.iset.mahdia.formation.dao.UserDAO;
import tn.iset.mahdia.formation.model.User;
import tn.iset.mahdia.formation.sevices.UserService;
@Named("userService")
public class UserServiceImpl implements UserService {
	@Inject
	private UserDAO userDao;
	@Override
	public void addUser(User user) {		
		userDao.insertUser(user);
	}

	@Override
	public User getUser(String login) {
		return userDao.finByUserLogin(login);
	}

	@Override
	public List<User> getListOfUser() {
		return userDao.getAllUsers();
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

}
