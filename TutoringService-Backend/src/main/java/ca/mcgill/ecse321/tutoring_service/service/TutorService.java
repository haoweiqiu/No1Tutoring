package ca.mcgill.ecse321.tutoring_service.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoring_service.dao.*;
import ca.mcgill.ecse321.tutoring_service.model.*;

@Service
public class TutorService {
	// Tutor
	@Autowired
	TutorRepository tutorRepository;

	/**
	 * This method is used to create the tutor and checks if the input is valid.
	 * 
	 * @param name
	 * @return
	 */
	@Transactional
	public Tutor createTutor(String name) {
		if (name == null || name == "") {
			throw new IllegalArgumentException("Tutor name cannot be empty!");
		}
		Tutor tutor = tutorRepository.findTutorByName(name);
		if (tutor == null) {
			tutor = new Tutor();
			tutor.setName(name);
			tutorRepository.save(tutor);
		}
		return tutor;
	}

	/**
	 * This method is used to get the tutor by name.
	 * 
	 * @param name
	 * @return
	 */
	@Transactional
	public Tutor getTutor(String name) {
		Tutor tutor = tutorRepository.findTutorByName(name);
		return tutor;
	}

	/**
	 * This method is used to delete the tutor by name.
	 * 
	 * @param name
	 */
	@Transactional
	public void deleteTutor(String name) {
		tutorRepository.deleteByName(name);
	}

	/**
	 * This method is used to get all tutors.
	 * 
	 * @return
	 */
	@Transactional
	public List<Tutor> getAllTutors() {
		return toList(tutorRepository.findAll());
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
