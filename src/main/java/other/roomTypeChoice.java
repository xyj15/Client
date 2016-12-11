package other;

/**
 * Created by 97147 on 2016/12/9.
 */
public class roomTypeChoice {

        private String name;

        public roomTypeChoice(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }

        public RoomType toRoomType(){
            switch (name){
                case "Single":
                    return RoomType.Single;
                case "TwinBed":
                    return RoomType.TwinBed;
                case "BigBed":
                    return RoomType.BigBed;
                case "Suite":
                    return RoomType.Suite;
            }
            return null;
        }
}
