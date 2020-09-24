package edu.utn.manager;

import edu.utn.entity.Login;
import edu.utn.mapper.LoginMapper;

public class LoginManager {

    private LoginMapper loginMapper;

    public LoginManager(LoginMapper loginMapper) {
        this.setLoginMapper(loginMapper);
    }

    public LoginMapper getLoginMapper() {
        return loginMapper;
    }

    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    public Boolean checkUserPassword(Login login) {
        return loginMapper.checkUserPassword(login);
    }
}
