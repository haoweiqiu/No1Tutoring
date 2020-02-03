package ca.mcgill.ecse321.tutoring_service.dto;

import ca.mcgill.ecse321.tutoring_service.model.Feedback;

public class RegistrationDto {

	private String regTime;

	private SessionDto sessionD;

	private StudentDto student;

	private Feedback studentFeedback;

	private Feedback tutorFeedback;

	private Boolean isFeedbackGiven;

	public RegistrationDto() {

	}

	/**
	 * 
	 * @param regTime
	 * @param student
	 */
	// student at one regTime only can has one registration
	public RegistrationDto(String regTime, StudentDto student) {

		this(regTime, null, student, null, null);

	}

	/**
	 * 
	 * @param regTime
	 * @param session
	 * @param student
	 * @param studentFeedback
	 * @param tutorFeedback
	 */
	// complete arguments
	public RegistrationDto(String regTime, SessionDto session, StudentDto student, Feedback studentFeedback,
			Feedback tutorFeedback) {

		this.regTime = regTime;

		this.sessionD = session;

		this.student = student;

		this.studentFeedback = studentFeedback;

		this.tutorFeedback = tutorFeedback;
	}

	/**
	 * 
	 * @return
	 */
	public String getregTime() {
		return this.regTime;
	}

	/**
	 * 
	 * @param value
	 */
	public void setregTime(String value) {
		this.regTime = value;
	}

	/**
	 * 
	 * @return
	 */
	public SessionDto getSession() {
		return this.sessionD;
	}

	/**
	 * 
	 * @param session
	 */
	public void setSession(SessionDto session) {
		this.sessionD = session;
	}

	/**
	 * 
	 * @return
	 */
	public StudentDto getStudent() {
		return this.student;
	}

	/**
	 * 
	 * @param student
	 */
	public void setStudent(StudentDto student) {
		this.student = student;
	}

	/**
	 * 
	 * @return
	 */
	public Feedback getTutorFeedback() {
		return this.tutorFeedback;
	}

	/**
	 * 
	 * @param tutorFeedback
	 */
	public void setTutorFeedback(Feedback tutorFeedback) {
		this.tutorFeedback = tutorFeedback;
	}

	/**
	 * 
	 * @return
	 */
	public Feedback getStudentFeedback() {
		return this.studentFeedback;
	}

	/**
	 * 
	 * @param studentFeedback
	 */
	public void setStudentFeedback(Feedback studentFeedback) {
		this.studentFeedback = studentFeedback;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getIsFeedbackGiven() {
		return this.isFeedbackGiven;
	}

	/**
	 * 
	 * @param isGiven
	 */
	public void setIsFeedbackGiven(Boolean isGiven) {
		this.isFeedbackGiven = isGiven;
	}

	/**
	 * 
	 * @param regTime
	 * @param sessionD
	 * @param isGiven
	 */
	public RegistrationDto(String regTime, SessionDto sessionD, Boolean isGiven) {
		this.regTime = regTime;
		this.sessionD = sessionD;
		this.isFeedbackGiven = isGiven;
	}

	/**
	 * 
	 * @return
	 */
	public SessionDto getSessionD() {
		return sessionD;
	}
}