package vo;

public class MemberVO {

	private String memberID;
	private String password;
	private String name;
	private String birthday;
	private double credit;
	private String phone;
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberVO(String memberID,String pass,String name,String birth,String phone,double credit){
		this.setName(name);
		this.setPassword(pass);
		this.setMemberID(memberID);
		this.setBirthday(birth);
		this.setCredit(credit);
		this.setTel(phone);
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String pass){
		this.password=pass;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birth) {
		this.birthday=birth;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getTel() {
		return phone;
	}

	public void setTel(String phone) {
		this.phone = phone;
	}
}