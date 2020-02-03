package ca.mcgill.ecse321.tutoring_service.dto;

public class FeedbackDto {
	private String comment;

	private int rating;

	private RegistrationDto tutorRegistration;

	private RegistrationDto studentRegistration;

	public FeedbackDto() {

	}

	/**
	 * 
	 * @param comment
	 * @param rate
	 */
	// feedback form for tutors
	public FeedbackDto(String comment, int rate) {

		this.comment = comment;

		this.rating = rate;

	}

	/**
	 * 
	 * @param comment
	 * @param tutorRegistration
	 */
	public FeedbackDto(String comment, RegistrationDto tutorRegistration) {

		this.comment = comment;

		// this.rating = 0;

		this.tutorRegistration = tutorRegistration;

		this.studentRegistration = null;
	}

	/**
	 * 
	 * @param rating
	 * @param studentRegistration
	 */
	// feedback form for students
	public FeedbackDto(int rating, RegistrationDto studentRegistration) {

		this.rating = rating;

		this.studentRegistration = studentRegistration;

		this.tutorRegistration = null;
	}

	public FeedbackDto(String comment, int rating, RegistrationDto studentRegistration) {

		this.comment = comment;

		this.rating = rating;

		this.studentRegistration = studentRegistration;

		this.tutorRegistration = null;

	}

	public void setComment(String value) {
		this.comment = value;
	}

	public String getComment() {
		return this.comment;
	}

	public void setRating(int value) {
		this.rating = value;
	}

	public int getRating() {
		return this.rating;
	}

	public RegistrationDto getStudentRegistration() {
		return this.studentRegistration;
	}

	public void setStudentRegistration(RegistrationDto studentRegistration) {
		this.studentRegistration = studentRegistration;
	}

	public RegistrationDto getTutorRegistration() {
		return this.tutorRegistration;
	}

	public void setTutorRegistration(RegistrationDto tutorRegistration) {
		this.tutorRegistration = tutorRegistration;
	}

}
