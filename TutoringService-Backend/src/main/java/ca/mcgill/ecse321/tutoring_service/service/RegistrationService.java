package ca.mcgill.ecse321.tutoring_service.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoring_service.dao.*;
import ca.mcgill.ecse321.tutoring_service.model.*;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepo;

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private TutorRepository tutorRepo;

	@Autowired
	private SessionRepository sessionRepo;

	/**
	 * This method creates the registration and checks if the input is valid.
	 * 
	 * @param time
	 * @param studentName
	 * @param tutorName
	 * @param startTime
	 * @param finishTime
	 * @return
	 */
	@Transactional
	public Registration createRegistration(String time, String studentName, String tutorName, String startTime,
			String finishTime) {
		if (time == null || time.trim() == "") {
			throw new IllegalArgumentException("time cannot be empty!");
		}
		if (studentName == null || studentName.trim() == "") {
			throw new IllegalArgumentException("studentName cannot be empty!");
		}
		if (tutorName == null || tutorName.trim() == "") {
			throw new IllegalArgumentException("tutorName cannot be empty!");
		}
		if (startTime == null || startTime.trim() == "") {
			throw new IllegalArgumentException("startTime cannot be empty!");
		}
		if (finishTime == null || finishTime.trim() == "") {
			throw new IllegalArgumentException("finishTime cannot be empty!");
		}
		Registration registration = new Registration();

		int tutorId = tutorRepo.findTutorByName(tutorName).getId();
		Session session = sessionRepo.findByStartTimeAndFinishTimeAndTutorId(startTime, finishTime, tutorId);

		registration.setTime(time);
		registration.setStudent(studentRepo.findStudentByName(studentName));
		registration.setSession(session);

		Registration registrationReturn = registrationRepo.save(registration);

		return registrationReturn;
	}

	/**
	 * This method creates the registration and checks if the input is valid.
	 * 
	 * @param time
	 * @return
	 */
	@Transactional
	public Registration createRegistration(String time) {
		if (time == null || time.trim() == "") {
			throw new IllegalArgumentException("time cannot be empty!");
		}
		Registration registration = new Registration();
		registration.setTime(time);

		registrationRepo.save(registration);

		return registration;
	}

	/**
	 * This method gets all registrations in the database.
	 * 
	 * @return
	 */
	@Transactional
	public List<Registration> getAllRegistration() {
		return toList(registrationRepo.findAll());
	}

	/**
	 * This method is used to delete the regsitration by time.
	 * 
	 * @param time
	 */
	@Transactional
	public void deleteByTime(String time) {
		registrationRepo.deleteByTime(time);
	}

	private <T> List<T> toList(Iterable<T> iterable) {
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
}
