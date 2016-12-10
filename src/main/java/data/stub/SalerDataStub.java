package data.stub;

import data.service.SalerDataService;
import po.SalerPO;

import java.util.ArrayList;

/**
 * Created by CROFF on 2016/12/2.
 */
public class SalerDataStub implements SalerDataService {
	
	private ArrayList<SalerPO> salerList;
	
	public SalerDataStub() {
		salerList = new ArrayList<SalerPO>();
		SalerPO salerPO1 = new SalerPO("0000", "12345678910", "传销人员01", "tel01");
		salerList.add(salerPO1);
		SalerPO salerPO2 = new SalerPO("0001", "12345678910", "传销人员02", "tel02");
		salerList.add(salerPO2);
		SalerPO salerPO3 = new SalerPO("0002", "12345678910", "传销人员03", "tel03");
		salerList.add(salerPO3);
		SalerPO salerPO4 = new SalerPO("0003", "12345678910", "传销人员04", "tel04");
		salerList.add(salerPO4);
	}
	
	@Override
	public boolean addSaler(SalerPO saler) {
		System.out.println("添加营销人员成功");
		for(int i=0; i<salerList.size(); i++) {
			String salerID = salerList.get(i).getUserID();
			if(saler.getAccount().equals(salerID)) {
				return false;
			}
		}
		salerList.add(saler);
		return true;
	}
	
	@Override
	public boolean deleteSaler(String salerID) {
		System.out.println("删除营销人员成功");
		for(int i=0; i<salerList.size(); i++) {
			if(salerList.get(i).getAccount().equals(salerID)) {
				salerList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean updateSaler(SalerPO saler) {
		System.out.println("更新营销人员信息成功");
		String salerID = saler.getUserID();
		for(int i=0; i<salerList.size(); i++) {
			if(salerList.get(i).getAccount().equals(salerID)) {
				salerList.set(i, saler);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public SalerPO getSaler(String salerID) {
		System.out.println("获取营销人员信息成功");
		for(int i=0; i<salerList.size(); i++) {
			SalerPO salerPO = salerList.get(i);
			if(salerPO.getAccount().equals(salerID)) {
				return salerPO;
			}
		}
		return null;
	}
	
	@Override
	public String getAvailableSalerID() {
		System.out.println("获取可用ID成功");
		int size = salerList.size();
		String availableID = String.valueOf(size);
		switch (availableID.length()) {
			case 1:
				availableID = "0" + availableID;
			case 2:
				availableID = "0" + availableID;
			case 3:
				availableID = "0" + availableID;
			case 4:
				break;
		}
		return availableID;
	}
}
