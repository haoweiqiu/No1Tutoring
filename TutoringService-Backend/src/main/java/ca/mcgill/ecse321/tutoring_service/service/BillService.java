package ca.mcgill.ecse321.tutoring_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoring_service.dao.BillRepository;
import ca.mcgill.ecse321.tutoring_service.dao.RegistrationRepository;
import ca.mcgill.ecse321.tutoring_service.model.Bill;
import ca.mcgill.ecse321.tutoring_service.model.Registration;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepo;

	@Autowired
	private RegistrationRepository registrationRepo;

	/**
	 * This is used to create the bill, and checks if the input is valid.
	 * 
	 * @param amount
	 * @param registrationId
	 * @return
	 */
	@Transactional
	public Bill createBill(double amount, int registrationId) {
		if (amount < 0) {
			throw new IllegalArgumentException("Bill amount cannot be 0!");
		}
		if (registrationId == 0) {
			throw new IllegalArgumentException("RegistrationId cannot be 0!");
		}

		Bill bill = new Bill();
		Registration regi = registrationRepo.findRegistrationById(registrationId);
		bill.setAmount(amount);
		bill.setRegistration(regi);
		regi.setBill(bill);
		registrationRepo.save(regi);
		Bill billReturn = billRepo.save(bill);

		return billReturn;

	}

	/*
	 * @Transactional public Bill createBill(double amount) { if (amount < 0) {
	 * throw new IllegalArgumentException("Bill amount cannot be 0!"); } Bill bill =
	 * new Bill(); bill.setAmount(amount); billRepo.save(bill); return bill; }
	 */

	@Transactional
	public Bill createBill(boolean isplayed) {

		Bill bill = new Bill();
		bill.setIsPayed(isplayed);
		;
		billRepo.save(bill);
		return bill;
	}

	/**
	 * This is used to delete bill by name.
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteBill(int id) {
		billRepo.deleteById(id);
		;
	}

	/**
	 * This is used to delete bills by amount
	 * 
	 * @param amount
	 */
	@Transactional
	public void deleteBillByAmount(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Bill amount cannot be 0!");
		}
		billRepo.deleteByAmount(amount);
	}

	/**
	 * Find all the bills
	 * 
	 * @return
	 */
	@Transactional
	public List<Bill> getAllBills() {
		return toList(billRepo.findAll());
	}

	private <T> List<T> toList(Iterable<T> iterable) {
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
}
