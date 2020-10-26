package edu.utn.dao;


import edu.utn.entity.Login;

public class LoginDao extends DataAccess{

    public LoginDao() {

    }

    public Login checkUserPassword(Login login) { // Acá va READ to DB?
        
        //Connection connection = DBConnection.getDBConnection();
        //READ
        //Actualizar el login
        login.setBlocked(false);
        login.setAttempts(2);
        
        return login;
    }
    
}
