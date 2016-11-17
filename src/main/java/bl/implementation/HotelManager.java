package bl.implementation;

public class HotelManager extends User  {
	Hotel hotel;
	
	public HotelManager(){}
	public HotelManager(String Id,String password,String name){
		setID(Id);
		setPassWord(password);
		setName(name);
	}
	
}
