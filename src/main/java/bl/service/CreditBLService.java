package bl.service;

import vo.CreditChange;

import java.util.ArrayList;

/**
 * Created by CROFF on 2016/11/30.
 * Credit模块bl层和ui层之间的接口
 * @author CROFF
 * @version 2016-11-30
 */
public interface CreditBLService {
	
	public ArrayList<CreditChange> getCreditChangeList();
	public double getCredit();
}
