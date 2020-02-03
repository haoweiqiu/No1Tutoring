package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoring_service.model.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {

	@Autowired
	private CourseService service;

	@Test
	/**
	 * Test create Course
	 */
	public void testCreateCourse() {
		// assertEquals(0, service.getAllCourses().size());

		int courseSize = service.getAllCourses().size();
		String name = "Math 141";

		try {
			service.createCourse(name);
		} catch (IllegalArgumentException e) {
			fail();
		}

		List<Course> allCourses = service.getAllCourses();

		assertEquals(courseSize + 1, allCourses.size());
		service.deleteCourseByName(name);
	}
}
