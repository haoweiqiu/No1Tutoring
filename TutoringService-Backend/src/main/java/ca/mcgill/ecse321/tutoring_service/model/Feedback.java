package ca.mcgill.ecse321.tutoring_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Id;

@Entity
public class Feedback {
	private String comment;

	public void setComment(String value) {
		this.comment = value;
	}

	public String getComment() {
		return this.comment;
	}

	private int rating;

	public void setRating(int value) {
		this.rating = value;
	}

	public int getRating() {
		return this.rating;
	}

	// this attribute should be useless
	private Registration tutorRegistration;

	@OneToOne(optional = true)
	public Registration getTutorRegistration() {
		return this.tutorRegistration;
	}

	public void setTutorRegistration(Registration tutorRegistration) {
		this.tutorRegistration = tutorRegistration;
	}

	private Registration studentRegistration;

	@OneToOne(optional = true)
	public Registration getStudentRegistration() {
		return this.studentRegistration;
	}

	public void setStudentRegistration(Registration studentRegistration) {
		this.studentRegistration = studentRegistration;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;
}
