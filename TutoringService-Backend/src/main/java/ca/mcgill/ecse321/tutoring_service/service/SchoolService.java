package ca.mcgill.ecse321.tutoring_service.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoring_service.dao.*;
import ca.mcgill.ecse321.tutoring_service.model.*;

@Service
public class SchoolService {

	@Autowired
	SchoolRepository schoolRepository;

	/**
	 * This method create school object, and checks if the input is valid.
	 * 
	 * @param name
	 * @return
	 */
	@Transactional
	public School createSchool(String name) {
		if (name == null || name == "") {
			throw new IllegalArgumentException("Student name cannot be empty!");
		}
		School school = schoolRepository.findSchoolByName(name);

		if (school == null) {
			school = new School();
			school.setName(name);
			schoolRepository.save(school);

		}
		return school;
	}

	@Transactional
	public School getSchool(String name) {
		School school = schoolRepository.findSchoolByName(name);
		return school;
	}

	/**
	 * This method deletes school with name equals name
	 * 
	 * @param name
	 */
	@Transactional
	public void deleteSchool(String name) {
		schoolRepository.deleteByName(name);
	}

	/**
	 * This method returns all schools in the database.
	 * 
	 * @return
	 */
	@Transactional
	public List<School> getAllSchools() {
		return toList(schoolRepository.findAll());
	}

	/**
	 * This method returns a list of objects by giving iterable of objects.
	 * 
	 * @param <T>
	 * @param iterable
	 * @return
	 */
	private <T> List<T> toList(Iterable<T> iterable) {
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

}