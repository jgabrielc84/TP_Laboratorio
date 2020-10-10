package edu.utn.factory;

import edu.utn.mapper.LoginMapper;

public class FactoryMapper {

    public static LoginMapper getLoginMapper(){
        return new LoginMapper();
    }
    
}
