package vo;

/**
 * Created by apple on 2016/11/22.
 */
public class SalerVO {
    private String account;
    private String password;

    public SalerVO(String acc,String pass){
        account = acc;
        password = pass;
    }

    public SalerVO(){}

    public boolean check(String pass){
        if(password.equals(pass))return true;
        return false;
    }

    public boolean setPassword(String pass,String newPass){
        if(check(pass)){
            password=newPass;
            return true;
        }
        return false;
    }

    public String getAccount(){
        return account;
    }

    public String getPassword(){
        return password;
    }

}
