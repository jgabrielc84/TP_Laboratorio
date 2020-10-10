package edu.utn.mapper;

import edu.utn.dao.LoginDao;
import edu.utn.entity.Login;
import edu.utn.factory.FactoryDao;

public class LoginMapper {

    LoginDao loginDao;

    public LoginMapper() {
        this.loginDao = FactoryDao.getLoginDao();
        //setLoginDao(FactoryDao.getLoginDao()); se usa directamente o por medio del metodo??
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public LoginDao getLoginDao() {
        return loginDao;
    }

    public Boolean checkUserPassword(Login login) {
        return loginDao.checkUserPassword(login);
    }
}
