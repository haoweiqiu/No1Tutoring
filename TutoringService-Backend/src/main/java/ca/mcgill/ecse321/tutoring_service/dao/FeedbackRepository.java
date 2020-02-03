package ca.mcgill.ecse321.tutoring_service.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoring_service.model.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
	Feedback findById(int feedbackId);

	void deleteByComment(String comment);

	void deleteAll();
}
