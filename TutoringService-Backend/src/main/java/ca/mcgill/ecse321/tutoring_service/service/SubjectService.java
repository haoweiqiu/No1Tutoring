package ca.mcgill.ecse321.tutoring_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoring_service.dao.SubjectRepository;
import ca.mcgill.ecse321.tutoring_service.model.Subject;

@Service
public class SubjectService {
	@Autowired
	SubjectRepository subjectRepository;

/**
 * This is used to create subject and checks if the inputi s valid.
 * @param name
 * @return
 */
	@Transactional
	public Subject createSubject(String name) {
		if (name == null || name == "") {
			throw new IllegalArgumentException("Subject name cannot be empty!");
		}
		Subject subject = subjectRepository.findSubjectByName(name);
		if (subject == null) {
			subject = new Subject();
			subject.setName(name);
			subjectRepository.save(subject);
		}
		return subject;
	}
/**
 * This is used to get the subject by name
 * @param name
 * @return
 */
	@Transactional
	public Subject getSubject(String name) {
		Subject subject = subjectRepository.findSubjectByName(name);
		return subject;
	}
/**
 * This is used to delete the subject by name.
 * @param name
 */
	@Transactional
	public void deleteSubject(String name) {
		subjectRepository.deleteByName(name);
	}
/**
 * This is used to retriece all subjects.
 * @return
 */
	@Transactional
	public List<Subject> getAllSubjects() {
		return toList(subjectRepository.findAll());
	}

	private <T> List<T> toList(Iterable<T> iterable) {
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
/**
 * This is used to delete all subjects in the database.
 */
	public void deleteAll() {
		subjectRepository.deleteAll();

	}
}
