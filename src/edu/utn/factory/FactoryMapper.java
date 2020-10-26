package edu.utn.factory;

import edu.utn.mapper.LoginMapper;
import edu.utn.mapper.UserMapper;

public class FactoryMapper {

    public static LoginMapper getLoginMapper(){
        return new LoginMapper();
    }

    public static UserMapper getUserMapper(){
        return new UserMapper();
    }
}
