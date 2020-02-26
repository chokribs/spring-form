package tn.iset.mahdia.formation.dao.impl;

public class QueryText {
	public static final String SQL_FIND_USER="SELECT * FROM USERS WHERE LOGIN = ?";
	public static final String SQL_GET_ALL_USER="SELECT * FROM USERS";
	public static final String SQL_INSERT_USER="INSERT INTO USERS(LOGIN, PASSWORD, NAME) VALUES (?, ?, ?)";

}
