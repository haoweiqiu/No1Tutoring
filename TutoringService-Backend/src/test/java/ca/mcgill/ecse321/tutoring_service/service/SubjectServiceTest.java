package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoring_service.model.Subject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubjectServiceTest {
	@Autowired
	private SubjectService service;

	@Test
	/**
	 * Test create subject
	 */
	public void testCreateSubject() {
		service.deleteAll();
//		assertEquals(0, service.getAllSubjects().size());

		String name = "COMP 251";

		int size = service.getAllSubjects().size();

		try {
			service.createSubject(name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Subject> allSubjects = service.getAllSubjects();

		assertEquals(size + 1, allSubjects.size());
		assertEquals(name, allSubjects.get(0).getName());
		service.deleteSubject(name);
	}
}
