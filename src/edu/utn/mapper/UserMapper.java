package edu.utn.mapper;

import edu.utn.dao.UserDao;

public class UserMapper {

	UserDao userDao;


	public UserMapper(UserDao userDao){
		this.userDao = userDao;
	}

}
