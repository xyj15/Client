package rmi;

import data.service.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class RemoteHelper {
	
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	private boolean connected = false;
	
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper() {
		
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public CreditDataService getCreditDataService(){
		return (CreditDataService)remote;
	}
	
	public HotelDataService getHotelDataService() {
		return (HotelDataService)remote;
	}
	
	public ManagerDataService getManagerDataService() {
		return (ManagerDataService)remote;
	}
	
	public MemberDataService getMemberDataService() {
		return (MemberDataService)remote;
	}
	
	public OrderDataService getOrderDataService() {
		return (OrderDataService)remote;
	}
	
	public PromotionDataService getPromotionDataService() {
		return (PromotionDataService)remote;
	}
	
	public RankDataService getRankDataService() {
		return (RankDataService)remote;
	}
	
	public RoomDataService getRoomDataService() {
		return (RoomDataService)remote;
	}
	
	public SalerDataService getSalerDataService() {
		return (SalerDataService)remote;
	}
	
	public SearchDataService getSearchDataService() {
		return (SearchDataService)remote;
	}
	
	public boolean connect() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:3304/RemoteDataService"));
			connected = true;
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		} catch (NotBoundException e) {
			e.printStackTrace();
			return false;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	
	public static void main(String[] args) {
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		boolean b = remoteHelper.connect();
		if(b) {
			System.out.println("连接到服务器成功");
		} else {
			System.out.println("连接到服务器失败");
		}
	}
}