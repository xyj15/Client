package bl.dataservice;

import java.util.ArrayList;

import po.MemberPO;

public interface MemberData {

	public MemberPO getMInformation(String memberID);
	public boolean saveMInformation(String memberID, MemberPO M);
	public ArrayList<String> getCreditList(String memberID);
	
}
