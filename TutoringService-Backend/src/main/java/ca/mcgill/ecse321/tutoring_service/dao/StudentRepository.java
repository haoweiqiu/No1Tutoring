package ca.mcgill.ecse321.tutoring_service.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoring_service.model.Student;

//@YuhangZhang
public interface StudentRepository extends CrudRepository<Student, Long> {
	Student findStudentByName(String Name);

	void deleteByName(String Name);

	Student findById(int id);
}
