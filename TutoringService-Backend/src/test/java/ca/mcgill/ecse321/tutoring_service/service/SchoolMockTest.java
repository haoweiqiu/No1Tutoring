//package ca.mcgill.ecse321.tutoring_service.service;
//
//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import ca.mcgill.ecse321.tutoring_service.dao.*;
//import ca.mcgill.ecse321.tutoring_service.model.*;
//import ca.mcgill.ecse321.tutoring_service.controller.*;
//import ca.mcgill.ecse321.tutoring_service.*;
//import org.mockito.invocation.InvocationOnMock;
//import org.springframework.test.context.junit4.SpringRunner;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.fail;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class SchoolMockTest {
//	@Mock
//	private SchoolRepository schoolDao;
//
//	@InjectMocks
//	private SchoolService service;
//
//	private static final String SCHOOL_KEY = "TestSchool";
//	private static final String NONEXISTING_KEY = "NotSchool";
//
//	@Before
//	public void setMockOutput() {
//		when(schoolDao.findSchoolByName(anyString())).thenAnswer( (InvocationOnMock invocation) -> {
//			if(invocation.getArgument(0).equals(SCHOOL_KEY)) {
//				School school=new School();
//				school.setName(SCHOOL_KEY);
//				return school;
//			} else {
//				return null;
//			}
//		});
//	}
//	@Test
//	public void testCreateSchool() {
//
//		String name = "Oscar School";
//		School school = null;
//		try {
//			school = service.createSchool(name);
//		} catch (IllegalArgumentException e) {
//			// Check that no error occurred
//			fail();
//		}
//
//		assertEquals(name, school.getName());
//	}
//	@Test
//	public void testCreateStudentNull() {
//		assertEquals(0, service.getAllSchools().size());
//
//		//String name = "Oscar";
//		String error=null;
//		String name = null;
//		School school = null;
//		try {
//			school = service.createSchool(name);
//		} catch (IllegalArgumentException e) {
//			// Check that no error occurred
//			error = e.getMessage();
//		}
//		assertEquals("Student name cannot be empty!", error);
//	}
//	
//}
