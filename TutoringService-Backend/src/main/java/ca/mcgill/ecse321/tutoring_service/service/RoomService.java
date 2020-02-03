package ca.mcgill.ecse321.tutoring_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoring_service.dao.RoomRepository;
import ca.mcgill.ecse321.tutoring_service.model.Room;

@Service
public class RoomService {
	// Tutor
	@Autowired
	RoomRepository roomRepository;

	/**
	 * This is used to create room by room by give room number as input.
	 * 
	 * @param nr
	 * @return
	 */
	@Transactional
	public Room createRoom(int nr) {
		if (nr < 0) {
			throw new IllegalArgumentException("nr cannot be negative!");
		}
		Room room = new Room();
		room.setRoomNr(nr);
		roomRepository.save(room);
		return room;
	}

	/**
	 * This method is used get the room by id.
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public Room getRoom(int id) {
		Room room = roomRepository.findRoomByRoomNr(id);
		return room;
	}

	/**
	 * This method is used to delete the room by id.
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteRoom(int id) {
		roomRepository.deleteByRoomNr(id);
	}

	/**
	 * This method is used to get all rooms.
	 * 
	 * @return
	 */
	@Transactional
	public List<Room> getAllRooms() {
		return toList(roomRepository.findAll());
	}

	/**
	 * This method is used to return a list of objects.
	 * 
	 * @param <T>
	 * @param iterable
	 * @return
	 */
	private <T> List<T> toList(Iterable<T> iterable) {
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
}