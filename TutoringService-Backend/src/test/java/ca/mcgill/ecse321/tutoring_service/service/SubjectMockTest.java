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

import ca.mcgill.ecse321.tutoring_service.dao.SubjectRepository;
import ca.mcgill.ecse321.tutoring_service.model.Subject;

@RunWith(MockitoJUnitRunner.class)
public class SubjectMockTest {

	@Mock
	private SubjectRepository subjectRepository;

	@InjectMocks
	private SubjectService service;

	private static final String PERSON_KEY = "TestSubject";
	private static final String NONEXISTING_KEY = "NotASubject";

	@Before
	public void setMockOutput() {
		when(subjectRepository.findSubjectByName(anyString())).thenAnswer((InvocationOnMock invocation) -> {
			if (invocation.getArgument(0).equals(PERSON_KEY)) {
				Subject subject = new Subject();
				subject.setName(PERSON_KEY);
				return subject;
			} else {
				return null;
			}
		});
	}

	@Test
	/**
	 * Test create tutor
	 */
	public void testCreateTutor() {
		assertEquals(0, service.getAllSubjects().size());

		String name = "Oscar";
		Subject subject = null;
		try {
			subject = service.createSubject(name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(name, subject.getName());
	}

	@Test
	public void testCreateTutorNull() {
		assertEquals(0, service.getAllSubjects().size());
		String name = null;
		Subject subject;
		String error = null;

		try {
			subject = service.createSubject(name);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Subject name cannot be empty!", error);
	}
}