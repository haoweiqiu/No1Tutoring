package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ca.mcgill.ecse321.tutoring_service.dao.CourseRepository;
import ca.mcgill.ecse321.tutoring_service.dao.SessionRepository;
import ca.mcgill.ecse321.tutoring_service.dao.TutorRepository;
import ca.mcgill.ecse321.tutoring_service.model.Course;
import ca.mcgill.ecse321.tutoring_service.model.Room;
import ca.mcgill.ecse321.tutoring_service.model.Session;
import ca.mcgill.ecse321.tutoring_service.model.Tutor;

@RunWith(MockitoJUnitRunner.class)
public class SessionMockTest {
	@Mock
	private SessionRepository sessionDao;
	@Mock
	private CourseRepository courseDao;
	@Mock
	private TutorRepository tutorDao;

	@Mock
	private Room room;
	@Mock
	private Course course;
	@Mock
	private Tutor tutor;

	@InjectMocks
	private SessionService service;
	@InjectMocks
	private BillService bService;

	private static final String SESSION_KEY = "TESTDATE";
	private static final String NONE_SESSION_KEY = "NODATE";

	@Test
	/**
	 * Test create session
	 */
	public void testCreateSession() {
		String startTime = "2019-10-1-22:00";
		String finishTime = "2019-10-1-23:00";
//		String tutorName = tutor.getName();
//		String courseNr = course.getName();
		Session session = null;
		try {
			session = service.createSession(startTime, finishTime);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}
		assertEquals(startTime, session.getStartTime());
		assertEquals(finishTime, session.getFinishTime());
//		assertEquals(tutorName, session.getTutor().getName());
//		assertEquals(courseNr, session.getCourse().getName());
//		assertEquals(room, session.getRoom());
	}
}
