package rmi;

import data.service.*;
import javafx.stage.Stage;
import other.MemberType;
import other.OrderStatus;
import po.CreditChangePO;
import po.MemberPO;
import po.OrderPO;
import po.RoomPO;
import ui.presentation.LoginUI;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;

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
	
	public static void main(String[] args) throws Exception {
//		try {
//			System.checkout.println(InetAddress.getLocalHost().toString());
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
		
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		System.out.println(remoteHelper.connect());
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
//			System.out.println(remoteHelper.getRoomDataService().getRoomsByDate(new Date(), "000000"));
//			System.out.println(remoteHelper.getSalerDataService().getAvailableSalerID());
//			System.out.println(remoteHelper.getSearchDataService().getHotelListByCityDistrict("南京市", "新街口"));
//
//			ArrayList<CreditChangePO> creditChangePOList = remoteHelper.getCreditDataService().getCreditChange("00000000");
//			System.out.println(creditChangePOList.get(0).getOrderID());
//			System.out.println(remoteHelper.getPromotionDataService().getPromotionList().get(0).getPromotionName());
//			System.err.println(remoteHelper.getPromotionDataService().getPromotionList().size());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//			ArrayList<RoomPO> roomList = remoteHelper.getRoomDataService().getRoomsByDate(new Date(), "000000");
//			for (RoomPO room: roomList
//			     ) {
//				System.out.println(room.getRoomName());
//			}
//			System.out.println(remoteHelper.getPromotionDataService().getPromotionList());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
			
//		OrderDataAbstractFactory factory = remoteHelper.getOrderDataFactory();
//		try {
//			factory.setOrderData("00000000");
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		OrderDataService test = remoteHelper.getOrderDataService();
//		OrderPO result = null;
//		try {
//			result = test.getOrder("2016120900000000");
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		System.checkout.println("orderID: "+result.getOrderID());
//		System.checkout.println("mamberID: "+result.getMemberID());
//		System.checkout.println("hotelID: "+result.getHotelID());
//		System.checkout.println("orderStatus: "+result.getOrderStatus());
		
//		if(result.getOrderStatus()== OrderStatus.Canceled){
//			System.checkout.println("cancel: "+bartDateFormate.format(result.getCancelTime()));
//		}
//		System.checkout.println("roomName: "+result.getRoomName());
//		System.checkout.println("numberOfRoom: "+result.getNumberOfRoom());
//		System.checkout.println("numberOfClient: "+result.getNumberOfClient());
//		System.checkout.println("hasKid: "+result.getHaveKids());
//		System.checkout.println("checkInTime: "+bartDateFormate.format(result.getCheckinTime()));
//		System.checkout.println("checkOutTime: "+bartDateFormate.format(result.getCheckoutTime()));
//		System.checkout.println("latesCheckInTime: "+bartDateFormate.format(result.getLatestCheckinTime()));
//		System.checkout.println("promotionID: "+result.getPromotionID());
//		System.checkout.println("price: "+result.getPrice());
//		if(result.getOrderStatus()== OrderStatus.Executed){
//			System.checkout.println("actualCheckInTime: "+bartDateFormate.format(result.getActualCheckinTime()));
//			System.checkout.println("actualCheckOutTime: "+bartDateFormate.format(result.getActualCheckoutTime()));
//			System.checkout.println("score: "+result.getScore());
//			System.checkout.println("evaluation: "+result.getEvaluation());
//			System.checkout.println("recover: "+result.getRecover());
//		}
//		System.checkout.println("createTime: "+bartDateFormate.format(result.getCreateTime()));
	}
}