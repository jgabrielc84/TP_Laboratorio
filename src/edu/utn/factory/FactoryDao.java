package edu.utn.factory;

import edu.utn.dao.LoginDao;

public class FactoryDao {
    
    public static LoginDao getLoginDao(){
        return new LoginDao();
    }

}
