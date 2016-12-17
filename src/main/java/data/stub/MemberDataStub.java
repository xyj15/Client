package data.stub;

import data.service.MemberDataService;
import other.MemberType;
import po.MemberPO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by CROFF on 2016/12/2.
 */
public class MemberDataStub implements MemberDataService {
	
	ArrayList<MemberPO> memberList;
	
	public MemberDataStub() {
		memberList = new ArrayList<>();
		String password = "12345678910";
		String tel = password;
		MemberPO memberPO1 = new MemberPO("00000000", password, "客户1", tel, 1, 1, MemberType.Orinary, new Date(), null);
		memberList.add(memberPO1);
		MemberPO memberPO2 = new MemberPO("00000001", password, "客户2", tel, 2, 0.95, MemberType.Orinary, new Date(), null);
		memberList.add(memberPO2);
		MemberPO memberPO3 = new MemberPO("00000002", password, "客户3", tel, 1, 1, MemberType.Bussiness, null, "企业1");
		memberList.add(memberPO3);
		MemberPO memberPO4 = new MemberPO("00000003", password, "客户4", tel, 3, 0.9, MemberType.Bussiness, null, "企业2");
		memberList.add(memberPO4);
	}
	
	@Override
	public boolean addMember(MemberPO member) {
		System.out.println("添加客户成功");
		return memberList.add(member);
	}
	
	@Override
	public boolean deleteMember(String memberID) {
		System.out.println("删除客户成功");
		for(int i=0; i<memberList.size(); i++) {
			if(memberList.get(i).getUserID().equals(memberID)) {
				memberList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean updateMember(MemberPO member) {
		System.out.println("更新客户信息成功");
		String memberID = member.getMemberID();
		for(int i=0; i<memberList.size(); i++) {
			if(memberList.get(i).getUserID()==null) {
				return false;
			}
			
			if(memberList.get(i).getUserID().equals(memberID)) {
				memberList.set(i, member);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public MemberPO getMember(String memberID) {
		System.out.println("获取客户信息成功");
		for(int i=0; i<memberList.size(); i++) {
			if(memberList.get(i).getUserID()==null) {
				return null;
			}
			
			if(memberList.get(i).getUserID().equals(memberID)) {
				return memberList.get(i);
			}
		}
		return null;
	}
	
	@Override
	public String getAvailableMemberID() {
		System.out.println("获取可用客户ID成功");
		int size = memberList.size();
		String availableID = String.valueOf(size);
		switch (availableID.length()) {
			case 1:
				availableID = "0" + availableID;
			case 2:
				availableID = "0" + availableID;
			case 3:
				availableID = "0" + availableID;
			case 4:
				availableID = "0" + availableID;
			case 5:
				availableID = "0" + availableID;
			case 6:
				availableID = "0" + availableID;
			case 7:
				availableID = "0" + availableID;
			case 8:
				break;
		}
		return availableID;
	}
}
