package bl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import bl.implementation.Room;
import bl.mock.MockRoom;

/**
 * 
 * @author 张新悦
 * @version 2016-11-13 12:45
 *
 */
public class RoomTest {

	private Room room;
	private MockRoom room1;
	private MockRoom room2;
	@Before
	public void setUp(){
		room = new Room();
		room1 = new MockRoom(0, "314", 500);
		room2 = new MockRoom(1, "314", 300);
	}
	
	@Test
	public void testAddRoom(){
		room.addRoom(room1);
		assertEquals(room1.getNumber(), room.findRoom(room1.getNumber()).getNumber());
	}
	
	@Test
	public void testUpdateRoom(){
		room.updateRoom(room2);
		assertEquals(room2.getType(), room.findRoom(room2.getNumber()).getType());
	}
}
