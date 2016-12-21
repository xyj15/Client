package bl.implementation;

import data.service.RoomDataService;
import bl.service.RoomBLService;
import data.stub.RoomDataStub;
import other.RoomType;
import po.RoomPO;
import rmi.RemoteHelper;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Room模块bl的实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Room implements RoomBLService {
	
	private String hotelID;
	
	private RoomDataService roomDataService;
	
	/**
	 * 构造方法
	 * @param hotelID 酒店ID
	 */
	public Room(String hotelID) {
		this.hotelID = hotelID;
		RemoteHelper.getInstance().connect();
		roomDataService = RemoteHelper.getInstance().getRoomDataService();
//		roomDataService = new RoomDataStub();
	}
	
	/**
	 * 根据日期和房间名称获取可用房间列表
	 * @param date 日期
	 * @param roomName 房间名称
	 * @return 可用房间列表
	 */
	@Override
	public ArrayList<RoomVO> getAvailableRoomByName(Date date, String roomName) {
		ArrayList<RoomPO> roomPOArrayList = null;
		try {
			roomPOArrayList = roomDataService.getRoomsByNameDate(date, roomName, hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<RoomVO> roomVOArrayList = new ArrayList<>();
		for(int i=0; i<roomPOArrayList.size(); i++) {
			roomVOArrayList.add(roomPOtoVO(roomPOArrayList.get(i)));
		}
		return roomVOArrayList;
	}
	
	/**
	 * 根据客房号码获取某天的房间信息
	 * @param date 日期
	 * @param roomNumber 客房号码
	 * @return 房间信息
	 */
	@Override
	public RoomVO getRoomInformation(Date date, String roomNumber){
		RoomPO roomPO = null;
		try {
			roomPO = roomDataService.getSingleRoom(date, roomNumber, hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		RoomVO roomVO = roomPOtoVO(roomPO);
		return roomVO;
	}
	
	/**
	 * 添加新客房
	 * @param roomVO 新客房信息
	 * @return 添加成功则返回true，否则返回false
	 */
	@Override
	public boolean addRoom(RoomVO roomVO) {
		RoomPO roomPO = roomVOtoPO(roomVO);
		try {
			return roomDataService.addSingleRoom(roomPO, hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 删除客房
	 * @param roomNumber 客房号码
	 * @return 删除成功则返回true，否则返回false
	 */
	@Override
	public boolean deleteRoom(String roomNumber) {
		try {
			return roomDataService.deleteSingleRoom(roomNumber, hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 更新某天的客房信息
	 * @param date 日期
	 * @param roomVO 客房信息
	 * @return 更新成功则返回true，否则返回false
	 */
	@Override
	public boolean updateRoom(Date date, RoomVO roomVO) {
		RoomPO roomPO = roomVOtoPO(roomVO);
		try {
			return roomDataService.updateSingleRoom(date, roomPO, hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * room从PO到VO的转换
	 * @param roomPO PO
	 * @return VO
	 */
	public RoomVO roomPOtoVO(RoomPO roomPO) {
		boolean reserved = roomPO.isReserved();
		boolean available = roomPO.isAvailable();
		String roomNumber = roomPO.getRoomNumber();
		String roomName = roomPO.getRoomName();
		RoomType roomType = roomPO.getRoomType();
		double price = roomPO.getPrice();
		String hotelID = roomPO.getHotelID();
		RoomVO roomVO = new RoomVO(reserved, available, roomNumber, roomName, roomType, price, hotelID);
		return roomVO;
	}
	
	/**
	 * room从VO到PO的转换
	 * @param roomVO VO
	 * @return PO
	 */
	public RoomPO roomVOtoPO(RoomVO roomVO) {
		boolean reserved = roomVO.isReserved();
		boolean available = roomVO.isAvailable();
		String roomNumber = roomVO.getRoomNumber();
		String roomName = roomVO.getRoomName();
		RoomType roomType = roomVO.getRoomType();
		double price = roomVO.getPrice();
		String hotelID = roomVO.getHotelID();
		RoomPO roomPO = new RoomPO(reserved, available, roomNumber, roomName, roomType, price, hotelID);
		return roomPO;
	}
	
	/**
	 * 获得酒店某天的所有客房信息
	 * @param date 日期
	 * @return 客房信息列表
	 */
	@Override
	public ArrayList<RoomVO> getDailyRoomList(Date date) {
		ArrayList<RoomPO> roomPOList = null;
		try {
			roomPOList = roomDataService.getRoomsByDate(date, hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<RoomVO> roomVOList = new ArrayList<>();
		for(int i=0; i<roomPOList.size(); i++) {
			roomVOList.add(roomPOtoVO(roomPOList.get(i)));
		}
		return roomVOList;
	}
	
	/**
	 * 办理入住手续
	 * @param date 入住日期
	 * @param roomID 客房号
	 * @return 办理成功则返回true，否则返回false
	 */
	public boolean checkin(Date date, String roomID) {
		try {
			return roomDataService.checkIn(date, roomID, hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 办理离店手续
	 * @param date 离店日期
	 * @param roomID 客房号
	 * @return 办理成功则返回true，否则返回false
	 */
	public boolean checkout(Date date, String roomID) {
		try {
			return roomDataService.checkOut(date, roomID, hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 预订单间客房
	 * @param date 预期入住日期
	 * @param roomID 客房号
	 * @return 预订成功则返回true，否则返回false
	 */
	public boolean reserveSingleRoom(Date date, String roomID) {
		try {
			return roomDataService.reserveSingleRoom(date, roomID, hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}

