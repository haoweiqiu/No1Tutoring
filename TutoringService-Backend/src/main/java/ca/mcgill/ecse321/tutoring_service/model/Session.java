package ca.mcgill.ecse321.tutoring_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Session {
	private String startTime;

	public void setStartTime(String value) {
		this.startTime = value;
	}

	public String getStartTime() {
		return this.startTime;
	}

	private String finishTime;

	public void setFinishTime(String value) {
		this.finishTime = value;
	}

	public String getFinishTime() {
		return this.finishTime;
	}

	private int nrStudent;

	public void setNrStudent(int value) {
		this.nrStudent = value;
	}

	public int getNrStudent() {
		return this.nrStudent;
	}

	private Boolean isCancelled;

	public void setIsCancelled(Boolean value) {
		this.isCancelled = value;
	}

	public Boolean getIsCancelled() {
		return this.isCancelled;
	}

	private Tutor tutor;

	@ManyToOne(optional = true)
	public Tutor getTutor() {
		return this.tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	private Registration registration;

	@OneToOne(optional = true)
	public Registration getRegistration() {
		return this.registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	private Room room;

	@ManyToOne(optional = true)
	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
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
