package rmi;

import data.service.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by CROFF on 2016/12/10.
 */
public class RemoteHelper {
	
	private Remote remote;
	private boolean connected = false;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper() {
		
	}
	
	public CreditDataService getCreditDataService() {
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
			remote = Naming.lookup("rmi://localhost:8888/DataRemoteObject");
			connected = true;
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
			connected = false;
			return false;
		} catch (NotBoundException e) {
			e.printStackTrace();
			connected = false;
			return false;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			connected = false;
			return false;
		}
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public static void main(String[] args) {
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		System.out.println(remoteHelper.connect());
	}
}