package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ca.mcgill.ecse321.tutoring_service.dao.FeedbackRepository;
import ca.mcgill.ecse321.tutoring_service.model.Feedback;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackMockTest {
	@Mock
	private FeedbackRepository feedbackDao;

	@InjectMocks
	private FeedbackService service;

	@InjectMocks
	private RegistrationService rService;

	@InjectMocks
	private StudentService sService;

	private static final int Feedback_ID = 10;

	@Test
	/**
	 * Test create feedback
	 */
	public void testCreateFeedback() {
		assertEquals(0, service.getAllFeedbacks().size());

		int rate = 10;

		Feedback feedback = new Feedback();

		try {

			feedback = service.createFeedback(rate);

		} catch (IllegalArgumentException e) {

			fail(); // Check that if a error occurred
		}

		assertEquals(rate, feedback.getRating());
	}

	@Test
	public void testCreateFeedbackRateFault() {
		assertEquals(0, service.getAllFeedbacks().size());

		int rate = 0;
//		String sessionTime = "19:30";
//		int studentId = 0;
//		String comment = "this tutor sucks";
		String error = null;

		try {
			Feedback feedback = service.createFeedback(rate);
		} catch (IllegalArgumentException e) {

			error = e.getMessage();
		}

		assertEquals("rate cannot be 0!", error);
	}

	@Test
	public void testCreateFeedbackNull() {
		assertEquals(0, service.getAllFeedbacks().size());

		int rate = 10;
		String sessionTime = "19:30";
		int studentId = 0;
		String comment = "this tutor sucks";
		String error = null;

		try {
			Feedback feedback = service.createFeedback(rate, sessionTime, null, comment);
		} catch (IllegalArgumentException e) {

			error = e.getMessage();
		}

		assertEquals("StudentName cannot be null!", error);
	}
}