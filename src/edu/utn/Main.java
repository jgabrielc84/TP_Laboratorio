package edu.utn;

import java.sql.Connection;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.utn.entity.DBConnection;
import edu.utn.entity.Login;
import edu.utn.entity.User;
import edu.utn.factory.FactoryManager;
import edu.utn.manager.LoginManager;
import edu.utn.manager.UserManager;

//@path ("/TPLabo")
public class Main {
    public static void main(String[] args) {

        //------------------------------------------------------------------
        
        Connection connection = DBConnection.getDBConnection(); //Prueba de conexion a base de datos

        //------------------------------------------------------------------

        //@path ("/checkUserPassword")
        Login login = new Login("Gabriel", "Chavez"); //Este objeto se crea a partir del JSON que viene del front
            
        LoginManager loginManager = FactoryManager.getLoginManager();
        Login loginSucces = loginManager.checkUserPassword(login);

        if(!loginSucces.isBlocked() && Login.getmaxAttempts() > login.getAttempts()){
            System.out.println("Login Bien hecho " + login.getUser());
        }else{
            System.out.println("Ups, algo salió mal con el Login");
        }

        //------------------------------------------------------------------
        
        UserManager userManager = FactoryManager.getUserManager();
        User user = new User("a@a.com", "Pepe", "Argento", "1960-05-16", "Hombre", "Racing"); //Este objeto se crea a partir del JSON

        int userSuccess = userManager.save(user);

        if(userSuccess > 0){
            System.out.println("Bien hecho, el id generado es: " + userSuccess);
        }else{
            System.out.println("Ups, algo salió mal!");
        }

        //------------------------------------------------------------------

                
    }
}
