package ca.mcgill.ecse321.tutoring_service.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoring_service.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

	Course findById(int id);

	Course findCourseByName(String name);

	void deleteById(int id);

	void deleteByName(String name);

	void deleteAll();
}
