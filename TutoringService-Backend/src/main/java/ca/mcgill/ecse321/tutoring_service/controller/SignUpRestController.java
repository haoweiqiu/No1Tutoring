package ca.mcgill.ecse321.tutoring_service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoring_service.dto.SchoolDto;
import ca.mcgill.ecse321.tutoring_service.dto.StudentDto;
import ca.mcgill.ecse321.tutoring_service.model.School;
import ca.mcgill.ecse321.tutoring_service.model.Student;
import ca.mcgill.ecse321.tutoring_service.service.SchoolService;
import ca.mcgill.ecse321.tutoring_service.service.StudentService;

@CrossOrigin(origins = "*")
@RestController
public class SignUpRestController {

	@Autowired
	private SchoolService schoolService;
	@Autowired
	private StudentService studentService;

	/**
	 * This methods uses post restful controller to create a school
	 * 
	 * @param name is the school name which is the id for the school class
	 * @return a school data transfer onject
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/schools/{name}", "/schools/{name}/" })
	public SchoolDto createSchool(@PathVariable("name") String name) throws IllegalArgumentException {
		// @formatter:on
		School school = schoolService.createSchool(name);
		return convertToDto(school);
	}

	/**
	 * This methods is a get restful controller method that returns all schools in
	 * the databse.
	 * 
	 * @return all schools in data transfer object
	 */
	@GetMapping(value = { "/schools", "/schools/" })
	public List<SchoolDto> getAllSchools() {
		List<SchoolDto> schoolDtos = new ArrayList<>();
		for (School school : schoolService.getAllSchools()) {
			schoolDtos.add(convertToDto(school));
		}
		return schoolDtos;
	}

	/**
	 * This method is used to retrieve a school dto which has name=name.
	 * 
	 * @param name is the name of the school
	 * @return a school data transfer object with name name.
	 * @throws IllegalArgumentException
	 */
	@GetMapping(value = { "/schools/{name}", "/schools/{name}" })
	public SchoolDto getSchoolByName(@PathVariable("name") String name) throws IllegalArgumentException {
		return convertToDto(schoolService.getSchool(name));
	}

	/**
	 * This methods is used to retrieve a student dto which has name = name.
	 * 
	 * @param name is the name of the student
	 * @return a student dto
	 * @throws IllegalArgumentException
	 */
	@GetMapping(value = { "/students/{name}", "/students/{name}" })
	public String getStudentPasswordByName(@PathVariable("name") String name) throws IllegalArgumentException {
		String password1 = studentService.getStudent(name).getPassword();
		return password1;
	}

	/**
	 * This method creates student by providing name, password, and password.
	 * 
	 * @param name
	 * @param schoolName
	 * @param password
	 * @return
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/students/{name}/{schoolName}/{password}", "/students/{name}/{schoolName}/{password}" })
	public StudentDto createStudent(@PathVariable("name") String name, @PathVariable("schoolName") String schoolName,
			@PathVariable("password") String password) throws IllegalArgumentException {
		// @formatter:on
		School school = schoolService.getSchool(schoolName);
		Student student = studentService.createStudent(name, school, password);
		return convertToDto(student);
	}

	/**
	 * This method converts a school object to school dto
	 * 
	 * @param e
	 * @return
	 */
	private SchoolDto convertToDto(School e) {
		if (e == null) {
			throw new IllegalArgumentException("There is no such School!");
		}
		SchoolDto schoolDto = new SchoolDto(e.getName());
		return schoolDto;
	}

	/**
	 * This method converts s student object to student dto
	 * 
	 * @param e
	 * @return
	 */
	private StudentDto convertToDto(Student e) {
		if (e == null) {
			throw new IllegalArgumentException("There is no such Student!");
		}
		StudentDto studentDto = new StudentDto(convertToDto(e.getSchool()), e.getName(), e.getEmail(), e.getPassword());
		return studentDto;
	}
}
