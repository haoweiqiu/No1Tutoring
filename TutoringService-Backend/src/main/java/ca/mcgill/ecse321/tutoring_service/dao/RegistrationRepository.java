package ca.mcgill.ecse321.tutoring_service.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoring_service.model.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {

	Registration findByTimeAndStudent_id(String time, int id);

	Registration findRegistrationById(int id);

	Registration findRegistrationByTime(String time);

	void deleteAll();

	void deleteById(int id);

	void deleteByTime(String time);
}
