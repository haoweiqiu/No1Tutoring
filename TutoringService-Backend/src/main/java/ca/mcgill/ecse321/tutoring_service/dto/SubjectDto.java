package ca.mcgill.ecse321.tutoring_service.dto;

import java.util.Set;

import ca.mcgill.ecse321.tutoring_service.model.School;

public class SubjectDto {
	Set<School> school;
	String name;

	/**
	 * Constructor of the subject dto
	 * 
	 * @param school
	 * @param name
	 */
	public SubjectDto(Set<School> school, String name) {
		this.school = school;
		this.name = name;
	}

	/**
	 * getter of the school
	 * 
	 * @return
	 */
	public Set<School> getSchool() {
		return school;
	}

	/**
	 * getter of the name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
}