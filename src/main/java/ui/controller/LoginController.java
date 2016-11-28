package ui.controller;

import other.UserType;
import ui.controllerservice.LoginControllerService;
import bl.implementation.Login;
import bl.service.LoginBLService;
import ui.presentation.LoginUI;

/**
 * Created by 婧婧 on 2016/11/27.
 */
public class LoginController implements LoginControllerService{
    private LoginUI loginUI;
    private LoginBLService loginBL = new Login();

    public LoginController(LoginUI loginUI){
        this.loginUI=loginUI;
    }
    @Override
    public String getID() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public UserType getUserRole() {
        return null;
    }
}

