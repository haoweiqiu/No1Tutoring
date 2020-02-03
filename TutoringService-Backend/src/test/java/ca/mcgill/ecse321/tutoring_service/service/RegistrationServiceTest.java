
package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoring_service.model.Registration;
import ca.mcgill.ecse321.tutoring_service.model.School;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RegistrationServiceTest {

	@Autowired
	private RegistrationService service;

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private StudentService studentService;

	@Test
	/**
	 * Test create registration
	 */
	public void testCreateRegistration() {
		String studentName = "Joe";
		int size = service.getAllRegistration().size();
		String time = "2019/10/11";
		School school = schoolService.createSchool("McGill University");

		boolean isCancelled = false;

		service.createRegistration(time, studentName, "Erik", "11:40", "12:45");

		List<Registration> allRegistration = service.getAllRegistration();

		assertEquals(1 + size, allRegistration.size());
		service.deleteByTime(time);
		studentService.deleteStudent(studentName);
		schoolService.deleteSchool("McGill University");
	}

}
