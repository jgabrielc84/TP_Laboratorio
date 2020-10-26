package edu.utn.factory;

import edu.utn.dao.LoginDao;
import edu.utn.dao.UserDao;

public class FactoryDao {
    
    public static LoginDao getLoginDao(){
        return new LoginDao();
    }

    public static UserDao getUserDao(){
        return new UserDao();
    }

}
