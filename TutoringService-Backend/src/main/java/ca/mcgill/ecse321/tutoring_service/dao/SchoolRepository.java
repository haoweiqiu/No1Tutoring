package ca.mcgill.ecse321.tutoring_service.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoring_service.model.School;

public interface SchoolRepository extends CrudRepository<School, Integer> {
	School findSchoolByName(String name);

	void deleteByName(String name);

	void deleteAll();
}
