package bl.dataservice;

import po.OrderPO;
import po.PromotionPO;
import po.SalerPO;

import java.util.ArrayList;

/**
 * Created by apple on 2016/11/22.
 * Saler模块bl层和data层之间的接口
 * @author CROFF
 * @version 2016-12-1
 */
public interface SalerDataService {
	
	public boolean addSaler(SalerPO salerPO);
	public boolean deleteSaler(SalerPO salerPO);
	public boolean updateSaler(String salerID, SalerPO salerPO);
	public SalerPO getSalerInformation(String salerID);
	
	public boolean creditRecharge(String memberID, double credit);	//信用充值，参数为充值的账户名和充值增加的信用
}
