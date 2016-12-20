package rmi;

import data.service.*;
import other.OrderStatus;
import po.OrderPO;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		return (OrderDataService) remote;
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

	public OrderDataAbstractFactory getOrderDataFactory(){
		return (OrderDataAbstractFactory)remote;
	}
	
	public boolean connect() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:3304/RemoteDataService"));
//			remoteHelper.setRemote(Naming.lookup("rmi://172.28.151.24:3304/RemoteDataService"));
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
//		try {
//			System.out.println(InetAddress.getLocalHost().toString());
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		System.out.println(remoteHelper.connect());
//		OrderDataService test = null;
		try {
			OrderDataAbstractFactory factory = remoteHelper.getOrderDataFactory();
			factory.setOrderData("00000000");
			OrderDataService test = remoteHelper.getOrderDataService();
			OrderPO result = null;
			try {
				result = test.getOrder("2016120900000000");
				System.out.println("orderID: "+result.getOrderID());
				System.out.println("memberID: "+result.getMemberID());
				System.out.println("hotelID: "+result.getHotelID());
				System.out.println("orderStatus: "+result.getOrderStatus());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			SimpleDateFormat bartDateFormate = new SimpleDateFormat("MM-dd-yyyy");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
//		if(result.getOrderStatus()== OrderStatus.Canceled){
//			System.out.println("cancel: "+bartDateFormate.format(result.getCancelTime()));
//		}
//		System.out.println("roomName: "+result.getRoomName());
//		System.out.println("numberOfRoom: "+result.getNumberOfRoom());
//		System.out.println("numberOfClient: "+result.getNumberOfClient());
//		System.out.println("hasKid: "+result.getHaveKids());
//		System.out.println("checkInTime: "+bartDateFormate.format(result.getCheckinTime()));
//		System.out.println("checkOutTime: "+bartDateFormate.format(result.getCheckoutTime()));
//		System.out.println("latesCheckInTime: "+bartDateFormate.format(result.getLatestCheckinTime()));
//		System.out.println("promotionID: "+result.getPromotionID());
//		System.out.println("price: "+result.getPrice());
//		if(result.getOrderStatus()== OrderStatus.Executed){
//			System.out.println("actualCheckInTime: "+bartDateFormate.format(result.getActualCheckinTime()));
//			System.out.println("actualCheckOutTime: "+bartDateFormate.format(result.getActualCheckoutTime()));
//			System.out.println("score: "+result.getScore());
//			System.out.println("evaluation: "+result.getEvaluation());
//			System.out.println("recover: "+result.getRecover());
//		}
//		System.out.println("createTime: "+bartDateFormate.format(result.getCreateTime()));
		boolean b = remoteHelper.isConnected();
		if(b) {
			System.out.println("连接到服务器成功");
		} else {
			System.out.println("连接到服务器失败");
		}
//		try {
//			System.out.println(remoteHelper.getHotelDataService().getAvailableHotelID());
//			System.out.println(remoteHelper.getMemberDataService().getAvailableMemberID());
//			System.out.println(remoteHelper.getCreditDataService().getCredit("00000000"));
//			System.out.println(remoteHelper.getManagerDataService().getManager().getName());
//			System.out.println(remoteHelper.getPromotionDataService().getAvailablePromotionID());
//			System.out.println(remoteHelper.getRankDataService().getCreditList().get(2));
//			System.out.println(remoteHelper.getRoomDataService().getRoomsByDate(new Date(), "000000").get(0).getRoomName());
//			System.out.println(remoteHelper.getSalerDataService().getAvailableSalerID());
//			System.out.println(remoteHelper.getSearchDataService().getHotelListByCityDistrict("南京市", "新街口").get(0).getName());
//			System.out.println(remoteHelper.getRoomDataService().getRoomsByDate(new Date(),"000000").get(0).getRoomName());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}
}