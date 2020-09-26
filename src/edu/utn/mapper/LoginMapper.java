package edu.utn.mapper;

import edu.utn.dao.LoginDao;
import edu.utn.entity.Login;

public class LoginMapper {

    LoginDao loginDao;

    public LoginMapper(LoginDao loginDao) {
        this.loginDao = loginDao;
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
