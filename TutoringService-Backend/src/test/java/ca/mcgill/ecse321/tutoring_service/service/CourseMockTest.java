package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ca.mcgill.ecse321.tutoring_service.dao.CourseRepository;
import ca.mcgill.ecse321.tutoring_service.model.Course;

@RunWith(MockitoJUnitRunner.class)
public class CourseMockTest {

	@Mock
	private CourseRepository courseRepository;

	@InjectMocks
	private CourseService service;

	private static final String PERSON_KEY = "TestCourse";
	private static final String NONEXISTING_KEY = "NotACourse";

	@Test
	/**
	 * Test create Course
	 */
	public void testCreateCourse() {
		assertEquals(0, service.getAllCourses().size());

		String name = "COMP 351";
		Course course = null;
		try {
			course = service.createCourse(name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(name, name);
		service.deleteCourseByName(name);
	}

	@Test
	public void testCreateCourseNull() {
		assertEquals(0, service.getAllCourses().size());

		String name = null;

		String error = "Course name cannot be empty!";
		Course course = null;

		try {
			course = service.createCourse(name);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Course name cannot be empty!", error);
	}
}