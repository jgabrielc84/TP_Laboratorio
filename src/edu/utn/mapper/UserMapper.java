package edu.utn.mapper;

import java.lang.reflect.Parameter;
import java.util.Map;

import edu.utn.dao.UserDao;
import edu.utn.dto.UserDto;
import edu.utn.entity.User;
import edu.utn.factory.FactoryDao;

public class UserMapper {

	UserDao userDao;

	public UserMapper(){
		this.userDao = FactoryDao.getUserDao();
	}

	public int save(User user){
		UserDto userDto = new UserDto();
		Map<Integer, Object> parameters = userDto.setParameters(user);

		return userDao.saveNewUser(parameters);
	}

}
