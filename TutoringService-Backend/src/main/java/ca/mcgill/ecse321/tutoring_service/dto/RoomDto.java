package ca.mcgill.ecse321.tutoring_service.dto;

import java.util.*;

public class RoomDto {
	private int capacity;
	private int roomNr;
	private Set<SessionDto> sessions;
	private int id;

	public RoomDto() {

	}

	public RoomDto(int id) {
		this(99, 99, null, id);
	}

	/**
	 * Constructor of the room dto
	 * 
	 * @param capa
	 * @param roomNr
	 * @param sessions
	 * @param id
	 */
	public RoomDto(int capa, int roomNr, Set<SessionDto> sessions, int id) {
		this.capacity = capa;
		this.roomNr = roomNr;
		this.sessions = sessions;
		this.id = id;
	}

	/**
	 * Getter of the capacity
	 * 
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Getter of the room nr
	 * 
	 * @return
	 */
	public int getRoomNr() {
		return roomNr;
	}

	/**
	 * getter of the sessions
	 * 
	 * @return
	 */
	public Set<SessionDto> getSessions() {
		return sessions;
	}

	/**
	 * Getter of the id
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
}
