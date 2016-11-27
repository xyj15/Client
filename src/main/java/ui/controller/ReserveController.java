package ui.controller;

import bl.implementation.Reserve;
import bl.service.ReserveBLService;
import other.Date;
import other.RoomType;
import ui.controllerservice.ReserveControllerService;
import ui.presentation.ReserveUI;
import vo.PromotionVO;

/**
 * Created by CROFF on 2016/11/26.
 * @author CROFF
 * @version 2016-11-26
 */
public class ReserveController implements ReserveControllerService {
	
	private ReserveUI reserveUI;
    private ReserveBLService reserveBL;
    
    public ReserveController(ReserveUI reserveUI) {
        this.reserveUI = reserveUI;
        reserveBL = new Reserve(null);
    }
    
    @Override
    public void setPromotion(PromotionVO promotion) {
        
    }
    
    @Override
    public double getPrice() {
        return 0;
    }
    
    @Override
    public String getHotelName() {
        return reserveBL.getHotelName();
    }

    @Override
    public String getHotelAddress() {
        return reserveBL.getHotelAddress();
    }

    @Override
    public String getHotelLevel() {
        return reserveBL.getHotelLevel();
    }

    @Override
    public String getHotelTel() {
        return reserveBL.getHotelTel();
    }

    @Override
    public RoomType getRoomType() {
        return reserveBL.getRoomType();
    }

    @Override
    public void setCheckinTime(Date checkinTime) {
		reserveBL.setCheckinTime(checkinTime);
    }

    @Override
    public void setChekckoutTime(Date chekckoutTime) {
		reserveBL.setChekckoutTime(chekckoutTime);
    }

    @Override
    public void setClientName(String clientName) {
		reserveBL.setClientName(clientName);
    }

    @Override
    public void setClientTel(String clientTel) {
		reserveBL.setClientTel(clientTel);
    }

    @Override
    public void setOtherReq(String otherReq) {
		reserveBL.setOtherReq(otherReq);
    }

    @Override
    public void createOrder() {
		reserveBL.createOrder();
    }
    
    public ReserveBLService getReserveBL() {
        return reserveBL;
    }
    
    public void setReserveBL(ReserveBLService reserveBL) {
        this.reserveBL = reserveBL;
    }
	
	public ReserveUI getReserveUI() {
		return reserveUI;
	}
	
	public void setReserveUI(ReserveUI reserveUI) {
		this.reserveUI = reserveUI;
	}
}
