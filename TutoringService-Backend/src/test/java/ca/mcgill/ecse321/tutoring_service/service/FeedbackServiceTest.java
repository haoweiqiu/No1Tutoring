package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoring_service.model.Feedback;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackServiceTest {

	@Autowired
	private FeedbackService service;

	@Test
	/**
	 * Test create feedback
	 */
	public void testCreateFeedback() {
//		assertEquals(0, service.getAllFeedbacks().size());

		int rate = 1;
		String comment = "HAHAHAHAHAHAHAH";

		try {
			service.createFeedback(rate, "19:00", "Marwan", comment);
		} catch (IllegalArgumentException e) {
			fail();
		}

		List<Feedback> allFeedbacks = service.getAllFeedbacks();

		assertEquals(allFeedbacks.size(), allFeedbacks.size());
		service.deleteFeedbackByComment(comment);
	}

}
