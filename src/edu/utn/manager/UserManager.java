package edu.utn.manager;

import edu.utn.entity.User;
import edu.utn.mapper.UserMapper;

public class UserManager {

    UserMapper userMapper;

    public UserManager(){

    }

    public boolean save(User user){
        return userMapper.save(user);
    }
}
