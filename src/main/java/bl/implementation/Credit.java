package bl.implementation;

import data.service.CreditDataService;
import bl.service.CreditBLService;
import data.stub.CreditDataStub;
import other.OrderAction;
import po.CreditChangePO;
import rmi.RemoteHelper;
import vo.CreditChangeVO;

import java.rmi.RemoteException;
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
	 * 构造方法
	 * @param memberID
	 */
    public Credit(String memberID) {
		this.memberID = memberID;
//		creditDataService = new CreditDataStub();
		creditDataService = RemoteHelper.getInstance().getCreditDataService();
		updateDataFromFile();
    }
	
	/**
	 * 获取信用变化列表
	 * @return 信用变化列表
	 */
	@Override
	public ArrayList<CreditChangeVO> getCreditChangeList() {
		return creditChangeList;
	}
	
	/**
	 * 获取信用值
	 * @return 信用值
	 */
	@Override
	public double getCredit() {
		return credit;
	}
	
	/**
	 * 检查信用值是否大于等于0
	 * @return 是的话返回true，否则返回false
	 */
	@Override
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
	public boolean addCreditChange(CreditChangeVO creditChangeVO) {
		creditChangeList.add(creditChangeVO);
	
		Date date = creditChangeVO.getDate();
		String orderID = creditChangeVO.getOrderID();
		OrderAction orderAction = creditChangeVO.getOrderAction();
		double change = creditChangeVO.getChange();
		double result = creditChangeVO.getResult();
		this.credit = result;
		
		CreditChangePO creditChangePO = new CreditChangePO(date, orderID, orderAction,
				change, result);
		try {
			return creditDataService.addCreditChange(memberID, creditChangePO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 初始化新用户的信用，初始化为0
	 * @return 成功则返回true，否则返回false
	 */
	public boolean initialCredit() {
		this.credit = 0;
		try {
			return creditDataService.setCredit(memberID, 0);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 从data层更新数据
	 */
	public void updateDataFromFile() {
		ArrayList<CreditChangePO> creditChangePOList = null;
		try {
			creditChangePOList = creditDataService.getCreditChange(memberID);
			creditChangeList = new ArrayList<>();
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
			credit = creditDataService.getCredit(memberID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
