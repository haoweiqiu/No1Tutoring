package ca.mcgill.ecse321.tutoring_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Registration {
	private String time;

	public void setTime(String value) {
		this.time = value;
	}

	public String getTime() {
		return this.time;
	}

	private Boolean isCancelled;

	public void setIsCancelled(Boolean value) {
		this.isCancelled = value;
	}

	public Boolean getIsCancelled() {
		return this.isCancelled;
	}

	private Session session;

	@OneToOne(optional = true)
	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	private Bill bill;

	@OneToOne(optional = true)
	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	private Student student;

	@ManyToOne(optional = true)
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private Feedback studentFeedback;

	@OneToOne(mappedBy = "tutorRegistration", optional = true)
	public Feedback getStudentFeedback() {
		return this.studentFeedback;
	}

	public void setStudentFeedback(Feedback studentFeedback) {
		this.studentFeedback = studentFeedback;
	}

	private Feedback tutorFeedback;

	@OneToOne(mappedBy = "studentRegistration", optional = true)
	public Feedback getTutorFeedback() {
		return this.tutorFeedback;
	}

	public void setTutorFeedback(Feedback tutorFeedback) {
		this.tutorFeedback = tutorFeedback;
	}

	private Boolean isFeedbackGiven = false;

	public Boolean getIsFeedbackGiven() {
		return this.isFeedbackGiven;
	}

	public void setIsFeedbackGiven(Boolean isGiven) {
		this.isFeedbackGiven = isGiven;
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
