package ca.mcgill.ecse321.tutoring_service.service;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ca.mcgill.ecse321.tutoring_service.dao.*;
import ca.mcgill.ecse321.tutoring_service.model.*;
import ca.mcgill.ecse321.tutoring_service.controller.*;
import ca.mcgill.ecse321.tutoring_service.*;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentMockTest {
	@Mock
	private StudentRepository studentDao;

	@InjectMocks
	private StudentService service;

	private static final String STUDENT_KEY = "TestStudent";
	private static final String NONEXISTING_KEY = "NotAStudent";

	@Before
	public void setMockOutput() {
		when(studentDao.findStudentByName(anyString())).thenAnswer((InvocationOnMock invocation) -> {
			if (invocation.getArgument(0).equals(STUDENT_KEY)) {
				Student student = new Student();
				student.setName(STUDENT_KEY);
				return student;
			} else {
				return null;
			}
		});
	}

	@Test
	/**
	 * Test create student
	 */
	public void testCreatePerson() {
		assertEquals(0, service.getAllStudents().size());

		String name = "Oscar";
		School school = new School();
		String password = "1234567";
		Student student = null;
		try {
			student = service.createStudent(name, school, password);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(name, student.getName());
	}

	@Test
	public void testCreateStudentNull() {
		assertEquals(0, service.getAllStudents().size());

		// String name = "Oscar";
		School school = new School();
		Student student = null;
		String error = null;
		String password = "1234567";
		try {
			student = service.createStudent(null, school, password);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}

		assertEquals("Student name cannot be empty!", error);
	}

	@Test
	public void testCreateStudentSchoolNull() {
		assertEquals(0, service.getAllStudents().size());

		// String name = "Oscar";
		School school = null;
		Student student = null;
		String error = null;
		String password = "1234567";
		try {
			student = service.createStudent("Oscar", school, password);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}

		assertEquals("School name cannot be empty!", error);
	}
}