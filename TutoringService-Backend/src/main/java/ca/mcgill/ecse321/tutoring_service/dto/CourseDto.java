package ca.mcgill.ecse321.tutoring_service.dto;

import ca.mcgill.ecse321.tutoring_service.model.Session;
import ca.mcgill.ecse321.tutoring_service.model.Subject;
import ca.mcgill.ecse321.tutoring_service.model.Tutor;

public class CourseDto {
	Tutor tutor;
	Session session;
	Subject subject;
	String name;

	/**
	 * Constructor of the course dto.
	 * 
	 * @param tutor
	 * @param session
	 * @param subject
	 * @param name
	 */
	public CourseDto(Tutor tutor, Session session, Subject subject, String name) {
		this.tutor = tutor;
		this.session = session;
		this.subject = subject;
		this.name = name;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public Session getSession() {
		return session;
	}

	public Subject getSubject() {
		return subject;
	}

	public String getName() {
		return name;
	}
}