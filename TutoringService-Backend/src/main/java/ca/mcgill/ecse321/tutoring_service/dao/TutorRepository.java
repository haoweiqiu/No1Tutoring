package ca.mcgill.ecse321.tutoring_service.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoring_service.model.Tutor;

public interface TutorRepository extends CrudRepository<Tutor, Long> {

	Tutor findById(int id);

	Tutor findTutorByName(String name);

	void deleteByName(String name);
}
