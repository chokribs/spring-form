package tn.iset.mahdia.formation.sevices;

import java.util.List;

import tn.iset.mahdia.formation.model.User;

public interface UserService {
	void addUser(User user);
	User getUser(String login);
	List<User> getListOfUser();

}
