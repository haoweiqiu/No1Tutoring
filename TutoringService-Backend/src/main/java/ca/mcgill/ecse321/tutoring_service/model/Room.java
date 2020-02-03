package ca.mcgill.ecse321.tutoring_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.Id;

@Entity
public class Room {
	private int capacity;

	public void setCapacity(int value) {
		this.capacity = value;
	}

	public int getCapacity() {
		return this.capacity;
	}

	private int roomNr;

	public void setRoomNr(int value) {
		this.roomNr = value;
	}

	public int getRoomNr() {
		return this.roomNr;
	}

	private Set<Session> session;

	@OneToMany(mappedBy = "room")
	public Set<Session> getSession() {
		return this.session;
	}

	public void setSession(Set<Session> sessions) {
		this.session = sessions;
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
