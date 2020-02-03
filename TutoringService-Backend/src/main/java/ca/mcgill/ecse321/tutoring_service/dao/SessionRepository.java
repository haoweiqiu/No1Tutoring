package ca.mcgill.ecse321.tutoring_service.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoring_service.model.Session;

//@YuhangZhang

public interface SessionRepository extends CrudRepository<Session, Long> {
	Session findById(int sessionId);

	Session findByStartTimeAndFinishTimeAndTutorId(String startTime, String finishTime, int tutorId);
	// void deleteBySessionId(int sessionId);
}
