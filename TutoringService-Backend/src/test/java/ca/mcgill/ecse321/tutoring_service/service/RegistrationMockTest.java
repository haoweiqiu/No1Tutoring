package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ca.mcgill.ecse321.tutoring_service.dao.RegistrationRepository;
import ca.mcgill.ecse321.tutoring_service.model.Registration;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationMockTest {
	@Mock
	private RegistrationRepository regDao;

	@InjectMocks
	private RegistrationService service;

	// private static final String TIME_KEY = "11:59";

	@Test
	/**
	 * Test create registration
	 */
	public void testCreateCourse() {
		assertEquals(0, service.getAllRegistration().size());

		String time = "111";
		Registration reg = null;
		try {
			reg = service.createRegistration(time);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(time, reg.getTime());
	}

	@Test
	public void testCreateCourseNull() {
		String time = null;
		String error = null;

		try {
			service.createRegistration(time);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("time cannot be empty!", error);
	}
}
