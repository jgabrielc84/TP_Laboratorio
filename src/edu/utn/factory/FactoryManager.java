package edu.utn.factory;

import edu.utn.manager.LoginManager;
import edu.utn.manager.UserManager;

public class FactoryManager {

    public static LoginManager getLoginManager(){
        return new LoginManager();
    }
 
    public static UserManager getUserManager(){
        return new UserManager();
    }

}
