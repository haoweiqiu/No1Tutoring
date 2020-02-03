package ca.mcgill.ecse321.tutoring_service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoring_service.dto.FeedbackDto;
import ca.mcgill.ecse321.tutoring_service.model.Feedback;
import ca.mcgill.ecse321.tutoring_service.model.Registration;
import ca.mcgill.ecse321.tutoring_service.model.Session;
import ca.mcgill.ecse321.tutoring_service.service.FeedbackService;

@CrossOrigin(origins = "*")
@RestController
public class FeedbackRestController {

	@Autowired
	private FeedbackService feedbackService;

	/**
	 * This method is used to create a feedback provided by the dstudent
	 * 
	 * @param comment
	 * @param time
	 * @param name
	 * @param rate
	 * @return
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/feedback/", "/feedback" })
	public FeedbackDto createStudentFeedback(@RequestParam(name = "studentFeedback") String comment,
			@RequestParam(name = "regTime") String time, @RequestParam(name = "name") String name,
			@RequestParam(name = "rate") String rate) throws IllegalArgumentException {

		Feedback studentFeedback = feedbackService.createFeedback(Integer.parseInt(rate), time, name, comment);

		FeedbackDto tutorfeedbackDto = convertToDto(studentFeedback);

		return tutorfeedbackDto;

	}

	/**
	 * getTutorFeedback
	 * 
	 */
	@GetMapping(value = { "/tutorFeedbacks/", "/tutorFeedbacks" })
	public List<FeedbackDto> getTutorFeedback(@RequestParam("studentName") String name)
			throws IllegalArgumentException {

		List<Feedback> allFeedbacks = feedbackService.getAllFeedbacks();

		List<Feedback> allTutorFeedback = new ArrayList<>();

		for (Feedback f : allFeedbacks) {

			Registration reg = f.getStudentRegistration();

			if (reg.getStudent().getName().equals(name) && f.getRating() == 0) {
				allTutorFeedback.add(f);
			}
		}

		List<FeedbackDto> allTutorFeedbackDtos = new ArrayList<>();

		for (Feedback feedback : allTutorFeedback) {
			allTutorFeedbackDtos.add(convertToDto(feedback));
		}

		return allTutorFeedbackDtos;

	}

	/**
	 * getAllFeedbacks first by adding a help looping function in feedback --done
	 * use a "for loop" to see if one has a tutorRegistration equals to the given
	 * argument if there is one, add it to dto list
	 * 
	 * Define: tutor can NOT write feedback to student
	 * 
	 * this feedback is used to evaluate tutor
	 */
	@GetMapping(value = { "/all_student_feedbacks/", "/all_student_feedbacks" })
	public List<FeedbackDto> getAllStudentFeedbacks(@RequestParam("tutor_name") String name)
			throws IllegalArgumentException {

		List<Feedback> allFeedbacks = feedbackService.getAllFeedbacks();

		List<Feedback> allStudentF = new ArrayList<>();

		for (Feedback f : allFeedbacks) {
			Registration reg = f.getStudentRegistration();
			Session session = reg.getSession();
			if (session.getTutor().getName().equals(name))
				allStudentF.add(f);
		}

		List<FeedbackDto> allStudentFeedbackDtos = new ArrayList<>();

		for (Feedback feedback : allStudentF) {
			allStudentFeedbackDtos.add(convertToDto(feedback));
		}

		return allStudentFeedbackDtos;

	}

	/**
	 * This method converts the feedback to feedback dto
	 * 
	 * @param feedback f
	 * @return
	 */
	private FeedbackDto convertToDto(Feedback f) {
		if (f == null) {
			throw new IllegalArgumentException("There is no such Feedback!");
		}
		FeedbackDto feedbackDto = new FeedbackDto(f.getComment(), f.getRating());
		return feedbackDto;
	}
}
