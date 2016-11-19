package setup;

/**
 * Created by 97147 on 2016/11/19.
 */
public class SearchInfomation {
    private String address;                     // 地址
    private String district;                    // 商圈
    private String hotelName;                   // 酒店名称
    private int level;                          // 星级
    private double score;                       // 评分
    private RoomType roomType;                  // 房间类型
    private double lowestPrice;                 // 价格区间下限
    private double upperPrice;                  // 价格区间上限
    private Date checkinTime;                   // 入住日期
    private Date checkoutTime;                  // 退房日期
    private boolean onlyReservationBefore;      // 是否只搜索自己预定过的酒店

}
