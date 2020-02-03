package ca.mcgill.ecse321.tutoring_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoring_service.dao.CourseRepository;
import ca.mcgill.ecse321.tutoring_service.dao.RegistrationRepository;
import ca.mcgill.ecse321.tutoring_service.dao.RoomRepository;
import ca.mcgill.ecse321.tutoring_service.dao.SessionRepository;
import ca.mcgill.ecse321.tutoring_service.dao.TutorRepository;
import ca.mcgill.ecse321.tutoring_service.model.Course;
import ca.mcgill.ecse321.tutoring_service.model.Registration;
import ca.mcgill.ecse321.tutoring_service.model.Room;
import ca.mcgill.ecse321.tutoring_service.model.Session;
import ca.mcgill.ecse321.tutoring_service.model.Tutor;

@Service
public class SessionService {

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private RegistrationRepository registrationRepo;

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private RoomRepository roomRepo;

	@Autowired
	private TutorRepository tutorRepo;

	/**
	 * This is used to create session by giving start time, finish time, tutor name,
	 * course name, room
	 * 
	 * @param startTime
	 * @param finishTime
	 * @param tutorName
	 * @param courseName
	 * @param room
	 * @return
	 */
	@Transactional
	public Session createSession(String startTime, String finishTime, String tutorName, String courseName, Room room) {
		Tutor tutor = tutorRepo.findTutorByName(tutorName);
		boolean isCancel = false;

		// create a new session with attributes
		Session session = new Session();
		session.setStartTime(startTime);
		session.setFinishTime(finishTime);
		session.setIsCancelled(isCancel);
		session.setRoom(room);
		session.setTutor(tutor);
		// persistence saving
		sessionRepository.save(session);
		return session;
	}

	/**
	 * This is used to create session by giving start time, finish time, tutor name,
	 * course name
	 * 
	 * @param registrationId
	 * @param tutorId
	 * @param courseId
	 * @param roomId
	 * @return
	 */
	@Transactional
	public Session createSession(int registrationId, int tutorId, int courseId, int roomId) {
		Registration registration = registrationRepo.findRegistrationById(registrationId);
		Course course = courseRepo.findById(courseId);
		Room room = roomRepo.findById(roomId);
		Tutor tutor = tutorRepo.findById(tutorId);
		Session session = new Session();
		session.setRoom(room);
		session.setRegistration(registration);
		session.setTutor(tutor);
		// persistence saving
		sessionRepository.save(session);
		return session;
	}

	@Transactional
	public Session createSession(String startTime, String finishTime) {
		Session session = new Session();
		session.setStartTime(startTime);
		session.setFinishTime(finishTime);
		sessionRepository.save(session);
		return session;
	}

}
