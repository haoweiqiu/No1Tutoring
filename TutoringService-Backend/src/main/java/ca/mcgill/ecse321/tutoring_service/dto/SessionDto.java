package ca.mcgill.ecse321.tutoring_service.dto;

public class SessionDto {

	private String startTime;
	private String finishTime;
	private int nrStudent;
	private Boolean isCancelled;
	private String courseName;
	private int roomNr;
	private TutorDto tutorDto;

	public SessionDto() {

	}

	/**
	 * Constructor of the session dto
	 * 
	 * @param startTime
	 * @param finishTime
	 */
	public SessionDto(String startTime, String finishTime) {
		this.startTime = startTime;
		this.finishTime = finishTime;
	}

	/**
	 * Constructor of the session dto
	 * 
	 * @param startTime
	 * @param finishTime
	 * @param nrStudent
	 * @param tutorDto
	 * @param roomNr
	 */
	public SessionDto(String startTime, String finishTime, int nrStudent, TutorDto tutorDto, int roomNr) {
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.nrStudent = nrStudent;
		this.tutorDto = tutorDto;
		this.roomNr = roomNr;
	}

	/**
	 * getter of the start time
	 * 
	 * @return
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * getter of the finish time
	 * 
	 * @return
	 */
	public String getFinishTime() {
		return finishTime;
	}

	/**
	 * getter of the nr of students
	 * 
	 * @return
	 */
	public int getNrStudent() {
		return nrStudent;
	}

	/**
	 * getter of the iscancelled
	 * 
	 * @return
	 */
	public Boolean getIsCancelled() {
		return isCancelled;
	}

	/**
	 * gettter of the course name
	 * 
	 * @return
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * getter of the roomnr
	 * 
	 * @return
	 */
	public int getRoomNr() {
		return roomNr;
	}

	/**
	 * getter of the tutordto
	 * 
	 * @return
	 */
	public TutorDto getTutorDto() {
		return tutorDto;
	}

}
