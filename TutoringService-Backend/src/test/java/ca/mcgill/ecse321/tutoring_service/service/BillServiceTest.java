package ca.mcgill.ecse321.tutoring_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoring_service.model.Bill;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillServiceTest {

	@Autowired
	private BillService service;

	@Test
	/**
	 * Test create Bill
	 */
	public void testCreateBill() {

		double amount = 99.99;
		int regId = 184;

		int size = service.getAllBills().size();

		try {
			service.createBill(amount, regId);
		} catch (IllegalArgumentException e) {
			fail();
		}

		List<Bill> allBills = service.getAllBills();

		assertEquals(1 + size, allBills.size());

		service.deleteBillByAmount(123);
	}

//	@Test
//	public void testDeleteBillById() {
//		double amount = 99.99;
//		int regId = 184;
//
//		int size = service.getAllBills().size();
//		Bill bill = new Bill();
//		try {
//			bill = service.createBill(amount, regId);
//		} catch (IllegalArgumentException e) {
//			fail();
//		}
//		int id = bill.getId();
//		List<Bill> allBills = service.getAllBills();
//
//		assertEquals(allBills.size(), allBills.size());
//
//		service.deleteBill(id);
//	}
}
