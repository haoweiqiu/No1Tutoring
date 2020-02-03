package ca.mcgill.ecse321.tutoring_service.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoring_service.model.Room;

//@YuhangZhang

public interface RoomRepository extends CrudRepository<Room, Long> {
	Room findRoomByRoomNr(int roomNr);

	Room findById(int roomId);

	void deleteByRoomNr(int roomNr);
}
