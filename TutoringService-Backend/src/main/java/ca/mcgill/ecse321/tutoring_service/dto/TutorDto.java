package ca.mcgill.ecse321.tutoring_service.dto;

public class TutorDto {
	String name;
	String email;

	/**
	 * constructor of the tutor dto
	 * 
	 * @param name
	 * @param email
	 */

	public TutorDto(String name, String email) {
		this.name = name;
		this.email = email;
	}

	/**
	 * getter of the name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * getter of the email
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}
}