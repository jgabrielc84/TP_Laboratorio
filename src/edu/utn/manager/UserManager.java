package edu.utn.manager;

import edu.utn.entity.User;
import edu.utn.mapper.UserMapper;

public class UserManager {

    UserMapper userMapper;

    public UserManager(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public boolean save(User user){
        //return userMapper.save(user);
        return true;
    }
}
