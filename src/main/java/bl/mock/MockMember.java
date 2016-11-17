/**
 * 
 */
package bl.mock;

import vo.MemberVO;

/**
 * 提供member的基本信息（包括姓名或名称，联系方式、信用）和修改服务
 * @author 张新悦
 * @version 2016-11-04 11:43
 * @param account 
 *   账户
 * @param password
 *   密码
 * @param birthday
 *   生日    
 * @param name
 *   客户名称
 * @param phone
 *   联系方式
 * @param credit
 *   信用值    
 *
 */
public class MockMember extends MemberVO {
	
	private String account;
	private String password;
	private String name;
	private String birthday;
	private String phone;
	private double credit;
	
	/**
	 *  构造MockRoom的方法，确定客户账号、名称、密码等基本信息
	 *  @param acc 
	 *  账户
	 *  @param pass
	 *   密码
	 *  @param birth
	 *   生日    
	 *  @param na
	 *   客户名称
	 *  @param tel
	 *   联系方式
	 *  @param cre
	 *   信用值      
	 */
	public MockMember(String acc,String pass,String birth,String na,String tel,double cre) {
		account=acc;
		password=pass;
		name=na;
		birthday=birth;
		phone=tel;
		credit=cre;
	}
	
	/**
	 * 修改客户密码
	 * @author 张新悦
	 * @version 2016-11-04 12:55
	 * @param newPassword 
	 *   修改的新密码
	 * @param pass
	 *   旧密码
	 * @return 代表的操作成功与否的代表    
	 */
	public boolean setPassword(String newPassword,String pass){
		if(!password.equals(pass)) return false;
		password=newPassword;
		return true;
	}
	
	/**
	 * 修改客户生日
	 * @author 张新悦
	 * @version 2016-11-04 13:01
	 * @param newBirth 
	 *   修改新生日   
	 */
	public void setBirthday(String newBirth){
		birthday=newBirth;
	}
	
	/**
	 * 修改客户名称
	 * @author 张新悦
	 * @version 2016-11-04 12:55
	 * @param newName
	 *   修改的名称
	 * @return    
	 */
	public void setName(String newName) {
		name=newName;
	}
	
	/**
	 * 修改客户联系方式
	 * @author 张新悦
	 * @version 2016-11-04 14:43
	 * @param newTel
	 *   修改的联系方式
	 * @return    
	 */
	public void setPhone(String newTel){
		phone=newTel;
	}
	
	/**
	 * 修改客户信用值
	 * @author 张新悦
	 * @version 2016-11-04 14:43
	 * @param change
	 *   信用值的增改值
	 * @return    
	 */
	public void setCredit(double change){
		credit+=change;
	}
	
	/**
	 * 查看客户账号
	 * @author 张新悦
	 * @version 2016-11-04 14:45
	 * @return 以String为表示的客户账号  
	 */
	public String getMemberID(){
		return account;
	}
	
	/**
	 * 查看客户名称
	 * @author 张新悦
	 * @version 2016-11-04 14:45
	 * @return 以String为表示的客户名称  
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 查看客户生日
	 * @author 张新悦
	 * @version 2016-11-04 14:45
	 * @return 以String为表示的客户生日  
	 */
	public String getBirthday(){
		return birthday;
	}
	
	/**
	 * 查看客户联系方式
	 * @author 张新悦
	 * @version 2016-11-04 14:45
	 * @return 以String为表示的客户联系方式  
	 */
	public String getTel(){
		return phone;
	}
	
	/**
	 * 查看客户信用值
	 * @author 张新悦
	 * @version 2016-11-04 14:45
	 * @return 以Double为表示的客户信用值  
	 */
	public double getCredit(){
		return credit;
	}
	
	/**
	 * 登录
	 * @author 张新悦
	 * @version 2016-11-04 14:45
	 * @return 表示密码正确与否的布尔值  
	 */
	public boolean check(String pass){
		if(password.equals(pass)) return true;
		return false;
	}
	
}
