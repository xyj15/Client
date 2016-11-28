package ui.controllerservice;

import other.UserType;

/**
 * Created by 婧婧 on 2016/11/27.
 */
public interface LoginControllerService {
    
    public String getID();
    public String getPassword();
    public String getName();
    public UserType getUserRole();
}
