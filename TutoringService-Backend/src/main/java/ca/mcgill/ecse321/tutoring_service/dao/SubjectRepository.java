package ca.mcgill.ecse321.tutoring_service.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoring_service.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
	Subject findSubjectByName(String name);

	void deleteByName(String name);
}