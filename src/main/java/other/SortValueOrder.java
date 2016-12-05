package other;

/**
 * Created by CROFF on 2016/12/4.
 * 存储排序的类型和顺序
 * priceHtoL(0)：价格从高到低
 * priceLtoH(1)：价格从低到高
 * scoreHtoL(2)：评分从高到低
 * coreLtoH(3)：评分从低到高
 * levelHtoL(4)：星级从高到低
 * levelLtoH(5)：星级从低到高
 * @author CROFF
 * @version 2016-12-4
 */
public enum SortValueOrder {
	
	priceHtoL(0), priceLtoH(1), scoreHtoL(2), scoreLtoH(3), levelHtoL(4), levelLtoH(5);
	
	int value;
	
	private SortValueOrder(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
