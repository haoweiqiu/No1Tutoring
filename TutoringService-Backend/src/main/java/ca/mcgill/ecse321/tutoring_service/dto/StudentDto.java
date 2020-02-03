package ca.mcgill.ecse321.tutoring_service.dto;

public class StudentDto {
	private SchoolDto school;
	private String name;
	private String email;
	private String password;
	private int year;

	/**
	 * Constructor of the student dto
	 * 
	 * @param school
	 * @param name
	 * @param email
	 * @param password
	 */
	public StudentDto(SchoolDto school, String name, String email, String password) {
		this.school = school;
		this.name = name;
		this.password = password;
		this.email = email;
		this.year = 0;
	}

	/**
	 * Constructor of the student dto
	 * 
	 * @param school
	 * @param name
	 * @param password
	 */
	public StudentDto(SchoolDto school, String name, String password) {
		this.school = school;
		this.name = name;
		this.password = password;
		this.email = null;
		this.year = 0;
	}

	/**
	 * Constructor of the student dto
	 * 
	 * @param name
	 * @param password
	 */
	public StudentDto(String name, String password) {
		this.school = null;
		this.name = name;
		this.password = password;
		this.email = null;
		this.year = 0;
	}

	/**
	 * Constructor of the student dto
	 * 
	 * @param school
	 * @param name
	 */
	public StudentDto(SchoolDto school, String name) {
		this.school = school;
		this.name = name;
		this.password = null;
		this.email = null;
		this.year = 0;
	}

	/**
	 * Constructor of the student dto
	 * 
	 * @param name
	 */
	public StudentDto(String name) {
		this.school = null;
		this.name = name;
		this.password = null;
		this.email = null;
		this.year = 0;
	}

	/**
	 * getter of the school
	 * 
	 * @return
	 */
	public SchoolDto getSchool() {
		return this.school;
	}

	/**
	 * getter of the password
	 * 
	 * @return
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * getter of the name
	 * 
	 * @return
	 */
	public String name() {
		return this.name;
	}

	/**
	 * getter of the email
	 * 
	 * @return
	 */
	public String email() {
		return this.email();
	}

	/**
	 * getter of the year.
	 * 
	 * @return
	 */
	public int getYear() {
		return this.year;

	}

}
