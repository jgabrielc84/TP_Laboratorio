package edu.utn;

import edu.utn.dao.LoginDao;
//import edu.utn.dao.UserDao;
import edu.utn.entity.Login;
//import edu.utn.entity.User;
import edu.utn.manager.LoginManager;
//import edu.utn.manager.UserManager;
import edu.utn.mapper.LoginMapper;
//import edu.utn.mapper.UserMapper;

public class Main {
    public static void main(String[] args) {

        LoginDao loginDao = new LoginDao();
        LoginMapper loginMapper = new LoginMapper(loginDao);
        LoginManager loginManager = new LoginManager(loginMapper);

        
        Login login = new Login();
        login.setUser("Gabriel");
        login.setPassword("Chavez");

        Boolean loginSucces = loginManager.checkUserPassword(login);

        if(loginSucces){
            System.out.println("Goooool");
        }else{
            System.out.println("Ups");
        }



        // UserDao userDao = new UserDao();
        // UserMapper userMapper = new UserMapper(userDao);
        // UserManager userManager = new UserManager(userMapper);

        // User user = new User();

        // Boolean success = userManager.save(user);

    }
}
