package other;

/**
 * Created by CROFF on 2016/11/29.
 * 时间类，包含时分秒
 * @author CROFF
 * @v2016-11-29
 */
public class Time {
	
	private int hour, min, sec;
	
	public Time(int hour, int min, int sec) {
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMin() {
		return min;
	}
	
	public int getSec() {
		return sec;
	}
}
