package ca.mcgill.ecse321.tutoring_service.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.mcgill.ecse321.tutoring_service.dao.RoomRepository;
import ca.mcgill.ecse321.tutoring_service.model.Room;

@RunWith(MockitoJUnitRunner.class)
public class RoomMockTest {
	@Mock
	private RoomRepository roomDao;

	@InjectMocks
	private RoomService service;

	@Test
	/**
	 * Test create room
	 */
	public void testCreateRoom() {
		assertEquals(0, service.getAllRooms().size());

		int nr = 9999;
		Room reg = null;
		try {
			reg = service.createRoom(nr);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(nr, reg.getRoomNr());
	}

	@Test
	public void testCreateRoomNegative() {
		int nr = -1;
		String error = null;

		try {
			service.createRoom(nr);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("nr cannot be negative!", error);
	}
}
