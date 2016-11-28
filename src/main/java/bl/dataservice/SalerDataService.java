package bl.dataservice;

import po.SalerPO;

/**
 * Created by apple on 2016/11/22.
 */
public interface SalerDataService {
    public SalerPO getSaler(String account);
    public boolean updateSaler(SalerPO saler);
    public boolean addSaler(SalerPO saler);
    public boolean deleteSaler(String account);
}
