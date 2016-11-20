package bl.implementation;



public class User {
	protected String ID;
	protected String passWord;

	
	public boolean check(String id,String pass){
		if(id.equals(ID)&&pass.equals(passWord)){
			return true;
		}
		return false;
	}
}
