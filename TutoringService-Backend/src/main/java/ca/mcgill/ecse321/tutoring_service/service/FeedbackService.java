package ca.mcgill.ecse321.tutoring_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoring_service.dao.*;
import ca.mcgill.ecse321.tutoring_service.model.*;

@Service
public class FeedbackService {
	@Autowired
	private FeedbackRepository feedbackRepo;
	@Autowired
	private RegistrationRepository regRepo;
	@Autowired
	private StudentRepository sRepo;

	/**
	 * This method is used to create feedback,and checks if the input is valid
	 * 
	 * @param rate
	 * @param regTime
	 * @param studentName
	 * @param studentFeedback
	 * @return
	 */
	@Transactional
	public Feedback createFeedback(int rate, String regTime, String studentName, String studentFeedback) { // regTime
																											// stands
																											// for time
		// in registration
		// class, which is
		// session time.

		if (regTime == null) {
			throw new IllegalArgumentException("SessionTime cannot be empty!");
		}
		if (studentName == null) {
			throw new IllegalArgumentException("StudentName cannot be null!");
		}
		Feedback feedback = new Feedback();
		feedback.setComment(studentFeedback);
		feedback.setRating(rate);
		int id = sRepo.findStudentByName(studentName).getId();
		Registration reg = regRepo.findByTimeAndStudent_id(regTime, id);
		reg.setIsFeedbackGiven(true);
		feedback.setStudentRegistration(reg);

		regRepo.save(reg);

		Feedback feedbackReturn = feedbackRepo.save(feedback);
		return feedbackReturn;
	}

	/**
	 * This method is used to providing the feedback with rate only.
	 * 
	 * @param rate
	 * @return
	 */
	@Transactional
	public Feedback createFeedback(int rate) {
		if (rate == 0) {
			throw new IllegalArgumentException("rate cannot be 0!");
		}
		Feedback feedback = new Feedback();
		feedback.setRating(rate);

		feedbackRepo.save(feedback);
		return feedback;
	}

	/**
	 * This method is used to delete the feedback with the comment.
	 * 
	 * @param comment
	 */
	@Transactional
	public void deleteFeedbackByComment(String comment) {
		feedbackRepo.deleteByComment(comment);
	}

	/**
	 * Find all the Feedbacks
	 * 
	 * @return
	 */
	@Transactional
	public List<Feedback> getAllFeedbacks() {
		return toList(feedbackRepo.findAll());
	}

	private <T> List<T> toList(Iterable<T> iterable) {
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
}
