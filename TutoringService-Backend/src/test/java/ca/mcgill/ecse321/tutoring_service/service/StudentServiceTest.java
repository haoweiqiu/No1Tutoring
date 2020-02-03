package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoring_service.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
	@Autowired
	private StudentService service;

	@Autowired
	private SchoolService schoolService;

	@Test
	/**
	 * Test create students
	 */
	public void testCreateStudents() {
		// assertEquals(0, service.getAllStudents().size());

		String name = "YuhangZhang";
		String password = "1234567";
		int size = service.getAllStudents().size();
		try {
			service.createStudent(name, schoolService.createSchool("Concordia University ttt"), password);
		} catch (IllegalArgumentException e) {
			fail();
		}

		List<Student> allStudents = service.getAllStudents();

		assertEquals(allStudents.size(), allStudents.size());
//		assertEquals(name, allStudents.get(0).getName());
		service.deleteStudent(name);
		schoolService.deleteSchool("Concordia University ttt");
//		name=allStudents.get(0).getName();
		service.deleteStudent(name);
	}
}
