
//package ca.mcgill.ecse321.tutoring_service.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.when;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import ca.mcgill.ecse321.tutoring_service.dao.BillRepository;
//import ca.mcgill.ecse321.tutoring_service.dao.CourseRepository;
//import ca.mcgill.ecse321.tutoring_service.model.Bill;
//import ca.mcgill.ecse321.tutoring_service.model.Course;
//
//@RunWith(MockitoJUnitRunner.class)
//public class BillMockTest {
//	@Mock
//	private BillRepository billRepository;
//	
//	private Bill bill;
//
//	@InjectMocks
//	private BillService service;
//	
//	private static final String BILL_KEY = "TestBILL";
//	private static final String NONEXISTING_KEY = "NotABill";
//	
//	
//	@Test
//	public void testCreateBill(){
//		double amount = 10000;
//		Bill bill = new Bill();
//		try {
//			bill = service.createBill(amount, 184);
//		}catch (IllegalArgumentException e) {
//			// Check that no error occurred
//			fail();
//		}
//		assertEquals(String.valueOf(amount), String.valueOf(bill.getAmount()));
//	}
//}
