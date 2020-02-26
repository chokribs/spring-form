package tn.iset.mahdia.formation.model;

public class User {
private String login;
private String password;
private String name;

public User(String login, String password, String name) {
	super();
	this.login = login;
	this.password = password;
	this.name = name;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "User [login=" + login + ", password=" + password + ", name=" + name + "]";
}


}
