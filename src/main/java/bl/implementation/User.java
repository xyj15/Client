package bl.implementation;



public class User {
	protected String ID;
	protected String passWord;
	protected String name;

	
	public boolean check(String id,String pass){
		if(id.equals(ID)&&pass.equals(passWord)){
			return true;
		}
		return false;
	}


	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getID() {
		return ID;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPassWord() {
		return passWord;
	}
}
