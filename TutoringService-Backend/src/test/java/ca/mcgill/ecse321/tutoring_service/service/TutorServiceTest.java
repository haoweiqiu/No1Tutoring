package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoring_service.model.Tutor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorServiceTest {
	@Autowired
	private TutorService service;
	@Autowired
	private CourseService cService;

	@Test
	/**
	 * Test create tutor
	 */
	public void testCreateTutor() {
		// assertEquals(0, service.getAllTutors().size());

		String name = "Tom";

		int size = service.getAllTutors().size();

		try {
			Tutor tutor = service.createTutor(name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Tutor> allTutors = service.getAllTutors();
//
		assertEquals(size + 1, allTutors.size());
		String name1 = allTutors.get(0).getName();
		if (name1 != null) {
			name1 = "a";
		}
		service.deleteTutor(name);

	}
}
