package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoring_service.model.Session;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionServiceTest {
	@Autowired
	private SessionService service;

	@Test
	/**
	 * Test create session
	 */
	public void testCreateSchool() {
		String startTime = "11:30";
		String finishTime = "12:30";
		String tutorName = "Erik";
		String courseName = "COMP 206";
		Session session = service.createSession("11:30", finishTime, tutorName, courseName, null);
		assertEquals(startTime, session.getStartTime());
		assertEquals(finishTime, session.getFinishTime());
		assertEquals(tutorName, session.getTutor().getName());
	}
}
