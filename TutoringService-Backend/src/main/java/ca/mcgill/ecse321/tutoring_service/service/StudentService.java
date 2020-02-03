package ca.mcgill.ecse321.tutoring_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoring_service.dao.StudentRepository;
import ca.mcgill.ecse321.tutoring_service.model.School;
import ca.mcgill.ecse321.tutoring_service.model.Student;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	/**
	 * This method is used to create student,and checks if the input is valid.
	 * 
	 * @param name
	 * @param school
	 * @param password
	 * @return
	 */
	@Transactional
	public Student createStudent(String name, School school, String password) {
		if (name == null || name == "") {
			throw new IllegalArgumentException("Student name cannot be empty!");
		}
		if (school == null) {
			throw new IllegalArgumentException("School name cannot be empty!");
		}
		Student student = studentRepository.findStudentByName(name);

		if (student == null) {
			student = new Student();
			student.setName(name);
			student.setSchool(school);
			student.setPassword(password);
			studentRepository.save(student);
		}
		return student;
	}

	@Transactional
	public Student getStudent(String name) {
		Student student = studentRepository.findStudentByName(name);
		return student;
	}

	@Transactional
	public void deleteStudent(String name) {
		studentRepository.deleteByName(name);
	}

	@Transactional
	public List<Student> getAllStudents() {
		return toList(studentRepository.findAll());
	}

	private <T> List<T> toList(Iterable<T> iterable) {
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
}
