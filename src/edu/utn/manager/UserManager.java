package edu.utn.manager;

import edu.utn.entity.User;
import edu.utn.factory.FactoryMapper;
import edu.utn.mapper.UserMapper;

public class UserManager {

    private UserMapper userMapper;

    public UserManager(){
        this.userMapper = FactoryMapper.getUserMapper();
    }

    public int save(User user){
        return userMapper.save(user);
    }
}
