package ui.presentation;

import other.Date;
import other.RoomType;
import ui.controller.ReserveController;
import ui.controllerservice.ReserveControllerService;
import vo.PromotionVO;

/**
 * Reserve的UI界面类
 * @author CROFF
 * @version 2016-11-27
 */
public class ReserveUI {
	
	private ReserveControllerService reserveController;
	
	public ReserveUI() {
		reserveController = new ReserveController(this);
	}
	
	public double getPrice() {
		return reserveController.getPrice();
	}
	
	public void setHotelName() {
		
	}
	
	public void setHotelAddress() {
		
	}
	
	public void setHotelLevel() {
		
	}
	
	public void setHotelTel() {
		
	}
	
	public void setRoomType() {
		
	}
	
	public Date getCheckinTime() {
		return null;
	}
	
	public Date getChekckoutTime() {
		return null;
	}
	
	public String getClientName() {
		return null;
	}
	
	public String getClientTel() {
		return null;
	}
	
	public String getOtherReq() {
		return null;
	}
	
	public void createOrder() {
		
	}
	
}
