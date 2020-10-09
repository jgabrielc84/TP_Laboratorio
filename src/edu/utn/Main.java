package edu.utn;

import java.sql.Connection;
import javax.swing.JOptionPane;

import edu.utn.dao.LoginDao;
import edu.utn.entity.DBConnection;
import edu.utn.dao.UserDao;
import edu.utn.entity.Login;
import edu.utn.entity.User;
import edu.utn.mapper.LoginMapper;
import edu.utn.mapper.UserMapper;
import edu.utn.manager.LoginManager;
import edu.utn.manager.UserManager;


public class Main {
    public static void main(String[] args) {

        LoginDao loginDao = new LoginDao();
        LoginMapper loginMapper = new LoginMapper(loginDao);
        LoginManager loginManager = new LoginManager(loginMapper);

        
        Login login = new Login("Gabriel", "Chavez"); //Este objeto se crea a partir del JSON
        
        Boolean loginSucces = loginManager.checkUserPassword(login);

        if(loginSucces){
            System.out.println("Bien hecho");
        }else{
            System.out.println("Ups, algo salió mal");
        }
        
        //------------------------------------------------------------------
        
        Connection connection = DBConnection.getDBConnection(); //Prueba de conexion a base de datos

        //------------------------------------------------------------------

        UserDao userDao = new UserDao();
        UserMapper userMapper = new UserMapper(userDao);
        UserManager userManager = new UserManager(userMapper);

        User user = new User(); //Este objeto se crea a partir del JSON

        Boolean success = userManager.save(user);

        //------------------------------------------------------------------

        
    }
}
