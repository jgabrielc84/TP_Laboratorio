package edu.utn.manager;

import edu.utn.entity.Login;
import edu.utn.factory.FactoryMapper;
import edu.utn.mapper.LoginMapper;

public class LoginManager {

    private LoginMapper loginMapper;

    public LoginManager() {
        this.loginMapper = FactoryMapper.getLoginMapper();
    }

    public LoginMapper getLoginMapper() {
        return loginMapper;
    }

    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    public Login checkUserPassword(Login login) {
        return loginMapper.checkUserPassword(login);
    }
}
