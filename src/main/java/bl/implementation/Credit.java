package bl.implementation;

import data.service.CreditDataService;
import bl.service.CreditBLService;
import other.OrderAction;
import po.CreditChangePO;
import vo.CreditChangeVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 97147 on 2016/11/18.
 * Credit模块的bl实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Credit implements CreditBLService {

	private String memberID;	//客户ID
	private double credit;	//客户信用值
    private ArrayList<CreditChangeVO> creditChangeList;	//信用变化情况
	
	private CreditDataService creditDataService;
	
	/**
	 * 空构造方法
	 */
	public Credit() {
		
	}
	
	/**
	 * 带memberID的构造方法
	 * @param memberID
	 */
    public Credit(String memberID) {
		this.memberID = memberID;
		updateCreditChangeListFromFile();
		updateCreditFromFile();
    }
	
	/**
	 * 获取信用变化列表
	 * @return 信用变化列表
	 */
	@Override
	public ArrayList<CreditChangeVO> getCreditChangeList() {
		updateCreditChangeListFromFile();
		return creditChangeList;
	}
	
	/**
	 * 获取信用值
	 * @return 信用值
	 */
	@Override
	public double getCredit() {
		updateCreditFromFile();
		return credit;
	}
	
	/**
	 * 检查信用值是否大于等于0
	 * @return 是的话返回true，否则返回false
	 */
    public boolean checkCredit() {
        if(credit>=0) {
            return true;
        } else {
			return false;
		}
    }
	
	/**
	 * 添加新的信用变化情况
	 * @param creditChangeVO 信用变化情况
	 */
	public void addCreditChange(CreditChangeVO creditChangeVO) {
		creditChangeList.add(creditChangeVO);
	
		Date date = creditChangeVO.getDate();
		String orderID = creditChangeVO.getOrderID();
		OrderAction orderAction = creditChangeVO.getOrderAction();
		double change = creditChangeVO.getChange();
		double result = creditChangeVO.getResult();
		CreditChangePO creditChangePO = new CreditChangePO(date, orderID, orderAction,
				change, result);
		creditDataService.addCreditChange(memberID, creditChangePO);
	}
	
	/**
	 * 从data层更新信用变化列表
	 */
	public void updateCreditChangeListFromFile() {
		ArrayList<CreditChangePO> creditChangePOList = creditDataService.getCreditChange(memberID);
		creditChangeList = new ArrayList<CreditChangeVO>();
		for(int i=0; i<creditChangePOList.size(); i++) {
			CreditChangePO creditChangePO = creditChangePOList.get(i);
			Date date = creditChangePO.getDate();
			String orderID = creditChangePO.getOrderID();
			OrderAction orderAction = creditChangePO.getOrderAction();
			double change = creditChangePO.getChange();
			double result = creditChangePO.getResult();
			CreditChangeVO creditChangeVO = new CreditChangeVO(date, orderID,
					orderAction, change, result);
			creditChangeList.add(creditChangeVO);
		}
	}
	
	/**
	 * 从data层更新信用值
	 */
	public void updateCreditFromFile() {
		credit = creditDataService.getCredit(memberID);
	}
}
