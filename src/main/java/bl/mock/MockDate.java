package bl.mock;

import vo.DateVO;

/**
 * Date的Mock类
 * @author CROFF
 * @version 2016-11-05 16:40
 */
public class MockDate extends DateVO {

	private int year, month, day;

	/**
	 * MockDate的构造方法
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 */
	public MockDate(int year, int month, int day) {
		super(year, month, day);
	}
	
	/**
	 * 获取年
	 * @return 年
	 */
	public int getYear() {
		return year;
	}

	/**
	 * 获取月
	 * @return 月
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * 获取日
	 * @return 日
	 */
	public int getDay() {
		return day;
	}
}
