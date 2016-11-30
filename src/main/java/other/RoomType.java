package other;

/**
 * @author CROFF
 * @version 2016-11-30
 * 客房类型枚举类
 * Single：单人房
 * TwinBed：双床房
 * BigBed：大床房
 * Suite：套房
 */
public enum RoomType {

	Single(1), TwinBed(2), BigBed(3), Suite(4);
	
	int value;
	private RoomType(int value) {
		this.value = value;
	}
}
