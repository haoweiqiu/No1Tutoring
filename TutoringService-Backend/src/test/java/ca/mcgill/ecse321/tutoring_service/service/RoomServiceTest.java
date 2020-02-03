package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoring_service.model.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceTest {

	@Autowired
	private RoomService roomService;

	@Test
	/**
	 * Test create room
	 */
	public void testCreateRoom() {
//		assertEquals(0, roomService.getAllRooms().size());

		int roomId = 11;

		int roomSize = roomService.getAllRooms().size();

		try {
			roomService.createRoom(roomId);
		} catch (IllegalArgumentException e) {
			fail();
		}

		List<Room> allRooms = roomService.getAllRooms();

		assertEquals(roomSize + 1, allRooms.size());

	}
}
