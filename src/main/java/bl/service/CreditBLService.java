package bl.service;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/18.
 */
public interface CreditBLService {

    public Double getCredit();
    public boolean updateCredit(double newCredit);
    public boolean checkCredit();
}
