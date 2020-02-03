package ca.mcgill.ecse321.tutoring_service.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoring_service.model.Bill;

public interface BillRepository extends CrudRepository<Bill, Long> {
	Bill findById(int billId);

	void deleteById(int id);

	void deleteByAmount(double amount);

	void deleteAll();
}
