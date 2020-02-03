package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;

import ca.mcgill.ecse321.tutoring_service.dao.TutorRepository;
import ca.mcgill.ecse321.tutoring_service.model.Tutor;

@RunWith(MockitoJUnitRunner.class)
public class TutorMockTest {

	@Mock
	private TutorRepository tutorRepository;
	private Tutor tutor;

	@InjectMocks
	private TutorService service;

	private static final String PERSON_KEY = "TestTutor";
	private static final String NONEXISTING_KEY = "NotATutor";

	@Before
	public void setMockOutput() {
		when(tutorRepository.findTutorByName(anyString())).thenAnswer((InvocationOnMock invocation) -> {
			if (invocation.getArgument(0).equals(PERSON_KEY)) {
				Tutor person = new Tutor();
				person.setName(PERSON_KEY);
				return person;
			} else {
				return null;
			}
		});
	}

	@Test
	public void testCreateTutor() {
		assertEquals(0, service.getAllTutors().size());

		String name = "Oscar";

		try {
			tutor = service.createTutor(name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(name, tutor.getName());
	}

	@Test
	public void testCreateTutorNull() {
		String name = null;
		String error = null;

		try {
			tutor = service.createTutor(name);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Tutor name cannot be empty!", error);
	}
}