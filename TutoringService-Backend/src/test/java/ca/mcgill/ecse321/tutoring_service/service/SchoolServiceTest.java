
package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoring_service.model.School;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolServiceTest {
	@Autowired
	private SchoolService service;

	@Test
	/**
	 * Test create school
	 */
	public void testCreateSchool() {
//		assertEquals(0, service.getAllSchools().size());

		String name = "McGill";

		int size = service.getAllSchools().size();

		try {
			service.createSchool("abcd");
			service.createSchool("bbcc");
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<School> allSchools = service.getAllSchools();

		assertEquals(size + 2, allSchools.size());
		assertEquals(name, allSchools.get(0).getName());
		name = allSchools.get(0).getName();
		service.deleteSchool("abcd");
		name = allSchools.get(0).getName();
		service.deleteSchool("bbcc");
	}

}
