package bl.dataservice;

import other.UserType;
import po.MemberPO;

/**
 * Created by CROFF on 2016/11/28.
 * login模块需要的数据接口
 * @author CROFF
 * @version 2016-11-28
 */
public interface LoginDataService {
	
	public boolean checkNetwork();	//判断网络情况
	public boolean existUsername(String username);	//登录时和注册时判断用户名是否存在
	public boolean validPassword(String password);	//注册时判断密码是否可以使用
	public UserType login(String username, String password);	//登陆，登陆成功则返回用户类型，失败则返回null
	public boolean register(MemberPO memberPO);	//注册
}
