package bl.service;

import vo.MemberVO;

/**
 * login模块的bl提供给ui的接口类
 * @author CROFF
 * @version 2016-11-28
 */
public interface LoginBLService {

	public boolean checkNetwork();	//判断网络情况
	public boolean existUsername(String username);	//登录时和注册时判断用户名是否存在
	public boolean validPassword(String password);	//注册时判断密码是否可以使用
	public boolean login(String username, String password);	//登陆
	public boolean register(MemberVO memberVO);	//注册
}
