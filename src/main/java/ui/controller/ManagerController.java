package ui.controller;

import vo.HotelVO;
import vo.MemberVO;

/**
 * Created by apple on 2016/11/18.
 */
public interface ManagerController {
    public HotelVO getHotel(String hotelID);
    public boolean addHotel(HotelVO hotel);
    public boolean updateHotel(HotelVO hotel);
    public boolean deleteHotel(HotelVO hotel);
    public MemberVO getMember(String hotelID);
    public boolean addMember(MemberVO member);
    public boolean updateMember(MemberVO member);
    public boolean deleteMember(MemberVO member);
}
