package bl.service;

import vo.CreditChangeVO;

import java.util.ArrayList;

/**
 * Created by CROFF on 2016/11/30.
 * Credit模块bl层和ui层之间的接口
 * @author CROFF
 * @version 2016-11-30
 */
public interface CreditBLService {
	
	public ArrayList<CreditChangeVO> getCreditChangeList();	//获取信用变化列表
	public double getCredit();	//获取信用
	public boolean checkCredit();	//检查信用是否大于0
}
